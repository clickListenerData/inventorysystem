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
    private UserAddressBean user_address;
    private String or_stat_desc;
    private List<OrprodBean> orprod;
    private List<String> logistics;

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

    public UserAddressBean getUser_address() {
        return user_address;
    }

    public void setUser_address(UserAddressBean user_address) {
        this.user_address = user_address;
    }

    public String getOr_stat_desc() {
        return or_stat_desc;
    }

    public void setOr_stat_desc(String or_stat_desc) {
        this.or_stat_desc = or_stat_desc;
    }

    public List<OrprodBean> getOrprod() {
        return orprod;
    }

    public void setOrprod(List<OrprodBean> orprod) {
        this.orprod = orprod;
    }

    public List<String> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<String> logistics) {
        this.logistics = logistics;
    }

    public static class UserAddressBean {
    }

    public static class OrprodBean {
        /**
         * op_id : 154
         * pro_id : 115
         * pro_name : qwe
         * pro_img : http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png
         * pro_num : 1
         * pro_money : 23
         * area_name : “”
         * sp_name : 红色
         * mo_name : 件
         * or_id : 155
         */

        private String op_id;
        private String pro_id;
        private String pro_name;
        private String pro_img;
        private String pro_num;
        private String pro_money;
        private String area_name;
        private String sp_name;
        private String mo_name;
        private String or_id;

        public String getOp_id() {
            return op_id;
        }

        public void setOp_id(String op_id) {
            this.op_id = op_id;
        }

        public String getPro_id() {
            return pro_id;
        }

        public void setPro_id(String pro_id) {
            this.pro_id = pro_id;
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

        public String getPro_num() {
            return pro_num;
        }

        public void setPro_num(String pro_num) {
            this.pro_num = pro_num;
        }

        public String getPro_money() {
            return pro_money;
        }

        public void setPro_money(String pro_money) {
            this.pro_money = pro_money;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getSp_name() {
            return sp_name;
        }

        public void setSp_name(String sp_name) {
            this.sp_name = sp_name;
        }

        public String getMo_name() {
            return mo_name;
        }

        public void setMo_name(String mo_name) {
            this.mo_name = mo_name;
        }

        public String getOr_id() {
            return or_id;
        }

        public void setOr_id(String or_id) {
            this.or_id = or_id;
        }
    }
}
