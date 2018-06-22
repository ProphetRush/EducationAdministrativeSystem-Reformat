package com.prophet.EducationAdministrativeSystem.dao.impl;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.dao.service.GenericDaoService;

import java.util.List;

public class genericDaoServiceImpl implements GenericDaoService {

    @Override
    public <T> T queryByPk(Number id, Class<T> clazz) throws DaoServiceException {
        return null;
    }

    @Override
    public <T> List<T> queryLike(T sample, Class<T> clazz) throws DaoServiceException {
        return null;
    }

    @Override
    public <T> int count(Class<T> clazz) throws DaoServiceException {
        return 0;
    }

    @Override
    public <T> List<T> queryAll(Class<T> clazz) throws DaoServiceException {
        return null;
    }

    @Override
    public <T> int insert(T daoPojo, Class<T> clazz) throws DaoServiceException {
        return 0;
    }

    @Override
    public <T> int[] insert(List<T> daoPojos, Class<T> clazz) throws DaoServiceException {
        return new int[0];
    }

    @Override
    public <T> int delete(T daoPojo, Class<T> clazz) throws DaoServiceException {
        return 0;
    }

    @Override
    public <T> int[] delete(List<T> daoPojos, Class<T> clazz) throws DaoServiceException {
        return new int[0];
    }

    @Override
    public <T> int update(T daoPojo, Class<T> clazz) throws DaoServiceException {
        return 0;
    }

    @Override
    public <T> int[] update(List<T> daoPojos, Class<T> clazz) throws DaoServiceException {
        return new int[0];
    }
}
