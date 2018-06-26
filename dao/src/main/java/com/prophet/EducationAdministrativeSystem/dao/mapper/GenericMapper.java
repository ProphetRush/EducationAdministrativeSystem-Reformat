package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GenericMapper {


    @SelectProvider(type = GenericSqlProvider.class, method = "queryByPk")
    <T> HashMap<String, Object> queryByPk(Number id, Class<T> clazz)
            throws DaoServiceException;


    @SelectProvider(type = GenericSqlProvider.class, method = "queryLike")
    <T> List<HashMap<String, Object>> queryLike(T sample) throws DaoServiceException;


    @SelectProvider(type = GenericSqlProvider.class, method = "count")
    <T> int count(Class<T> clazz) throws DaoServiceException ;


    @SelectProvider(type = GenericSqlProvider.class, method = "queryAll")
    <T> List<HashMap<String, Object>> queryAll (Class<T> clazz) throws DaoServiceException;


    @InsertProvider(type = GenericSqlProvider.class, method = "insert")
    @Options(useGeneratedKeys=true)
    <T> int insert(T daoPojo) throws DaoServiceException;


    @DeleteProvider(type = GenericSqlProvider.class, method = "delete")
    <T> int delete(T daoPojo) throws DaoServiceException;


    @UpdateProvider(type = GenericSqlProvider.class, method = "update")
    <T> int update(T daoPojo) throws DaoServiceException;

}
