package com.alimama.dao.tuiaConsumer;

import com.alimama.entity.tuiaConsumer.WzUserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangshuman on 2018/12/26.
 */

public interface WzUserDao {

    WzUserEntity selectOneUser(@Param("userId") Long userId) ;

    Boolean deleteUser(Long userId);

    Boolean updateUserVip(@Param("vip") Integer vip,@Param("userId") Long userId);

    Boolean registeredByPhone(WzUserEntity wzUserEntity);
}
