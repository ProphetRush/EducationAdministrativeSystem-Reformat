package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.GenericDao;

import com.prophet.EducationAdministrativeSystem.model.*;
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
        Department department = genericDao.queryByPk(1L, Department.class);
        Classroom classroom = genericDao.queryByPk(1L, Classroom.class);
        Course course = genericDao.queryByPk(101L, Course.class);
        Instructor instructor = genericDao.queryByPk(3199L, Instructor.class);
        Section section = genericDao.queryByPk(1L, Section.class);
        Student student = genericDao.queryByPk(10076L, Student.class);
        Takes takes = genericDao.queryByPk(1L, Takes.class);
        User user = genericDao.queryByPk(1L, User.class);
    }

    @Test
    public void get() throws Exception {
        Classroom classroom = new Classroom();
        classroom.setBuilding("Chandler");
        classroom.setRoomNumber(375L);
        List<Classroom> classrooms = genericDao.queryLike(classroom);

        Instructor instructor = new Instructor();
        instructor.setSalary(105311.38);
        instructor.setDeptId(10L);
        List<Instructor> instructors = genericDao.queryLike(instructor);

    }

    @Test
    public void testCount() throws Exception {
        System.out.println(genericDao.count(Instructor.class));
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Instructor> instructors = genericDao.queryAll(Instructor.class);
    }

    @Test
    public void testInsert() throws Exception {
        Department department = new Department();
        department.setBudget(354646531.1654);
        department.setBuilding("asdf");
        department.setDeptName("alubf");
        System.out.println(genericDao.insert(department));
    }

    @Test
    public void testInsertList() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {
        Department department = new Department();
        department.setBuilding("asdf");
        System.out.println(genericDao.delete(department));
    }


    @Test
    public void testUpdate() throws Exception {

        Department department = genericDao.queryByPk(23L, Department.class);
        department.setDeptName("segwgerte");
        System.out.println(genericDao.update(department));

    }

    @Test
    public void fuzzyQueryTest() throws Exception {

    }
}