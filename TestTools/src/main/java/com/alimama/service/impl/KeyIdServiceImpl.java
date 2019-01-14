package com.alimama.service.impl;

import com.alimama.dao.tuiaConsumer.TbKeyIdDao;
import com.alimama.service.KeyIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangshuman on 2019/1/12.
 */
@Service
public class KeyIdServiceImpl implements KeyIdService{

    @Autowired
    private TbKeyIdDao tbKeyIdDao;

    @Override
    public Long getKeyIdByTableName(String tableName) {
        return tbKeyIdDao.getKeyIdByTableName(tableName);
    }

    @Override
    public Boolean updateKeyId(Long keyId, String tableName) {
        return tbKeyIdDao.updateKeyId(keyId,tableName);
    }
}
