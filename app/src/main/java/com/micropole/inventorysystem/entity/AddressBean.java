package com.micropole.inventorysystem.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName AddressBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/11 9:14
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class AddressBean implements Parcelable{

    /**
     * ua_id : 1
     * user_id : 4017
     * address : 测试测试
     * consignee : 王富贵
     * phone : 2147483647
     * is_default : 1
     */

    private String ua_id;
    private String user_id;
    private String address;
    private String consignee;
    private String phone;
    private String is_default;

    protected AddressBean(Parcel in) {
        ua_id = in.readString();
        user_id = in.readString();
        address = in.readString();
        consignee = in.readString();
        phone = in.readString();
        is_default = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ua_id);
        dest.writeString(user_id);
        dest.writeString(address);
        dest.writeString(consignee);
        dest.writeString(phone);
        dest.writeString(is_default);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AddressBean> CREATOR = new Creator<AddressBean>() {
        @Override
        public AddressBean createFromParcel(Parcel in) {
            return new AddressBean(in);
        }

        @Override
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };

    public String getUa_id() {
        return ua_id;
    }

    public void setUa_id(String ua_id) {
        this.ua_id = ua_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }
}
