package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.mysql.cj.util.StringUtils;
import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class SqlProviderTools {

    /**
     * get the field name of the field which represent ID in a entity
     * @param clazz class
     * @return Field name
     * @throws DaoServiceException  Exception
     */
    public static String getIdFieldName(Class clazz) throws DaoServiceException {

        Field[] fields = clazz.getDeclaredFields();

        if(fields.length <= 0) {
            throw new DaoServiceException("Invalid enetity pojo, no declared field!");
        }

        for (Field f: fields) {
            if (f.getAnnotation(ID.class) != null) {
                return f.getName();
            }
        }

        throw new DaoServiceException("Invalid entity pojo, no ID field set");
    }



    /**
     * get a list of field names of criteria
     * @param t instance
     * @param <T>   t
     * @return  List
     * @throws DaoServiceException  Exception
     */
    public static <T> List<String> getCriteriaFieldNames(T t) throws DaoServiceException {

        Field[] fields = t.getClass().getDeclaredFields();

        if(fields.length <= 0) {
            throw new DaoServiceException("Invalid enetity pojo, no declared field!");
        }

        List<String> criterias = new LinkedList<>();

        for (Field f: fields) {

            f.setAccessible(true);

            try {
                if (f.get(t) != null) {

                    criterias.add(f.getName());
                }
            } catch (IllegalAccessException e) {
                throw new DaoServiceException("Illegal Access to pojo!");
            }

        }

        return criterias;
    }



    /**
     * Transform the result Map into a real object
     * @param parameterMap  resultMap
     * @param clazz the class of the the real object which would be transform into
     * @param <T>   generics
     * @return  T object
     * @throws DaoServiceException  Exception
     */
    public static <T> T toObject(Map<String, Object> parameterMap, Class<T> clazz) throws DaoServiceException {

        if(parameterMap == null) {
            return null;
        }

        T t = null;

        try {
            t = clazz.newInstance();
        } catch (Exception e) {
            throw new DaoServiceException("Instantiation of bean failed", e);
        }

        for (Map.Entry<String, Object> entry: parameterMap.entrySet()) {

            String key = entry.getKey();
            Serializable value = (Serializable) entry.getValue();
            setObjectFieldValue(t, key, value);
        }

        return t;
    }


    /**
     * Transform the result Map List into a object instants list
     * @param resultMaps    the result map list
     * @param clazz class type
     * @param <T>   generics
     * @return  list
     * @throws DaoServiceException  Exception
     */
    public static <T> List<T> toObjectList(List<HashMap<String, Object>> resultMaps,
                                           Class<T> clazz) throws DaoServiceException {

        List<T> resultList = new LinkedList<>();

        if(resultMaps == null) {
            return resultList;
        }

        for (Map<String, Object> map : resultMaps) {
            T t = toObject(map, clazz);

            if (t != null) {
                resultList.add(t);
            }
        }

        return resultList;
    }



    /**
     * Invoke setter of a bean to set field value of an object
     * @param t   object
     * @param key   the field name
     * @param value the field value
     * @param <T>   object class type
     * @return T object
     * @throws DaoServiceException Exception
     */
    private static <T> void setObjectFieldValue(T t, String key, Serializable value) throws  DaoServiceException {

        try{

            Method method;

            if(value.getClass() == Integer.class) {

                method = t.getClass().getMethod(getNormalizeSetterName(key), Long.class);
                method.invoke(t, new Long(((Integer) value)));
            } else if (value.getClass() == BigDecimal.class) {

                method = t.getClass().getMethod(getNormalizeSetterName(key), Double.class);
                method.invoke(t, ((BigDecimal)value).doubleValue());
            } else {
                method = t.getClass().getMethod(getNormalizeSetterName(key), value.getClass());
                method.invoke(t, value);
            }



        } catch (Exception e) {
            throw new DaoServiceException("Error when inject with bean!", e);
        }
    }



    /**
     * Transform the key name into setter name
     * @param keyName key name
     * @return String name of setter
     */
    private static String getNormalizeSetterName(String keyName) {

        if (keyName.length() <= 0) {
            return "";
        }

        keyName = keyName.toLowerCase();

        if (keyName.contains("_")) {

            char[] keyNameArray = keyName.toCharArray();
            List<Character> res = new LinkedList<>();

            res.add(Character.toUpperCase(keyNameArray[0]));

            for (int i = 1; i < keyNameArray.length; i++) {

                if (keyNameArray[i] != '_') {

                    res.add(keyNameArray[i]);
                } else {
                    if(i < keyNameArray.length-1) {
                        res.add(Character.toUpperCase(keyNameArray[i+1]));
                        i++;
                    }
                }
            }

            keyNameArray = new char[res.size()];

            for (int i = 0; i < res.size(); i++) {
                keyNameArray[i] = res.get(i);
            }

            return "set" + new String(keyNameArray);
        }

        keyName = keyName.substring(0,1).toUpperCase() + keyName.substring(1);

        return "set" + keyName;
    }


    /**
     * Tranform a field name to DB Colunm name
     * Example: secId -> sec_id
     * @param fieldName field name
     * @return  String db column name
     */
    public static String toDBColumnName(String fieldName) {

        if(StringUtils.isNullOrEmpty(fieldName)) {
            return fieldName;
        }

        List<Character> charList = new LinkedList<>();

        for (int i = 0; i < fieldName.length(); i++) {

            if (Character.isUpperCase(fieldName.charAt(i))) {
                charList.add('_');
            }

            charList.add(Character.toLowerCase(fieldName.charAt(i)));
        }

        char[] chars = new char[charList.size()];

        for (int i = 0; i < charList.size(); i++) {
            chars[i] = charList.get(i);
        }

        return new String(chars);
    }


    /**
     * Transform creteria names into db column name format
     * @param criteriaNames field name
     * @return list
     */
    public static <T> Map<String, Object> toDBColumnNameMap(List<String> criteriaNames,
                                                              T record) throws DaoServiceException {

        Map<String, Object> DBColumnNameMap = new HashMap<>();

        if (CollectionUtils.isEmpty(criteriaNames)) {
            return DBColumnNameMap;
        }

        try {
            for (String name: criteriaNames) {

                Field field = record.getClass().getDeclaredField(name);
                field.setAccessible(true);

                DBColumnNameMap.put(toDBColumnName(name), name);
            }
        } catch (Exception e) {
            throw new DaoServiceException("Converting inserted field error, ", e);
        }

        return DBColumnNameMap;
    }




}
