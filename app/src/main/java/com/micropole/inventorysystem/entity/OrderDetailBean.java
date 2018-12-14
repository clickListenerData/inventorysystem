package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName OrderDetailBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/11 17:57
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class OrderDetailBean {


    /**
     * or_id : 155
     * or_number : 2018121053669
     * or_stat : 0
     * or_addtime : 1544436877
     * or_money : 23
     * or_weight : 0
     * re_id : 0
     * de_name : 0
     * de_number : 0
     * user_address : {}
     * orprod : [{"op_id":154,"pro_id":115,"pro_name":"qwe","pro_img":"http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png","pro_num":1,"pro_money":23,"area_name":"\u201c\u201d","sp_name":"红色","mo_name":"件","or_id":155}]
     * or_stat_desc : 待付款
     * logistics : []
     * discounts_price
     * or_leave
     * unpaid_overdue_time
     * is_comment
     */

    private String or_id;
    private String or_number;
    private String or_stat;
    private String or_addtime;
    private String or_money;
    private String or_weight;
    private String re_id;
    private String de_name;
    private String de_number;
    private AddressBean user_address;
    private String or_stat_desc;
    private List<OrderListBean.OrProdBean> orprod;
    private List<LogisticsBean> logistics;
    private String discounts_price;
    private String or_leave;
    private String unpaid_overdue_time;
    private String is_comment;

    public void setIs_comment(String mIs_comment) {
        is_comment = mIs_comment;
    }

    public String getIs_comment() {
        return is_comment;
    }

    public void setUnpaid_overdue_time(String mUnpaid_overdue_time) {
        unpaid_overdue_time = mUnpaid_overdue_time;
    }

    public String getUnpaid_overdue_time() {
        return unpaid_overdue_time;
    }

    public void setOr_leave(String mOr_leave) {
        or_leave = mOr_leave;
    }

    public String getOr_leave() {
        return or_leave;
    }

    public void setDiscounts_price(String mDiscounts_price) {
        discounts_price = mDiscounts_price;
    }

    public String getDiscounts_price() {
        return discounts_price;
    }

    public String getOr_id() {
        return or_id;
    }

    public void setOr_id(String or_id) {
        this.or_id = or_id;
    }

    public String getOr_number() {
        return or_number;
    }

    public void setOr_number(String or_number) {
        this.or_number = or_number;
    }

    public String getOr_stat() {
        return or_stat;
    }

    public void setOr_stat(String or_stat) {
        this.or_stat = or_stat;
    }

    public String getOr_addtime() {
        return or_addtime;
    }

    public void setOr_addtime(String or_addtime) {
        this.or_addtime = or_addtime;
    }

    public String getOr_money() {
        return or_money;
    }

    public void setOr_money(String or_money) {
        this.or_money = or_money;
    }

    public String getOr_weight() {
        return or_weight;
    }

    public void setOr_weight(String or_weight) {
        this.or_weight = or_weight;
    }

    public String getRe_id() {
        return re_id;
    }

    public void setRe_id(String re_id) {
        this.re_id = re_id;
    }

    public String getDe_name() {
        return de_name;
    }

    public void setDe_name(String de_name) {
        this.de_name = de_name;
    }

    public String getDe_number() {
        return de_number;
    }

    public void setDe_number(String de_number) {
        this.de_number = de_number;
    }

    public AddressBean getUser_address() {
        return user_address;
    }

    public void setUser_address(AddressBean user_address) {
        this.user_address = user_address;
    }

    public String getOr_stat_desc() {
        return or_stat_desc;
    }

    public void setOr_stat_desc(String or_stat_desc) {
        this.or_stat_desc = or_stat_desc;
    }

    public List<OrderListBean.OrProdBean> getOrprod() {
        return orprod;
    }

    public void setOrprod(List<OrderListBean.OrProdBean> orprod) {
        this.orprod = orprod;
    }

    public List<LogisticsBean> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<LogisticsBean> logistics) {
        this.logistics = logistics;
    }
}
