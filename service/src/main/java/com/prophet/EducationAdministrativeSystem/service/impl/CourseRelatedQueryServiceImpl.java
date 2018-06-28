package com.prophet.EducationAdministrativeSystem.service.impl;

import com.prophet.EducationAdministrativeSystem.business.QueryCourseHandler;
import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import com.prophet.EducationAdministrativeSystem.service.CourseRelatedQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CourseRelatedQueryServiceImpl implements CourseRelatedQueryService {

    @Autowired
    QueryCourseHandler queryCourseHandler;

    public List<Course> getAllCourse() throws QueryServiceException {
        return queryCourseHandler.getAllCourse();
    }

    public List<Course> queryCourse(Map<String, String[]> parameterMap) throws QueryServiceException {


    }

    private <T> T injectParameterToObj(Map<String, String[]> parameterMap, Class<T> clazz) throws QueryServiceException {

        try {
            Map<String, Object> map = new HashMap<String, Object>();

            T t = clazz.newInstance();

            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {

                String key = entry.getKey();

                Class fieldType = t.getClass().getDeclaredField(key).getType();

                map.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            throw new QueryServiceException("Cannot inject parameter into instance!");
        }


    }
}
