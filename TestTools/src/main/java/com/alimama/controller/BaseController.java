package com.alimama.controller;

import org.springframework.validation.BindingResult;

/**
 * Created by zhangshuman on 2018/5/10.
 */

public class BaseController {

    protected String checkErroMsg(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            List<ObjectError> ls = bindingResult.getAllErrors();
//            List<String> erroMsgList = ls.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
//            return (StringUtils.join(erroMsgList,","));

        }
        return null;
    }
}
