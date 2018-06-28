package com.prophet.EducationAdministrativeSystem.web.validator;

import com.prophet.EducationAdministrativeSystem.web.command.exception.InvalidRequestException;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestValidator;
import com.prophet.EducationAdministrativeSystem.web.response.ResponseModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class QueryCourseValidator implements ServiceRequestValidator<HttpServletRequest, ResponseModel> {

    @Override
    public void verify(HttpServletRequest httpServletRequest) throws InvalidRequestException {

        if (httpServletRequest == null) {
            throw new InvalidRequestException("Request is null!");
        }

        if (httpServletRequest.getSession() == null) {
            throw new InvalidRequestException("Request session is null!");
        }

    }

    @Override
    public ResponseModel failureResponse(HttpServletRequest httpServletRequest, InvalidRequestException e) {

        ResponseModel resp = new ResponseModel();
        resp.setStatus("failed");
        resp.setMessage(e.getMessage());
        resp.setData(e.getCause());
        return resp;
    }
}
