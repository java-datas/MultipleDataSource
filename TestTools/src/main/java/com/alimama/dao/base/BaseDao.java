package com.alimama.dao.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @Author: chenzheng
 * @Date: 2018/12/26 0026 20:02
 */
public abstract class BaseDao {

    protected Logger logger = LoggerFactory.getLogger(getClass());

//    @Resource
//    @Qualifier("tuia_consumerSqlSessionTemplate")
//    private SqlSessionTemplate tuia_consumerSqlSessionTemplate;
//
//    @Resource
//    @Qualifier("wz_consumer_bindSqlSessionTemplate")
//    private SqlSessionTemplate wz_consumer_bindSqlSessionTemplate;
//
//    @Resource
//    @Qualifier("wz_consumer_baseSqlSessionTemplate")
//    private SqlSessionTemplate wz_consumer_baseSqlSessionTemplate;
//
//
//    public SqlSessionTemplate getTuia_consumerSqlSessionTemplate() {
//        return tuia_consumerSqlSessionTemplate;
//    }
//
//    public SqlSessionTemplate getWz_consumer_bindSqlSessionTemplate() {
//        return wz_consumer_bindSqlSessionTemplate;
//    }
//
//
//    public SqlSessionTemplate getWz_consumer_baseSqlSessionTemplate() {
//        return wz_consumer_baseSqlSessionTemplate;
//    }

     protected String getStatementNameSpace(String method) {
        return getClass().getName() + "." + method;
    }

}
