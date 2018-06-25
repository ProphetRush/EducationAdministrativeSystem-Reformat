package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.model.User;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;

public interface GenericMapper {


    @SelectProvider(type = GenericSqlProvider.class, method = "queryByPk")
    <T> T queryByPk(Number id, Class<T> clazz)
            throws DaoServiceException;


    @SelectProvider(type = GenericSqlProvider.class, method = "queryLike")
    <T> List<T> queryLike(T sample) throws DaoServiceException;

    @SelectProvider(type = GenericSqlProvider.class, method = "queryUserByPk")
    HashMap queryUserByPk(Number id)
            throws DaoServiceException;


//    @SelectProvider(type = GenericSqlProvider.class, method = "count")
//    public <T> int count(Class<T> clazz) throws DaoServiceException ;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "queryAll")
//    public <T> List<T> queryAll (Class<T> clazz) throws DaoServiceException;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "insert")
//    public <T> int insert(T daoPojo, Class<T> clazz) throws DaoServiceException;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "insert")
//    public <T> int[] insert(List<T> daoPojos, Class<T> clazz) throws DaoServiceException;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "delete")
//    public <T> int delete(T daoPojo, Class<T> clazz) throws DaoServiceException;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "delete")
//    public <T> int[] delete(List<T> daoPojos, Class<T> clazz) throws DaoServiceException;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "update")
//    public <T> int update(T daoPojo, Class<T> clazz) throws DaoServiceException;
//
//
//    @SelectProvider(type = GenericSqlProvider.class, method = "update")
//    public <T> int[] update(List<T> daoPojos, Class<T> clazz) throws DaoServiceException;
}
