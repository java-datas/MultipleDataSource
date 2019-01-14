package com.alimama.service.impl;

import com.alimama.constants.Constants;
import com.alimama.dao.tuiaConsumer.WzUserDao;
import com.alimama.dao.wzConsumerBase.WzUserBaseDao;
import com.alimama.dao.wzConsumerBind.WzUserBindDao;
import com.alimama.entity.tuiaConsumer.WzUserEntity;
import com.alimama.entity.wzConsumerBase.WzUserBaseEntity;
import com.alimama.rsp.WzUserEntityRsp;
import com.alimama.service.KeyIdService;
import com.alimama.service.WzUserService;
import com.alimama.util.BeanUtils;
import com.alimama.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangshuman on 2018/12/26.
 */

@Service("WzUserService")
public class WzUserServiceImpl implements WzUserService {
    private static Logger logger = LoggerFactory.getLogger(WzUserServiceImpl.class);

    @Autowired
    private KeyIdService keyIdService;
    @Autowired
    private WzUserDao wzUserDao;
    @Autowired
    private WzUserBindDao wzUserBindDao;
    @Autowired
    private WzUserBaseDao wzUserBaseDao;

    @Override
    //查询用户的所有信息
    public WzUserEntityRsp getWzUser(Long userId) {

        //查用户的登录信息
        WzUserEntity wzUserEntity = wzUserDao.selectOneUser(userId);
        WzUserEntityRsp rsp = BeanUtils.copy(wzUserEntity, WzUserEntityRsp.class);
        WzUserBaseEntity wzUserBaseEntity = wzUserBaseDao.selectUserBaseInfo(userId);
        if (wzUserBaseEntity == null) {
            return rsp;
        }
        //装载微信信息到用户，包含微信头像、微信昵称、微信性别、openID、unionID
        rsp.setHeadimagurl(wzUserBaseEntity.getHeadimgurl());
        rsp.setNickname(wzUserBaseEntity.getNickname());
        rsp.setOpenId(wzUserBaseEntity.getOpenId());
        rsp.setUnionId(wzUserBaseEntity.getUnionId());
        rsp.setSex(wzUserBaseEntity.getSex());

        //返回装载后的数据
        return rsp;
    }

    //删除所有用户
    @Override
    public Boolean deleteUser(Long userId) {
        try {
            wzUserDao.deleteUser(userId);
            wzUserBindDao.deleteUserBind(userId);
            wzUserBaseDao.deleteUserBase(userId);
            return true;
        } catch (Exception e) {
            logger.error("deleteUser error! {}", e);
            return false;
        }
    }

    //更改用户VIP属性
    @Override
    public Boolean updateVip(Integer vip, Long userId) {
        return wzUserDao.updateUserVip(vip, userId);
    }

    //手机号码注册新用户
    @Transactional
    @Override
    public Long registeredByPhone() {

        WzUserEntity wzUserEntity = new WzUserEntity();
        //获取全局keyId表中当前表的id
        Long userId = keyIdService.getKeyIdByTableName(Constants.CONSUMER_TABLE_NAME);
        if (userId == null) {
            userId = 99999999L;
        }
        Long phone = keyIdService.getKeyIdByTableName(Constants.PHONE_TABLE_NAME);
        if (phone == null) {
            phone = 13600001235L;
        }
        //注册用户信息
        wzUserEntity.setUserId(userId.intValue());
        wzUserEntity.setAppId(0);
        wzUserEntity.setDeviceId(RandomUtil.randAz09(32));
        wzUserEntity.setPhone(phone.toString());
        wzUserEntity.setInitialPassword("123456");
        wzUserEntity.setStatus(00);
        wzUserEntity.setVip(0);
        wzUserEntity.setOptStatus(00);

        boolean flag = wzUserDao.registeredByPhone(wzUserEntity);
        if (!flag) {
            return null;
        }
        //给全局keyId表中当前表的id+1
        userId = userId + 1;
        phone = phone + 1;
        keyIdService.updateKeyId(userId, Constants.CONSUMER_TABLE_NAME);
        keyIdService.updateKeyId(phone, Constants.PHONE_TABLE_NAME);
        return wzUserEntity.getUserId().longValue();
    }

    //查询用户的微信信息
    @Override
    public WzUserBaseEntity selectUserBase(Long userId) {

        WzUserBaseEntity wzUserBaseEntity = wzUserBaseDao.selectUserBaseInfo(userId);

        return wzUserBaseEntity;
    }
}
