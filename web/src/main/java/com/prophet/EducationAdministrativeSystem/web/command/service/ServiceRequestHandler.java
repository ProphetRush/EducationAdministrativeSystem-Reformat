package com.prophet.EducationAdministrativeSystem.web.command.service;

import com.prophet.EducationAdministrativeSystem.web.command.exception.ServiceException;

public interface ServiceRequestHandler<S, T> {

    public T process(S request)throws ServiceException;

    public T handleFailure(S request, ServiceException e);

}
