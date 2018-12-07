package com.micropole.inventorysystem.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName SearchMemberBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/6 17:42
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class SearchMemberBean implements Parcelable{

    /**
     * user_phone : 18271434187
     * user_img : /uploads/image/20181204/20181204422823.png
     * user_sex : 2
     * gr_id : 2
     * user_birthday : 19800101
     * user_nationality : 请选择国家
     * user_id : 4013
     * company_id : 5
     * company_name : 各个公司
     * company_img : /uploads/image/20181206/20181206623903.png
     *
     * nickname
     * add_time
     * user_remark
     * user_email
     */

    private String user_phone;
    private String user_img;
    private String user_sex;
    private String gr_id;
    private String user_birthday;
    private String user_nationality;
    private String user_id;
    private String company_id;
    private String company_name;
    private String company_img;
    private String add_time;
    private String nickname;
    private String user_remark;
    private String user_email;

    protected SearchMemberBean(Parcel in) {
        user_phone = in.readString();
        user_img = in.readString();
        user_sex = in.readString();
        gr_id = in.readString();
        user_birthday = in.readString();
        user_nationality = in.readString();
        user_id = in.readString();
        company_id = in.readString();
        company_name = in.readString();
        company_img = in.readString();
        nickname = in.readString();
        add_time = in.readString();
        user_remark = in.readString();
        user_email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_phone);
        dest.writeString(user_img);
        dest.writeString(user_sex);
        dest.writeString(gr_id);
        dest.writeString(user_birthday);
        dest.writeString(user_nationality);
        dest.writeString(user_id);
        dest.writeString(company_id);
        dest.writeString(company_name);
        dest.writeString(company_img);
        dest.writeString(nickname);
        dest.writeString(add_time);
        dest.writeString(user_remark);
        dest.writeString(user_email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchMemberBean> CREATOR = new Creator<SearchMemberBean>() {
        @Override
        public SearchMemberBean createFromParcel(Parcel in) {
            return new SearchMemberBean(in);
        }

        @Override
        public SearchMemberBean[] newArray(int size) {
            return new SearchMemberBean[size];
        }
    };

    public void setUser_email(String mUser_email) {
        user_email = mUser_email;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_remark(String mUser_remark) {
        user_remark = mUser_remark;
    }

    public String getUser_remark() {
        return user_remark;
    }

    public void setNickname(String mNickname) {
        nickname = mNickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAdd_time(String mAdd_time) {
        add_time = mAdd_time;
    }

    public String getAdd_time() {
        return add_time;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getGr_id() {
        return gr_id;
    }

    public void setGr_id(String gr_id) {
        this.gr_id = gr_id;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_nationality() {
        return user_nationality;
    }

    public void setUser_nationality(String user_nationality) {
        this.user_nationality = user_nationality;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_img() {
        return company_img;
    }

    public void setCompany_img(String company_img) {
        this.company_img = company_img;
    }
}
