package com.prophet.EducationAdministrativeSystem.web.command.exception;

public class ServiceCommandInitializeException extends RuntimeException {

    public ServiceCommandInitializeException(){

    }

    public ServiceCommandInitializeException(String remark) {
        super(remark);
    }

    public ServiceCommandInitializeException(Throwable cause) {
        super(cause);
    }

    public ServiceCommandInitializeException(String remark, Throwable cause) {
        super(remark, cause);
    }
}
