package com.example.variousdemo.entity;

import org.apache.log4j.MDC;

import java.util.Optional;

public class Result<T> {
    private Integer responseCode;
    private String responseMsg;
    private Boolean isSuccess;
    private T data;
    private Long count;
    private String hcReqId;

    public Result(T data) {
        this(true,0,"请求成功",data,null);
    }

    public Result(T data, Long count) {
        this(true,0,"请求成功",data,count);
    }

    public Result(Boolean isSuccess,Integer responseCode,String responseMsg,T data,Long count) {
        String hcReqId = Optional.ofNullable(MDC.get("hcReqId")).map(x -> x.toString()).orElse(null);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.isSuccess = isSuccess;
        this.data = data;
        this.count = count;
        this.hcReqId = hcReqId;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getHcReqId() {
        return hcReqId;
    }

    public void setHcReqId(String hcReqId) {
        this.hcReqId = hcReqId;
    }
}
