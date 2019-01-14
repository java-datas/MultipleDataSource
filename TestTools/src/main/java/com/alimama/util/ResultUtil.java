package com.alimama.util;

import com.alimama.entity.Result;

import static java.lang.String.format;

/**
 * Created by zhangshuman on 2018/5/10.
 */
public class ResultUtil {

    private ResultUtil(){
        throw new IllegalStateException("Util Class");
    }

    /**
     * 返回失败结果 错误码和错误描述
     * @param desc
     * @param errorCode
     * @param args
     * @param <T>
     * @return
     */
    public static <T> Result<T> failResult(String desc,String errorCode,Object... args){
        Result<T> result = new Result<>();
        result.setErrorCode(errorCode);
        result.setDesc(format(desc,args));
        result.setSuccess(false);
        return result;
    }

    /**
     * 返回成功结果 具体数据和状态
     * @param data
     * @param desc
     * @param <T>
     * @return
     */
    public static <T> Result<T>successWithData(T data,String desc){
        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);
        result.setErrorCode("0");
        result.setDesc(desc);
        return result;
    }

    /**
     * 返回成功结果 不带返回数据，一句话描述
     * @param desc
     * @param <T>
     * @return
     */
    public static <T> Result<T> successWithDesc(String desc){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setDesc(desc);
        result.setErrorCode("0");
        return result;
    }
}
