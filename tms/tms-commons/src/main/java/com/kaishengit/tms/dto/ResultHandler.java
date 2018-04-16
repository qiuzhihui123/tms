package com.kaishengit.tms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultHandler {

    private String status;
    private String message;
    private Object data;

    public ResultHandler() {
    }

    public static ResultHandler error(String message) {
        ResultHandler resultHandler = new ResultHandler();
        resultHandler.setStatus("error");
        resultHandler.setMessage(message);
        return resultHandler;
    }

    public static ResultHandler success() {
        ResultHandler resultHandler = new ResultHandler();
        resultHandler.setStatus("success");
        return resultHandler;
    }

    public static ResultHandler success(Object data) {
        ResultHandler resultHandler = new ResultHandler();
        resultHandler.setStatus("success");
        resultHandler.setData(data);
        return resultHandler;
    }

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


}
