package com.alimama.dao.tuiaConsumer;

import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangshuman on 2019/1/11.
 */


public interface TbKeyIdDao {

    Long getKeyIdByTableName(String tableName);

    Boolean updateKeyId(@Param("keyId") Long keyId, @Param("tableName") String tableName);

}
