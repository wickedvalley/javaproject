package com.jackchen;

/**
 * Created by MinZeng
 * 时间：2018/9/17.
 */
public class ApiException extends RuntimeException {

    private Integer code;

    private String message;

    public ApiException(Icode icode) {
        this.code = icode.getCode();
        this.message = icode.getName();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
