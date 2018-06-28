package com.prophet.EducationAdministrativeSystem.business.exception;


public class QueryServiceException extends Exception {
    
    public QueryServiceException(String remark) {
        super(remark);
    }

    public QueryServiceException(Throwable cause) {
        super(cause);
    }

    public QueryServiceException(String remark, Throwable cause) {
        super(remark, cause);
    }
}
