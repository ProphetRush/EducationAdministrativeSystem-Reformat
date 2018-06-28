package com.prophet.EducationAdministrativeSystem.service;

import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Component
public interface CourseRelatedQueryService {

    List<Course> getAllCourse() throws QueryServiceException;

    List<Course> queryCourse(Map<String, String[]> parameterMap) throws QueryServiceException;
}
