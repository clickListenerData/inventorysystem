package com.micropole.inventorysystem.entity;

import java.io.Serializable;

/**
 * @ClassName UserInfoBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/5 9:16
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class UserInfoBean  implements Serializable{

    /**
     * user : {"user_phone":"18271434187","nickname":"呵呵","user_img":"/uploads/image/20181204/20181204422823.png","balance":"0.00","user_sex":"2","gr_id":"1"}
     */

    private UserBean user;
    /**
     * user : {"user_phone":"13682873453","nickname":"小李飞刀","user_img":"/static/admin/images/es/admin.jpg","balance":"0.00","user_sex":"2","gr_id":"2","company_id":"3"}
     * company : {"company_id":"3","company_name":"泰国球鞋","company_img":"/static/admin/images/es/admin.jpg","company_nationality":"","company_principal":"","company_contact":"13682873453","company_postbox":"18926146071 @qq.com ","company_industry":"","company_address":"珠江新城","company_notice":"","company_user_id":"4010","add_time":"1543368565"}
     */

    private CompanyBean company;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public static class UserBean implements Serializable{
        /**
         * user_phone : 18271434187
         * nickname : 呵呵
         * user_img : /uploads/image/20181204/20181204422823.png
         * balance : 0.00
         * user_sex : 2
         * gr_id : 1
         */

        private String user_phone;
        private String nickname;
        private String user_img;
        private String balance;
        private String user_sex;
        private String gr_id;

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
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

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
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
    }

    public static class CompanyBean implements Serializable{
        /**
         * company_id : 3
         * company_name : 泰国球鞋
         * company_img : /static/admin/images/es/admin.jpg
         * company_nationality :
         * company_principal :
         * company_contact : 13682873453
         * company_postbox : 18926146071 @qq.com
         * company_industry :
         * company_address : 珠江新城
         * company_notice :
         * company_user_id : 4010
         * add_time : 1543368565
         */

        private String company_id;
        private String company_name;
        private String company_img;
        private String company_nationality;
        private String company_principal;
        private String company_contact;
        private String company_postbox;
        private String company_industry;
        private String company_address;
        private String company_notice;
        private String company_user_id;
        private String add_time;

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

        public String getCompany_nationality() {
            return company_nationality;
        }

        public void setCompany_nationality(String company_nationality) {
            this.company_nationality = company_nationality;
        }

        public String getCompany_principal() {
            return company_principal;
        }

        public void setCompany_principal(String company_principal) {
            this.company_principal = company_principal;
        }

        public String getCompany_contact() {
            return company_contact;
        }

        public void setCompany_contact(String company_contact) {
            this.company_contact = company_contact;
        }

        public String getCompany_postbox() {
            return company_postbox;
        }

        public void setCompany_postbox(String company_postbox) {
            this.company_postbox = company_postbox;
        }

        public String getCompany_industry() {
            return company_industry;
        }

        public void setCompany_industry(String company_industry) {
            this.company_industry = company_industry;
        }

        public String getCompany_address() {
            return company_address;
        }

        public void setCompany_address(String company_address) {
            this.company_address = company_address;
        }

        public String getCompany_notice() {
            return company_notice;
        }

        public void setCompany_notice(String company_notice) {
            this.company_notice = company_notice;
        }

        public String getCompany_user_id() {
            return company_user_id;
        }

        public void setCompany_user_id(String company_user_id) {
            this.company_user_id = company_user_id;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
