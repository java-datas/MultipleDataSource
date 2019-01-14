package com.alimama.dao.impl.wzConsumerBase;

import com.alimama.dao.base.BaseDao;
import com.alimama.dao.wzConsumerBase.WzUserBaseDao;
import com.alimama.entity.wzConsumerBase.WzUserBaseEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangshuman on 2018/12/27.
 */
@Repository("WzUserBaseDao")
public class WzUserBaseImpl extends BaseDao {

//    //删除用户
//
//    public Boolean deleteUserBase(Long userId) {
//        if(getWz_consumer_baseSqlSessionTemplate().delete(getStatementNameSpace("deleteUserBase"),userId)>0)
//        {
//            return true;
//        }
//        return false;
//    }
//
//    //查询用户基础信息
//
//    public WzUserBaseEntity selectUserBaseInfo(Long userId) {
//        WzUserBaseEntity wzUserBaseEntity = getWz_consumer_baseSqlSessionTemplate().selectOne("selectUserBaseInfo",userId);
//        return wzUserBaseEntity;
//    }

}
