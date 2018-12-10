package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/12/10
 * describe:
 */
public class ShopMall {

    /**
     * area_name : 进销存热卖商品66
     * product_data : [{"pro_id":"115","pro_name":"qwe","pro_label":"qwe","pro_text":"","pro_img":"http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png","pro_imgs":"http://jinxiaocun.com/uploads/20181204/9e31abcb90e0880b5eb5256b17584f22.png","pro_stock":"0","pro_recos":"0","pro_sort":"0","pro_sales":"0","area_id":"103","pro_status":"1","pro_commission":"0","pro_shop_price":"0","pro_market_price":"0","pro_addtime":"1543913452","pro_browse":"0","pro_weight":"0.00","pro_type":"0","bulk_number":"0","bulk_end_time":"0","bulk_start_time":"0","is_del":"1","del_time":"0","pro_years":"0","is_pinkage":"0","is_pinkage_store":"0","pinkage_start_time":"0","pinkage_end_time":"0","pinkage_number":"0","integral":"0","audit":"0","bulk_integral":"0","activity":"qwe","store_user_id":"0","pro_score":"5.00","bar_code":"qwe","is_copy":"0","is_all_return":"1"},{"pro_id":"116","pro_name":"qwe","pro_label":"qwe","pro_text":"","pro_img":"http://jinxiaocun.com/uploads/20181204/28b44e33a6f5499fdc0b346036301987.png","pro_imgs":"http://jinxiaocun.com/uploads/20181204/f19dd986a500ed2a247b80a80fc38d55.png","pro_stock":"0","pro_recos":"0","pro_sort":"0","pro_sales":"0","area_id":"103","pro_status":"1","pro_commission":"0","pro_shop_price":"0","pro_market_price":"0","pro_addtime":"1543913467","pro_browse":"0","pro_weight":"0.00","pro_type":"0","bulk_number":"0","bulk_end_time":"0","bulk_start_time":"0","is_del":"0","del_time":"0","pro_years":"0","is_pinkage":"0","is_pinkage_store":"0","pinkage_start_time":"0","pinkage_end_time":"0","pinkage_number":"0","integral":"0","audit":"0","bulk_integral":"0","activity":"qwe","store_user_id":"0","pro_score":"5.00","bar_code":"qwe","is_copy":"0","is_all_return":"1"},{"pro_id":"117","pro_name":"qwe","pro_label":"qwe","pro_text":"<p>少时诵诗书所所所所搜索所所<\/p><p>少时诵诗书所所所所<\/p>","pro_img":"http://jinxiaocun.com/uploads/20181204/6250f088d6026930f673c5905bd40640.png","pro_imgs":"http://jinxiaocun.com/uploads/20181204/2564e4ffc5f4c87e4b87d8647e771aea.png","pro_stock":"0","pro_recos":"0","pro_sort":"0","pro_sales":"0","area_id":"103","pro_status":"1","pro_commission":"0","pro_shop_price":"23","pro_market_price":"0","pro_addtime":"1543915304","pro_browse":"0","pro_weight":"0.00","pro_type":"0","bulk_number":"0","bulk_end_time":"0","bulk_start_time":"0","is_del":"0","del_time":"0","pro_years":"0","is_pinkage":"0","is_pinkage_store":"0","pinkage_start_time":"0","pinkage_end_time":"0","pinkage_number":"0","integral":"0","audit":"0","bulk_integral":"0","activity":"qwe","store_user_id":"0","pro_score":"5.00","bar_code":"qwe","is_copy":"0","is_all_return":"1"}]
     */

    private String area_name;
    private List<ProductDataBean> product_data;

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public List<ProductDataBean> getProduct_data() {
        return product_data;
    }

    public void setProduct_data(List<ProductDataBean> product_data) {
        this.product_data = product_data;
    }

    public static class ProductDataBean {
        /**
         * pro_id : 115
         * pro_name : qwe
         * pro_label : qwe
         * pro_text :
         * pro_img : http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png
         * pro_imgs : http://jinxiaocun.com/uploads/20181204/9e31abcb90e0880b5eb5256b17584f22.png
         * pro_stock : 0
         * pro_recos : 0
         * pro_sort : 0
         * pro_sales : 0
         * area_id : 103
         * pro_status : 1
         * pro_commission : 0
         * pro_shop_price : 0
         * pro_market_price : 0
         * pro_addtime : 1543913452
         * pro_browse : 0
         * pro_weight : 0.00
         * pro_type : 0
         * bulk_number : 0
         * bulk_end_time : 0
         * bulk_start_time : 0
         * is_del : 1
         * del_time : 0
         * pro_years : 0
         * is_pinkage : 0
         * is_pinkage_store : 0
         * pinkage_start_time : 0
         * pinkage_end_time : 0
         * pinkage_number : 0
         * integral : 0
         * audit : 0
         * bulk_integral : 0
         * activity : qwe
         * store_user_id : 0
         * pro_score : 5.00
         * bar_code : qwe
         * is_copy : 0
         * is_all_return : 1
         */

        private String pro_id;
        private String pro_name;
        private String pro_label;
        private String pro_text;
        private String pro_img;
        private String pro_imgs;
        private String pro_stock;
        private String pro_recos;
        private String pro_sort;
        private String pro_sales;
        private String area_id;
        private String pro_status;
        private String pro_commission;
        private String pro_shop_price;
        private String pro_market_price;
        private String pro_addtime;
        private String pro_browse;
        private String pro_weight;
        private String pro_type;
        private String bulk_number;
        private String bulk_end_time;
        private String bulk_start_time;
        private String is_del;
        private String del_time;
        private String pro_years;
        private String is_pinkage;
        private String is_pinkage_store;
        private String pinkage_start_time;
        private String pinkage_end_time;
        private String pinkage_number;
        private String integral;
        private String audit;
        private String bulk_integral;
        private String activity;
        private String store_user_id;
        private String pro_score;
        private String bar_code;
        private String is_copy;
        private String is_all_return;

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

