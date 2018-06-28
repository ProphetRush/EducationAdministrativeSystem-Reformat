package com.prophet.EducationAdministrativeSystem.service.impl;

import com.prophet.EducationAdministrativeSystem.business.QueryCourseHandler;
import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import com.prophet.EducationAdministrativeSystem.service.CourseRelatedQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseRelatedQueryServiceImpl implements CourseRelatedQueryService {

    @Autowired
    QueryCourseHandler queryCourseHandler;

    public List<Course> getAllCourse() throws QueryServiceException {
        return queryCourseHandler.getAllCourse();
    }
}
