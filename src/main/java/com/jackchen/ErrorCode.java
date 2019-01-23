package com.jackchen;

/**
 * Created by MinZeng
 * 时间：2018/9/17.
 */
public enum ErrorCode implements Icode {

    //9000银行卡异常码
    CARD_LENGTH_ERROR(9000, "卡片长度错误"),
    CARD_FOMATE_ERROR(9001, "卡片格式错误"),
    CARD_INFO_NOT_EXIST(9002, "卡片信息不存在");


    private Integer code;
    private String name;

    ErrorCode(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
