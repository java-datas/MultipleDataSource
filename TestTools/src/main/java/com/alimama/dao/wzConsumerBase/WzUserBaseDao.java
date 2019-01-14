package com.alimama.dao.wzConsumerBase;


import com.alimama.entity.wzConsumerBase.WzUserBaseEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangshuman on 2018/12/27.
 */

public interface WzUserBaseDao {

    Boolean deleteUserBase(Long userId);

    WzUserBaseEntity selectUserBaseInfo(@Param("userId") Long userId) ;

}
