package com.prophet.EducationAdministrativeSystem.dao.exception;

public class DaoServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    public DaoServiceException() {
        super();
    }

    public DaoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DaoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoServiceException(String message) {
        super(message);
    }

    public DaoServiceException(Throwable cause) {
        super(cause);
    }
}
