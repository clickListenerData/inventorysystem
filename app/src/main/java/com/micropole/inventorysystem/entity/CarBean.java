package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/12/11
 * describe:
 */
public class CarBean {

    /**
     * total_fee : 0.00
     * shopp_count : 0
     * shopp : [{"sh_id":"82","pro_id":"115","pro_num":"1","user_id":"4017","sh_addtime":"2018-12-11 15:10:14","mo_name":"件","sp_name":"红色","pro_price":"23.00","is_checked":0,"pro_name":"qwe","pro_img":"http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png","pro_label":"qwe","pro_shop_price":"0.00"}]
     */

    private String total_fee;
    private String shopp_count;
    private List<ShoppBean> shopp;

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getShopp_count() {
        return shopp_count;
    }

    public void setShopp_count(String shopp_count) {
        this.shopp_count = shopp_count;
    }

    public List<ShoppBean> getShopp() {
        return shopp;
    }

    public void setShopp(List<ShoppBean> shopp) {
        this.shopp = shopp;
    }

    public static class ShoppBean {
        /**
         * sh_id : 82
         * pro_id : 115
         * pro_num : 1
         * user_id : 4017
         * sh_addtime : 2018-12-11 15:10:14
         * mo_name : 件
         * sp_name : 红色
         * pro_price : 23.00
         * is_checked : 0
         * pro_name : qwe
         * pro_img : http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png
         * pro_label : qwe
         * pro_shop_price : 0.00
         */

        private String sh_id;
        private String pro_id;
        private String pro_num;
        private String user_id;
        private String sh_addtime;
        private String mo_name;
        private String sp_name;
        private String pro_price;
        private int is_checked;
        private String pro_name;
        private String pro_img;
        private String pro_label;
        private String pro_shop_price;
        private Boolean isChacked=false;

        public Boolean getIsChacked() {
            return isChacked;
        }

        public void setIsChacked(Boolean chacked) {
            isChacked = chacked;
        }

        public String getSh_id() {
            return sh_id;
        }

        public void setSh_id(String sh_id) {
            this.sh_id = sh_id;
        }

        public String getPro_id() {
            return pro_id;
        }

        public void setPro_id(String pro_id) {
            this.pro_id = pro_id;
        }

        public String getPro_num() {
            return pro_num;
        }

        public void setPro_num(String pro_num) {
            this.pro_num = pro_num;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSh_addtime() {
            return sh_addtime;
        }

        public void setSh_addtime(String sh_addtime) {
            this.sh_addtime = sh_addtime;
        }

        public String getMo_name() {
            return mo_name;
        }

        public void setMo_name(String mo_name) {
            this.mo_name = mo_name;
        }

        public String getSp_name() {
            return sp_name;
        }

        public void setSp_name(String sp_name) {
            this.sp_name = sp_name;
        }

        public String getPro_price() {
            return pro_price;
        }

        public void setPro_price(String pro_price) {
            this.pro_price = pro_price;
        }

        public int getIs_checked() {
            return is_checked;
        }

        public void setIs_checked(int is_checked) {
            this.is_checked = is_checked;
        }

        public String getPro_name() {
            return pro_name;
        }

        public void setPro_name(String pro_name) {
            this.pro_name = pro_name;
        }

        public String getPro_img() {
            return pro_img;
        }

        public void setPro_img(String pro_img) {
            this.pro_img = pro_img;
        }

        public String getPro_label() {
            return pro_label;
        }

        public void setPro_label(String pro_label) {
            this.pro_label = pro_label;
        }

        public String getPro_shop_price() {
            return pro_shop_price;
        }

        public void setPro_shop_price(String pro_shop_price) {
            this.pro_shop_price = pro_shop_price;
        }
    }
}
