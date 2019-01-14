package com.alimama.controller;

import com.alimama.entity.Result;
import com.alimama.entity.tuiaConsumer.WzUserEntity;
import com.alimama.entity.wzConsumerBase.WzUserBaseEntity;
import com.alimama.service.WzUserService;
import com.alimama.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangshuman on 2018/12/26.
 */

@RestController
@RequestMapping("/wzUser")
public class WzUserController extends BaseController{

    @Resource
    private WzUserService wzUserService;

    //查询用户所有完整信息
    @RequestMapping(value ="/AllInfo",method = RequestMethod.GET)
    public Result getWzUser(Long userId){
        try {
            WzUserEntity wzUserEntity = wzUserService.getWzUser(userId);
            return ResultUtil.successWithData(wzUserEntity,"查询用户的登录信息成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.failResult("查询登录信息失败","ERROR200");
        }
    }
    //查询用户的微信信息
    @RequestMapping(value ="/baseInfo",method = RequestMethod.GET)
    public Result getWzUserBase(Long userId){
        try {
            WzUserBaseEntity wzUserBaseEntity = wzUserService.selectUserBase(userId);
            return ResultUtil.successWithData(wzUserBaseEntity,"查询用户的微信信息成功");
        }catch (Exception e){
            return ResultUtil.failResult("查询微信信息失败","ERROR201");
        }
    }

    //删除用户信息
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Result deleteUserById(Long userId){
       try {
           wzUserService.deleteUser(userId);
           return ResultUtil.successWithDesc("删除用户成功");
       }catch (Exception e){
           return ResultUtil.failResult("删除失败","ERROR202");
       }
    }

    //修改VIP属性
    @RequestMapping(value = "/updateVip",method = RequestMethod.GET)
    public Result updateUserVip(Integer vip,Long userId){
        try{
            if(userId ==null){
                return ResultUtil.failResult("请输入用户id","ERROR204");
            }else if(vip ==null || vip >1){
                return ResultUtil.failResult("请输入是否升级会员","ERROR205");
            }
            wzUserService.updateVip(vip,userId);
            if (vip==0){
                return ResultUtil.successWithDesc("恭喜你，用户设置为普通用户");
            }else
                return ResultUtil.successWithDesc("恭喜你，用户设置为VIP用户");
        }catch (Exception e){
            return ResultUtil.failResult("更新失败","ERROR203");
        }

    }

    //生成手机号码注册的用户
    @RequestMapping(value = "/registeredByPhone",method = RequestMethod.GET)
    public Result registeredByPhone(){
        Long userId =   wzUserService.registeredByPhone();
        return ResultUtil.successWithDesc("恭喜你，手机号码注册成功,你的用户Id 是："+userId);

    }
}
