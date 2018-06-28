package com.prophet.EducationAdministrativeSystem.web.command;

import com.prophet.EducationAdministrativeSystem.web.command.exception.InvalidRequestException;
import com.prophet.EducationAdministrativeSystem.web.command.exception.ServiceCommandInitializeException;
import com.prophet.EducationAdministrativeSystem.web.command.exception.ServiceException;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceCommand;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestHandler;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestValidator;

public abstract class AbstractServiceCommand<S,T> implements ServiceCommand<S, T> {

    private ServiceRequestHandler<S, T> requestHandler;

    private ServiceRequestValidator<S, T> requestValidator;

    private volatile boolean isInitialized;

    public AbstractServiceCommand() {

    }


    private void tryInit() {

        if(isInitialized) {
            return;
        }

        requestHandler = this.getRequestHandler();
        requestValidator = getRequestValidator();

        if (requestHandler == null) {
            throw new ServiceCommandInitializeException("Handler cannot be null, Initiation failed!");
        }

        isInitialized = true;
    }

    @Override
    public T execute(S request) {

        tryInit();

        try{

            if (request == null) {
                throw new InvalidRequestException("Request cannot be null!");
            }

            verify(request);

            return process(request);

        } catch (InvalidRequestException e) {

            return requestValidator.failureResponse(request, e);
        } catch (ServiceException e) {

            return requestHandler.handleFailure(request, e);
        }

    }


    private void verify(S request) throws InvalidRequestException {

        if (requestValidator == null) {
            return;
        }

        requestValidator.verify(request);
    }


    private T process(S request) throws ServiceException {

        return requestHandler.process(request);
    }

    abstract protected ServiceRequestHandler<S, T> getRequestHandler();

    protected ServiceRequestValidator<S, T> getRequestValidator() {
        return null;
    }
}
