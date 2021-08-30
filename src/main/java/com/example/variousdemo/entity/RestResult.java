package com.example.variousdemo.entity;

import java.io.Serializable;

/**
 * @className: RestResult
 * @description:
 * @created: 2021/08/30 09:36
 */
public class RestResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public RestResult() {
    }

    public static <T> RestResult<T> ok(){
        return result(ResultCode.SUCCESS);
    }

    public static <T> RestResult<T> error(ResultCode errorCode){
        return result(errorCode);
    }

    public static<T> RestResult<T> error(ResultCode errorCode,T errInfo){
        RestResult<T> result = result(errorCode);
        result.setData(errInfo);
        return result;
    }
    public static<T> RestResult<T> ok(T data){
        RestResult<T> result = ok();
        result.setData(data);
        return result;
    }
    private static <T> RestResult<T> result(ResultCode resultCode){
        RestResult<T> restResult = new RestResult();
        restResult.setCode(resultCode.code());
        restResult.setMsg(resultCode.message());
        return restResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
