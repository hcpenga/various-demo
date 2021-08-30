package com.example.variousdemo.entity;

import java.io.Serializable;

public enum ResultCode implements Serializable {
    ERROR(-1,"捕获到异常,运行结果失败"),
    SUCCESS(0,"成功");
    private Integer code;
    private String msg;

    private ResultCode(Integer code ,String message){
        this.code = code;
        this.msg = message;
    }

    public Integer code() {
        return code;
    }


    public String message() {
        return msg;
    }

}
