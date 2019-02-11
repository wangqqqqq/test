package com.tron.automation.core;

public class Result {
    public Boolean success = false;

    public Integer code;

    public String message;

    public Result() {
    }

    public Result(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
