package com.prophet.EducationAdministrativeSystem.service;

import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseRelatedQueryService {

    List<Course> getAllCourse() throws QueryServiceException;
}
