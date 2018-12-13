package com.micropole.inventorysystem.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @ClassName OrderListBean
 * @Description 订单列表
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/11 17:54
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class OrderListBean {

    /**
     * or_id : 155
     * or_number : 2018121053669
     * or_stat : 0
     * or_text : 待付款
     * or_num : 1
     * or_prod : [{"op_id":"154","pro_id":"115","pro_name":"qwe","pro_img":"http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png","pro_num":"1","pro_money":23,"area_name":null,"sp_name":"红色","mo_name":"件","or_id":"155"}]
     */

    private String or_id;
    private String or_number;
    private String or_stat;
    private String or_text;
    private String or_num;
    private List<OrProdBean> or_prod;

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

    public String getOr_text() {
        return or_text;
    }

    public void setOr_text(String or_text) {
        this.or_text = or_text;
    }

    public String getOr_num() {
        return or_num;
    }

    public void setOr_num(String or_num) {
        this.or_num = or_num;
    }

    public List<OrProdBean> getOr_prod() {
        return or_prod;
    }

    public void setOr_prod(List<OrProdBean> or_prod) {
        this.or_prod = or_prod;
    }

    public static class OrProdBean implements Parcelable{
        /**
         * op_id : 154
         * pro_id : 115
         * pro_name : qwe
         * pro_img : http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png
         * pro_num : 1
         * pro_money : 23
         * area_name : null
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

        protected OrProdBean(Parcel in) {
            op_id = in.readString();
            pro_id = in.readString();
            pro_name = in.readString();
            pro_img = in.readString();
            pro_num = in.readString();
            pro_money = in.readString();
            area_name = in.readString();
            sp_name = in.readString();
            mo_name = in.readString();
            or_id = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(op_id);
            dest.writeString(pro_id);
            dest.writeString(pro_name);
            dest.writeString(pro_img);
            dest.writeString(pro_num);
            dest.writeString(pro_money);
            dest.writeString(area_name);
            dest.writeString(sp_name);
            dest.writeString(mo_name);
            dest.writeString(or_id);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<OrProdBean> CREATOR = new Creator<OrProdBean>() {
            @Override
            public OrProdBean createFromParcel(Parcel in) {
                return new OrProdBean(in);
            }

            @Override
            public OrProdBean[] newArray(int size) {
                return new OrProdBean[size];
            }
        };

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
