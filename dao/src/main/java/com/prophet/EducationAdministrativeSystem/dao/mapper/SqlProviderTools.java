package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

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
}
