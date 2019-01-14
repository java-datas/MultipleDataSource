package com.alimama.entity;


/**
 * Created by zhangshuman on 2018/5/8.
 */
public class Result<T> {

    private String  errorCode;//错误码
    private Boolean isSuccess;//状态
    private String desc;//错误描述
    private T data;//返回具体内容

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}