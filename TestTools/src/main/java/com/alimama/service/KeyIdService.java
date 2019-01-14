package com.alimama.service;

/**
 * Created by zhangshuman on 2019/1/11.
 */


public interface KeyIdService{

    Long getKeyIdByTableName(String tableName);

    Boolean updateKeyId(Long keyId,String tableName);
}
