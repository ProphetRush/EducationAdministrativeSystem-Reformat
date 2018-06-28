package com.prophet.EducationAdministrativeSystem.web.command.service;

import com.prophet.EducationAdministrativeSystem.web.command.exception.InvalidRequestException;

public interface ServiceRequestValidator<S, T> {
    /**
     * Request的校验
     * @param s
     * @return
     */
    public void verify(S s) throws InvalidRequestException;

    /**
     * 校验失败, 返回Response
     * @param s
     * @param e
     * @return
     */
    public T failureResponse(S s, InvalidRequestException e);
}
