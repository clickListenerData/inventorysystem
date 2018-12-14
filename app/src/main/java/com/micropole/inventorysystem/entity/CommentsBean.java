package com.micropole.inventorysystem.entity;

import java.util.ArrayList;

/**
 * @ClassName CommentsBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/14 10:45
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class CommentsBean {

    /**
     * com_id : 76
     * pro_id : 116
     * pro_score : 100
     * com_content : goods，很好
     * com_pic : \/uploads\/20180816\/2c0cb90410d039eb1cbd03b5cdd61a97.jpg,\/uploads\/20180816\/2c0cb90410d039eb1cbd03b5cdd61a97.jpg
     * nickname : 小李飞刀
     * user_img : /static/admin/images/admin.jpg
     */

    private String com_id;
    private String pro_id;
    private String pro_score;
    private String com_content;
    private String com_pic;
    private String nickname;
    private String user_img;
    private ArrayList<String> custom_orginalpics;

    public void setCustom_orginalpics(ArrayList<String> mCustom_orginalpics) {
        custom_orginalpics = mCustom_orginalpics;
    }

    public ArrayList<String> getCustom_orginalpics() {
        return custom_orginalpics;
    }

    public String getCom_id() {
        return com_id;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_score() {
        return pro_score;
    }

    public void setPro_score(String pro_score) {
        this.pro_score = pro_score;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public String getCom_pic() {
        return com_pic;
    }

    public void setCom_pic(String com_pic) {
        this.com_pic = com_pic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }
}
