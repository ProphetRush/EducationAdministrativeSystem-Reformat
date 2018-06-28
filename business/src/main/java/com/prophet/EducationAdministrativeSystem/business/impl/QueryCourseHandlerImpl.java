package com.prophet.EducationAdministrativeSystem.business.impl;

import com.prophet.EducationAdministrativeSystem.business.QueryCourseHandler;
import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.dao.GenericDao;
import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryCourseHandlerImpl implements QueryCourseHandler {

    @Autowired
    private GenericDao genericDao;

    public List<Course> getAllCourse() throws QueryServiceException {

        try {
            return genericDao.queryAll(Course.class);
        } catch (DaoServiceException e) {
            throw new QueryServiceException("数据库异常!", e);
        }

    }
}
