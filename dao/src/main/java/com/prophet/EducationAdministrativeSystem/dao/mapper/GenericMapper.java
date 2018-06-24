package com.prophet.EducationAdministrativeSystem.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;


public interface GenericMapper {


    HashMap getByPk(@Param("id") Number id, @Param("className") String className);

}
