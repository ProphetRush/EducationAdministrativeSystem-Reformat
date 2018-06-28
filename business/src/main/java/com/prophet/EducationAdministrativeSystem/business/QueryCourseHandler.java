package com.prophet.EducationAdministrativeSystem.business;

import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QueryCourseHandler {

    List<Course>  queryCourse(Course sample) throws QueryServiceException;

    List<Course> getAllCourse() throws QueryServiceException;
}
