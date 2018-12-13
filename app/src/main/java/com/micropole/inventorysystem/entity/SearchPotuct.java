package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/12/13
 * describe:
 */
public class SearchPotuct {

    private List<HotKeysBean> hot_keys;
    private List<ProductBean> product;


    public List<HotKeysBean> getHot_keys() {
        return hot_keys;
    }

    public void setHot_keys(List<HotKeysBean> hot_keys) {
        this.hot_keys = hot_keys;
    }

    public List<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(List<ProductBean> product) {
        this.product = product;
    }

    public static class HotKeysBean {
        /**
         * key_name : 毛大衣
         * key_num : 3
         */

        private String key_name;
        private String key_num;

        public String getKey_name() {
            return key_name;
        }

        public void setKey_name(String key_name) {
            this.key_name = key_name;
        }

        public String getKey_num() {
            return key_num;
        }

        public void setKey_num(String key_num) {
            this.key_num = key_num;
        }
    }

    public static class ProductBean {
        /**
         * pro_id : 115
         * pro_name : qwe
         * pro_label : qwe
         * pro_img : http://jinxiaocun.com/uploads/20181204/5ae557efc591932a11e83fb74c699cd2.png
         * pro_shop_price : 0
         */

        private String pro_id;
        private String pro_name;
        private String pro_label;
        private String pro_img;
        private String pro_shop_price;

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

        public String getPro_img() {
            return pro_img;
        }

        public void setPro_img(String pro_img) {
            this.pro_img = pro_img;
        }

        public String getPro_shop_price() {
            return pro_shop_price;
        }

        public void setPro_shop_price(String pro_shop_price) {
            this.pro_shop_price = pro_shop_price;
        }
    }
}
