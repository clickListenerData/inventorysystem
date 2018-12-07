package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName InvitationBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/7 15:16
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class InvitationBean {


    /**
     * user_list : []
     * count : 0
     */

    private String count;
    private List<MemberListBean> user_list;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<MemberListBean> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<MemberListBean> user_list) {
        this.user_list = user_list;
    }
}
