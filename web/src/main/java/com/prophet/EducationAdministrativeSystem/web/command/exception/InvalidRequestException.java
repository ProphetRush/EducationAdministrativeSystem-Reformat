package com.prophet.EducationAdministrativeSystem.web.command.exception;

public class InvalidRequestException extends ServiceException {

    public InvalidRequestException(){

    }

    public InvalidRequestException(String remark) {
        super(remark);
    }

    public InvalidRequestException(Throwable cause) {
        super(cause);
    }

    public InvalidRequestException(String remark, Throwable cause) {
        super(remark, cause);
    }




}
