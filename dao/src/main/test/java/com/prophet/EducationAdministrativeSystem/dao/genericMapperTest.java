package com.prophet.EducationAdministrativeSystem.dao;

import com.prophet.EducationAdministrativeSystem.dao.mapper.GenericMapper;
import com.prophet.EducationAdministrativeSystem.model.Takes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class genericMapperTest {

    @Autowired
    GenericMapper genericMapper;

    @Test
    public void getByPk() throws Exception {
        HashMap map = genericMapper.getByPk(1, Takes.class.getSimpleName().toLowerCase());
        System.out.println(map);
    }

}