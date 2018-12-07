package com.micropole.inventorysystem.entity;

/**
 * @ClassName PositionBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/7 11:51
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class PositionBean {

    /**
     * r_id : 2
     * r_role : 销售员
     * type : 1
     */

    private String r_id;
    private String r_role;
    private String type;

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_role() {
        return r_role;
    }

    public void setR_role(String r_role) {
        this.r_role = r_role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
