package com.prophet.EducationAdministrativeSystem.service;

import com.mysql.cj.util.StringUtils;
import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.dao.mapper.SqlProviderTools;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ServiceUtils {

    public static <T> T injectParameterToObj(Map<String, String[]> parameterMap
            , Class<T> clazz) throws QueryServiceException {

        try {
            Map<String, Object> map = new HashMap<String, Object>();

            T t = clazz.newInstance();

            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {

                if (entry.getValue().length == 0 || StringUtils.isNullOrEmpty(entry.getValue()[0].trim())) {
                    continue;
                }

                String key = entry.getKey();
                Class fieldType = t.getClass().getDeclaredField(key).getType();

                if (fieldType == String.class) {
                    map.put(key, entry.getValue()[0]);
                    continue;
                }

                Method method = fieldType.getMethod("valueOf", String.class);

                Object fieldObj = method.invoke(null, entry.getValue()[0]);


            }

            return SqlProviderTools.toObject(map, clazz);
        } catch (Exception e) {
            throw new QueryServiceException("Cannot inject parameter into instance!");
        }


    }
}
