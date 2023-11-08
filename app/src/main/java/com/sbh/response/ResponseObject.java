package com.sbh.response;

public class ResponseObject {
    private boolean result;
    private int status_code;
    private String message;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
