package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class GenericMapperTest {

    @Autowired
    GenericMapper mapper;

    @Test
    public void getByPk() throws Exception {
        System.out.println(mapper.queryUserByPk(1));
    }

    @Test
    public void get() throws Exception {
        User user = new User();
        user.setPassword(null);
        List<User> users = mapper.queryLike(user);
    }
}