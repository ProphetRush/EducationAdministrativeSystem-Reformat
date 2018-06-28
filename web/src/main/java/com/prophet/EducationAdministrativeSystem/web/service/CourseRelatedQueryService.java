package com.prophet.EducationAdministrativeSystem.web.service;

import com.prophet.EducationAdministrativeSystem.web.command.ServiceCommandImpl;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceCommand;
import com.prophet.EducationAdministrativeSystem.web.handler.CourseRelatedQueryHandlerImpl;
import com.prophet.EducationAdministrativeSystem.web.response.ResponseModel;
import com.prophet.EducationAdministrativeSystem.web.validator.CourseRelatedQueryValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class CourseRelatedQueryService {

    @Autowired
    CourseRelatedQueryHandlerImpl courseRelatedQueryHandler;

    @Autowired
    CourseRelatedQueryValidatorImpl courseRelatedQueryValidator;


    @RequestMapping("/getAllCourse")
    public @ResponseBody String getAllCourse(HttpServletRequest request) {

        ServiceCommand<HttpServletRequest, ResponseModel> command =
                new ServiceCommandImpl<>(courseRelatedQueryHandler);

        return command.execute(request).toJSON();
    }
}
