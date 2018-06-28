package com.prophet.EducationAdministrativeSystem.web.command;

import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceCommand;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestHandler;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestValidator;

public class ServiceCommandImpl<S, T> extends AbstractServiceCommand<S, T> implements ServiceCommand<S, T> {

    private ServiceRequestHandler<S, T> requestHandler;

    private ServiceRequestValidator<S, T> requestValidator;


    public ServiceCommandImpl(ServiceRequestHandler<S, T> requestHandler, ServiceRequestValidator<S, T> requestValidator) {
        this.requestHandler = requestHandler;
        this.requestValidator = requestValidator;
    }

    public ServiceCommandImpl(ServiceRequestHandler<S, T> requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public T execute(S request) {
        return super.execute(request);
    }


    public ServiceRequestHandler<S, T> getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(ServiceRequestHandler<S, T> requestHandler) {
        this.requestHandler = requestHandler;
    }

    public ServiceRequestValidator<S, T> getRequestValidator() {
        return requestValidator;
    }

    public void setRequestValidator(ServiceRequestValidator<S, T> requestValidator) {
        this.requestValidator = requestValidator;
    }
}
