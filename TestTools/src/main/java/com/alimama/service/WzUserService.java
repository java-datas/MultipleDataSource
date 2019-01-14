package com.alimama.service;

import com.alimama.entity.wzConsumerBase.WzUserBaseEntity;
import com.alimama.rsp.WzUserEntityRsp;

/**
 * Created by zhangshuman on 2018/12/26.
 */
public interface WzUserService {

    //查询用户所有完整信息
    WzUserEntityRsp getWzUser(Long userId) ;

    //查询用户微信信息
    WzUserBaseEntity selectUserBase(Long userId);

    //删除用户
    Boolean deleteUser(Long userId);

    //更改用户VIP属性
    Boolean updateVip(Integer vip,Long userId);

    Long registeredByPhone();


}
