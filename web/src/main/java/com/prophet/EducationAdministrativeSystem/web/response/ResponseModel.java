package com.prophet.EducationAdministrativeSystem.web.response;
import com.alibaba.fastjson.JSON;


public class ResponseModel {

    private String status;
    private String message;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toJSON(){
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return this.toJSON();
    }


}
