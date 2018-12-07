package com.micropole.inventorysystem.entity;

/**
 * @ClassName MemberListBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/6 16:44
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class MemberListBean {


    /**
     * user_remark : 小李飞刀
     * nickname : 小李飞刀
     * user_id : 4010
     * r_role : 管理员
     */

    private String user_remark;
    private String nickname;
    private String user_id;
    private String r_role;
    /**
     * stat : 2
     */

    private String stat;

    public String getUser_remark() {
        return user_remark;
    }

    public void setUser_remark(String user_remark) {
        this.user_remark = user_remark;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getR_role() {
        return r_role;
    }

    public void setR_role(String r_role) {
        this.r_role = r_role;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
