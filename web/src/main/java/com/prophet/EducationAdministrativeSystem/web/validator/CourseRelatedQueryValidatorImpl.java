package com.prophet.EducationAdministrativeSystem.web.validator;

import com.prophet.EducationAdministrativeSystem.web.command.exception.InvalidRequestException;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestValidator;
import com.prophet.EducationAdministrativeSystem.web.response.ResponseModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CourseRelatedQueryValidatorImpl implements ServiceRequestValidator<HttpServletRequest, ResponseModel> {

    @Override
    public void verify(HttpServletRequest httpServletRequest) throws InvalidRequestException {

    }

    @Override
    public ResponseModel failureResponse(HttpServletRequest httpServletRequest, InvalidRequestException e) {
        return null;
    }
}
