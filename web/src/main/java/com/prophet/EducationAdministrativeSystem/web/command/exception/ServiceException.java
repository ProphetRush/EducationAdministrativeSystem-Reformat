package com.prophet.EducationAdministrativeSystem.web.command.exception;

public class ServiceException extends Exception {

    private String remark;

    public ServiceException() {super(); }

    public ServiceException(String remark) {
        super(remark);
    }

    public ServiceException(String remark, Throwable cause) {
        super(remark, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
