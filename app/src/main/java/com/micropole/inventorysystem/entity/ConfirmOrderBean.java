package com.micropole.inventorysystem.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ConfirmOrderBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/13 10:49
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class ConfirmOrderBean implements Parcelable{

    /**
     * re_id : 12
     * or_address : 广东省广州市珠江新城
     * user_phone : 13682873453
     * user_id : 1
     * rece_name : 小李飞刀
     * rece_phone : 13682873453
     * or_money : 345.00
     * or_moneys : 345.00
     * or_num : 1
     * orprod_data : [{"store_user_id":0,"pro_weight":0,"or_weight":0,"or_num":"1","or_price":345,"reality_order_price":345,"use_integral":{"usring":0,"user_int":0,"choose":0,"show":0},"st_name":"其力汽车总店","user_id":0,"prodinfo":[{"pro_id":"116","pro_name":"qwe","pro_img":"/uploads/20181211/e1139da3be71ae4b752b57464ecbf29f.jpg","pro_money":345,"pro_num":"1","mo_name":"XL","sp_name":"红色"}]}]
     * or_integral : 0
     */

    private String re_id;
    private String or_address;
    private String user_phone;
    private String user_id;
    private String rece_name;
    private String rece_phone;
    private String or_money;
    private String or_moneys;
    private String or_num;
    private String or_integral;
    private List<OrprodDataBean> orprod_data;

    protected ConfirmOrderBean(Parcel in) {
        re_id = in.readString();
        or_address = in.readString();
        user_phone = in.readString();
        user_id = in.readString();
        rece_name = in.readString();
        rece_phone = in.readString();
        or_money = in.readString();
        or_moneys = in.readString();
        or_num = in.readString();
        or_integral = in.readString();
        orprod_data = in.createTypedArrayList(OrprodDataBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(re_id);
        dest.writeString(or_address);
        dest.writeString(user_phone);
        dest.writeString(user_id);
        dest.writeString(rece_name);
        dest.writeString(rece_phone);
        dest.writeString(or_money);
        dest.writeString(or_moneys);
        dest.writeString(or_num);
        dest.writeString(or_integral);
        dest.writeTypedList(orprod_data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ConfirmOrderBean> CREATOR = new Creator<ConfirmOrderBean>() {
        @Override
        public ConfirmOrderBean createFromParcel(Parcel in) {
            return new ConfirmOrderBean(in);
        }

        @Override
        public ConfirmOrderBean[] newArray(int size) {
            return new ConfirmOrderBean[size];
        }
    };

    public String getRe_id() {
        return re_id;
    }

    public void setRe_id(String re_id) {
        this.re_id = re_id;
    }

    public String getOr_address() {
        return or_address;
    }

    public void setOr_address(String or_address) {
        this.or_address = or_address;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRece_name() {
        return rece_name;
    }

    public void setRece_name(String rece_name) {
        this.rece_name = rece_name;
    }

    public String getRece_phone() {
        return rece_phone;
    }

    public void setRece_phone(String rece_phone) {
        this.rece_phone = rece_phone;
    }

    public String getOr_money() {
        return or_money;
    }

    public void setOr_money(String or_money) {
        this.or_money = or_money;
    }

    public String getOr_moneys() {
        return or_moneys;
    }

    public void setOr_moneys(String or_moneys) {
        this.or_moneys = or_moneys;
    }

    public String getOr_num() {
        return or_num;
    }

    public void setOr_num(String or_num) {
        this.or_num = or_num;
    }

    public String getOr_integral() {
        return or_integral;
    }

    public void setOr_integral(String or_integral) {
        this.or_integral = or_integral;
    }

    public List<OrprodDataBean> getOrprod_data() {
        return orprod_data;
    }

    public void setOrprod_data(List<OrprodDataBean> orprod_data) {
        this.orprod_data = orprod_data;
    }

    public static class OrprodDataBean implements Parcelable{
        /**
         * store_user_id : 0
         * pro_weight : 0
         * or_weight : 0
         * or_num : 1
         * or_price : 345
         * reality_order_price : 345
         * use_integral : {"usring":0,"user_int":0,"choose":0,"show":0}
         * st_name : 其力汽车总店
         * user_id : 0
         * prodinfo : [{"pro_id":"116","pro_name":"qwe","pro_img":"/uploads/20181211/e1139da3be71ae4b752b57464ecbf29f.jpg","pro_money":345,"pro_num":"1","mo_name":"XL","sp_name":"红色"}]
         */

        private String store_user_id;
        private String pro_weight;
        private String or_weight;
        private String or_num;
        private String or_price;
        private String reality_order_price;
        private String st_name;
        private String user_id;
        private List<OrderListBean.OrProdBean> prodinfo;

        protected OrprodDataBean(Parcel in) {
            store_user_id = in.readString();
            pro_weight = in.readString();
            or_weight = in.readString();
            or_num = in.readString();
            or_price = in.readString();
            reality_order_price = in.readString();
            st_name = in.readString();
            user_id = in.readString();
            prodinfo = in.createTypedArrayList(OrderListBean.OrProdBean.CREATOR);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(store_user_id);
            dest.writeString(pro_weight);
            dest.writeString(or_weight);
            dest.writeString(or_num);
            dest.writeString(or_price);
            dest.writeString(reality_order_price);
            dest.writeString(st_name);
            dest.writeString(user_id);
            dest.writeTypedList(prodinfo);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<OrprodDataBean> CREATOR = new Creator<OrprodDataBean>() {
            @Override
            public OrprodDataBean createFromParcel(Parcel in) {
                return new OrprodDataBean(in);
            }

            @Override
            public OrprodDataBean[] newArray(int size) {
                return new OrprodDataBean[size];
            }
        };

        public void setProdinfo(List<OrderListBean.OrProdBean> mProdinfo) {
            prodinfo = mProdinfo;
        }

        public List<OrderListBean.OrProdBean> getProdinfo() {
            return prodinfo;
        }

        public String getStore_user_id() {
            return store_user_id;
        }

        public void setStore_user_id(String store_user_id) {
            this.store_user_id = store_user_id;
        }

        public String getPro_weight() {
            return pro_weight;
        }

        public void setPro_weight(String pro_weight) {
            this.pro_weight = pro_weight;
        }

        public String getOr_weight() {
            return or_weight;
        }

        public void setOr_weight(String or_weight) {
            this.or_weight = or_weight;
        }

        public String getOr_num() {
            return or_num;
        }

        public void setOr_num(String or_num) {
            this.or_num = or_num;
        }

        public String getOr_price() {
            return or_price;
        }

        public void setOr_price(String or_price) {
            this.or_price = or_price;
        }

        public String getReality_order_price() {
            return reality_order_price;
        }

        public void setReality_order_price(String reality_order_price) {
            this.reality_order_price = reality_order_price;
        }

        public String getSt_name() {
            return st_name;
        }

        public void setSt_name(String st_name) {
            this.st_name = st_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
