package com.alimama.dao.impl.tuiaConsumer;

import com.alimama.dao.base.BaseDao;
import com.alimama.dao.tuiaConsumer.WzUserDao;
import com.alimama.entity.tuiaConsumer.WzUserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangshuman
 * @Date: 2018/12/26 0026 20:08
 */
@Repository
public class WzUserDaoImpl extends BaseDao {


//    public WzUserEntity selectOneUser(Long userId) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("userId",userId);
//        WzUserEntity wzUserDao = getTuia_consumerSqlSessionTemplate().selectOne(getStatementNameSpace("selectOneUser"),map);
//        return wzUserDao;
//    }
//
//
//    public Boolean deleteUser(Long id) {
//        if(getTuia_consumerSqlSessionTemplate().delete(getStatementNameSpace("deleteUser"),id)> 0) {
//            return true;
//        }
//        return false;
//    }
//
//    public Boolean updateUserVip(@Param("vip") Integer vip, @Param("userId") Long userId) {
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("vip",vip);
//        map.put("userId",userId);
//
//        if(getTuia_consumerSqlSessionTemplate().update(getStatementNameSpace("updateUserVip"),map)>0){
//            return true;
//        }
//        return false;
//    }
//
//
//    public Boolean registeredByPhone(WzUserEntity wzUserEntity) {
//
//        if(getTuia_consumerSqlSessionTemplate().insert(getStatementNameSpace("registeredByPhone"),wzUserEntity)==1){
//            return true;
//        }
//        return false;
//    }
//}
}
