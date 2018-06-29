package com.prophet.EducationAdministrativeSystem.service.impl;

import com.prophet.EducationAdministrativeSystem.business.QueryCourseHandler;
import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import com.prophet.EducationAdministrativeSystem.service.CourseRelatedQueryService;
import com.prophet.EducationAdministrativeSystem.service.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Component
public class CourseRelatedQueryServiceImpl implements CourseRelatedQueryService {

    @Autowired
    QueryCourseHandler queryCourseHandler;

    public List<Course> getAllCourse() throws QueryServiceException {
        return queryCourseHandler.getAllCourse();
    }


    public List<Course> queryCourse(Map<String, String[]> parameterMap) throws QueryServiceException {

        List<Course> result = new LinkedList<Course>();

        if (parameterMap.size() <= 0) {
            return result;
        }

        Course sample = ServiceUtils.injectParameterToObj(parameterMap, Course.class);

        if (sample == null) {
            return result;
        }

        return queryCourseHandler.queryCourse(sample);
    }




}
