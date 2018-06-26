package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.GenericDao;
import com.prophet.EducationAdministrativeSystem.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.*;

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
        User user = genericDao.queryByPk(1, User.class);
    }

    @Test
    public void get() throws Exception {
        User user = new User();
        user.setPassword(null);
        List<User> users = genericDao.queryLike(user);

        user.setPassword("sdgsg");
        user.setId(354L);
        users = genericDao.queryLike(user);

        user = new User();
        user.setId(1L);
        users = genericDao.queryLike(user);

        user.setPassword("sdgsg'");
        users = genericDao.queryLike(user);

        user.setSecId("2354651");
        users = genericDao.queryLike(user);

    }

    @Test
    public void testCount() throws Exception {
        System.out.println(genericDao.count(User.class));
    }

    @Test
    public void testQueryAll() throws Exception {
        List<User> users = genericDao.queryAll(User.class);
    }

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setPassword("sdfsdfsf");
        user.setUsername("sgddsgdg");
        System.out.println(genericDao.insert(user));
    }

    @Test
    public void testInsertList() throws Exception {
        User user1 = new User();
        user1.setPassword("sdfsdfsf");
        user1.setUsername("sgddsgdg");

        User user2 = new User();
        user2.setPassword("sdfsdfsf");
        user2.setUsername("sgddsgdg");

        List<User> users = new LinkedList<>();

        users.add(user1);
        users.add(user2);

        System.out.println(genericDao.insert(users));
    }

    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setUsername("sgddsgdg");
        System.out.println(genericDao.delete(user));
    }


    @Test
    public void testUpdate() throws Exception {

        User user = genericDao.queryByPk(15, User.class);
        user.setSecId("35435");
        System.out.println(genericDao.update(user));

    }
}