package com.prophet.EducationAdministrativeSystem.web.service;

import com.prophet.EducationAdministrativeSystem.web.command.ServiceCommandImpl;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceCommand;
import com.prophet.EducationAdministrativeSystem.web.handler.QueryCourseHandler;
import com.prophet.EducationAdministrativeSystem.web.response.ResponseModel;
import com.prophet.EducationAdministrativeSystem.web.validator.QueryCourseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class CourseRelatedQueryService {

    @Autowired
    QueryCourseHandler queryCourseHandler;

    @Autowired
    QueryCourseValidator queryCourseValidator;


    @RequestMapping("/queryCourse")
    public @ResponseBody String queryCourse(HttpServletRequest request) {

        ServiceCommand<HttpServletRequest, ResponseModel> command =
                new ServiceCommandImpl<>(queryCourseHandler, queryCourseValidator);

        return command.execute(request).toJSON();
    }


}
