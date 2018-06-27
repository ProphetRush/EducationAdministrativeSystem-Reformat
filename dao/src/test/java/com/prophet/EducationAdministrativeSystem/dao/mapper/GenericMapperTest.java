package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.GenericDao;

import com.prophet.EducationAdministrativeSystem.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.LinkedList;
import java.util.List;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class GenericMapperTest {

    @Autowired
    GenericMapper mapper;

    @Autowired
    GenericDao genericDao;

    @Test
    public void getByPk() throws Exception {
        Department department = genericDao.queryByPk(1, Department.class);
    }

    @Test
    public void get() throws Exception {


    }

    @Test
    public void testCount() throws Exception {

    }

    @Test
    public void testQueryAll() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertList() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }


    @Test
    public void testUpdate() throws Exception {



    }
}