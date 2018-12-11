package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName InventoryGoodsBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/11/21 10:03
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class InventoryGoodsBean {


    private List<ProductListBean> product_list;

    public List<ProductListBean> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(List<ProductListBean> product_list) {
        this.product_list = product_list;
    }

    public static class ProductListBean {
        /**
         * pro_id : 1
         * item_no : CV1099
         * color_id : 1,3,4
         * spec_id : 1,2,3
         * pack_ratio : 100:1
         * colors : 红色/橙色/绿色
         * specs : X/XL/XXL
         * pro_stock : 0箱
         * store_count : 0
         * pro_img
         */

        private String pro_id;
        private String item_no;
        private String color_id;
        private String spec_id;
        private String pack_ratio;
        private String colors;
        private String specs;
        private String pro_stock;
        private String store_count;
        private String pro_img;

        public void setPro_img(String mPro_img) {
            pro_img = mPro_img;
        }

        public String getPro_img() {
            return pro_img;
        }

        public String getPro_id() {
            return pro_id;
        }

        public void setPro_id(String pro_id) {
            this.pro_id = pro_id;
        }

        public String getItem_no() {
            return item_no;
        }

        public void setItem_no(String item_no) {
            this.item_no = item_no;
        }

        public String getColor_id() {
            return color_id;
        }

        public void setColor_id(String color_id) {
            this.color_id = color_id;
        }

        public String getSpec_id() {
            return spec_id;
        }

        public void setSpec_id(String spec_id) {
            this.spec_id = spec_id;
        }

        public String getPack_ratio() {
            return pack_ratio;
        }

        public void setPack_ratio(String pack_ratio) {
            this.pack_ratio = pack_ratio;
        }

        public String getColors() {
            return colors;
        }

        public void setColors(String colors) {
            this.colors = colors;
        }

        public String getSpecs() {
            return specs;
        }

        public void setSpecs(String specs) {
            this.specs = specs;
        }

        public String getPro_pack() {
            return pro_stock;
        }

        public void setPro_pack(String pro_stock) {
            this.pro_stock = pro_stock;
        }

        public String getStore_count() {
            return store_count;
        }

        public void setStore_count(String store_count) {
            this.store_count = store_count;
        }
    }
}
