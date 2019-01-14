package com.alimama.dao.impl.tuiaConsumer;

import com.alimama.dao.base.BaseDao;
import com.alimama.dao.tuiaConsumer.TbKeyIdDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangshuman on 2019/1/12.
 */
@Repository
public class TbKeyIdDaoImpl extends BaseDao  {


//    public Long getKeyIdByTableName(String tableName) {
//        Long keyId= getTuia_consumerSqlSessionTemplate().selectOne(getStatementNameSpace("getKeyIdByTableName"),tableName);
//        return keyId;
//    }
//
//
//    public Boolean updateKeyId(Long keyId, String tableName) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("keyId",keyId);
//        map.put("tableName",tableName);
//        if(getTuia_consumerSqlSessionTemplate().update(getStatementNameSpace("updateKeyId"),map)==1) {
//            return true;
//        }
//        return false;
//    }
}