        public String getPro_label() {
            return pro_label;
        }

        public void setPro_label(String pro_label) {
            this.pro_label = pro_label;
        }

        public String getPro_text() {
            return pro_text;
        }

        public void setPro_text(String pro_text) {
            this.pro_text = pro_text;
        }

        public String getPro_img() {
            return pro_img;
        }

        public void setPro_img(String pro_img) {
            this.pro_img = pro_img;
        }

        public String getPro_imgs() {
            return pro_imgs;
        }

        public void setPro_imgs(String pro_imgs) {
            this.pro_imgs = pro_imgs;
        }

        public String getPro_stock() {
            return pro_stock;
        }

        public void setPro_stock(String pro_stock) {
            this.pro_stock = pro_stock;
        }

        public String getPro_recos() {
            return pro_recos;
        }

        public void setPro_recos(String pro_recos) {
            this.pro_recos = pro_recos;
        }

        public String getPro_sort() {
            return pro_sort;
        }

        public void setPro_sort(String pro_sort) {
            this.pro_sort = pro_sort;
        }

        public String getPro_sales() {
            return pro_sales;
        }

        public void setPro_sales(String pro_sales) {
            this.pro_sales = pro_sales;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getPro_status() {
            return pro_status;
        }

        public void setPro_status(String pro_status) {
            this.pro_status = pro_status;
        }

        public String getPro_commission() {
            return pro_commission;
        }

        public void setPro_commission(String pro_commission) {
            this.pro_commission = pro_commission;
        }

        public String getPro_shop_price() {
            return pro_shop_price;
        }

        public void setPro_shop_price(String pro_shop_price) {
            this.pro_shop_price = pro_shop_price;
        }

        public String getPro_market_price() {
            return pro_market_price;
        }

        public void setPro_market_price(String pro_market_price) {
            this.pro_market_price = pro_market_price;
        }

        public String getPro_addtime() {
            return pro_addtime;
        }

        public void setPro_addtime(String pro_addtime) {
            this.pro_addtime = pro_addtime;
        }

        public String getPro_browse() {
            return pro_browse;
        }

        public void setPro_browse(String pro_browse) {
            this.pro_browse = pro_browse;
        }

        public String getPro_weight() {
            return pro_weight;
        }

        public void setPro_weight(String pro_weight) {
            this.pro_weight = pro_weight;
        }

        public String getPro_type() {
            return pro_type;
        }

        public void setPro_type(String pro_type) {
            this.pro_type = pro_type;
        }

        public String getBulk_number() {
            return bulk_number;
        }

        public void setBulk_number(String bulk_number) {
            this.bulk_number = bulk_number;
        }

        public String getBulk_end_time() {
            return bulk_end_time;
        }

        public void setBulk_end_time(String bulk_end_time) {
            this.bulk_end_time = bulk_end_time;
        }

        public String getBulk_start_time() {
            return bulk_start_time;
        }

        public void setBulk_start_time(String bulk_start_time) {
            this.bulk_start_time = bulk_start_time;
        }

        public String getIs_del() {
            return is_del;
        }

        public void setIs_del(String is_del) {
            this.is_del = is_del;
        }

        public String getDel_time() {
            return del_time;
        }

        public void setDel_time(String del_time) {
            this.del_time = del_time;
        }

        public String getPro_years() {
            return pro_years;
        }

        public void setPro_years(String pro_years) {
            this.pro_years = pro_years;
        }

        public String getIs_pinkage() {
            return is_pinkage;
        }

        public void setIs_pinkage(String is_pinkage) {
            this.is_pinkage = is_pinkage;
        }

        public String getIs_pinkage_store() {
            return is_pinkage_store;
        }

        public void setIs_pinkage_store(String is_pinkage_store) {
            this.is_pinkage_store = is_pinkage_store;
        }

        public String getPinkage_start_time() {
            return pinkage_start_time;
        }

        public void setPinkage_start_time(String pinkage_start_time) {
            this.pinkage_start_time = pinkage_start_time;
        }

        public String getPinkage_end_time() {
            return pinkage_end_time;
        }

        public void setPinkage_end_time(String pinkage_end_time) {
            this.pinkage_end_time = pinkage_end_time;
        }

        public String getPinkage_number() {
            return pinkage_number;
        }

        public void setPinkage_number(String pinkage_number) {
            this.pinkage_number = pinkage_number;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getAudit() {
            return audit;
        }

        public void setAudit(String audit) {
            this.audit = audit;
        }

        public String getBulk_integral() {
            return bulk_integral;
        }

        public void setBulk_integral(String bulk_integral) {
            this.bulk_integral = bulk_integral;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getStore_user_id() {
            return store_user_id;
        }

        public void setStore_user_id(String store_user_id) {
            this.store_user_id = store_user_id;
        }

        public String getPro_score() {
            return pro_score;
        }

        public void setPro_score(String pro_score) {
            this.pro_score = pro_score;
        }

        public String getBar_code() {
            return bar_code;
        }

        public void setBar_code(String bar_code) {
            this.bar_code = bar_code;
        }

        public String getIs_copy() {
            return is_copy;
        }

        public void setIs_copy(String is_copy) {
            this.is_copy = is_copy;
        }

        public String getIs_all_return() {
            return is_all_return;
        }

        public void setIs_all_return(String is_all_return) {
            this.is_all_return = is_all_return;
        }
    }
}
