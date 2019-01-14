package com.alimama.rsp;

import com.alimama.entity.tuiaConsumer.WzUserEntity;

/**
 * Created by zhangshuman on 2018/12/27.
 */
public class WzUserEntityRsp extends WzUserEntity {

    private String openId;
    private String unionId;
    private String nickname;
    private String headimagurl;
    private Integer sex;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimagurl() {
        return headimagurl;
    }

    public void setHeadimagurl(String headimagurl) {
        this.headimagurl = headimagurl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
