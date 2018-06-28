package com.prophet.EducationAdministrativeSystem.web.command.service;

public interface ServiceCommand<S, T> {

    public T execute(S s);
}
