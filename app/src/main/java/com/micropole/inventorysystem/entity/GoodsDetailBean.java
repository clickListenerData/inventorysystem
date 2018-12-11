package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName GoodsDetailBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/11 14:00
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class GoodsDetailBean {


    /**
     * product : {"pro_id":2,"pro_name":"羊毛衬衫","area_id":2,"item_no":"CV10803","parent_item_no":"","pack_ratio":"","pro_img":"","pro_qrcode":"","pro_texture":"90%亚麻/10%涤纶","pro_remark":"","pro_sales":0,"inventory_warning":0,"pro_status":1,"company_user_id":4010,"pro_cost_price":130,"pro_retail_price":320,"pro_stock_price":0,"add_time":0,"pro_browse":0,"color_id":"1,3,4","spec_id":"1,2,3","area_name":"商务衬衫","prodinfo":[{"pro_specs":"1","spec_name":"X","spec_store":"0","color":[{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]},{"pro_specs":"2","spec_name":"XL","spec_store":"0","color":[{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]},{"pro_specs":"3","spec_name":"XXL","spec_store":"0","color":[{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]}]}
     */

    private ProductBean product;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {
        /**
         * pro_id : 2
         * pro_name : 羊毛衬衫
         * area_id : 2
         * item_no : CV10803
         * parent_item_no :
         * pack_ratio :
         * pro_img :
         * pro_qrcode :
         * pro_texture : 90%亚麻/10%涤纶
         * pro_remark :
         * pro_sales : 0
         * inventory_warning : 0
         * pro_status : 1
         * company_user_id : 4010
         * pro_cost_price : 130
         * pro_retail_price : 320
         * pro_stock_price : 0
         * add_time : 0
         * pro_browse : 0
         * color_id : 1,3,4
         * spec_id : 1,2,3
         * area_name : 商务衬衫
         * prodinfo : [{"pro_specs":"1","spec_name":"X","spec_store":"0","color":[{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]},{"pro_specs":"2","spec_name":"XL","spec_store":"0","color":[{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]},{"pro_specs":"3","spec_name":"XXL","spec_store":"0","color":[{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]}]
         */

        private String pro_id;
        private String pro_name;
        private String area_id;
        private String item_no;
        private String parent_item_no;
        private String pack_ratio;
        private String pro_img;
        private String pro_qrcode;
        private String pro_texture;
        private String pro_remark;
        private String pro_sales;
        private String inventory_warning;
        private String pro_status;
        private String company_user_id;
        private String pro_cost_price;
        private String pro_retail_price;
        private String pro_stock_price;
        private String add_time;
        private String pro_browse;
        private String color_id;
        private String spec_id;
        private String area_name;
        private List<ProdinfoBean> prodinfo;

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

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getItem_no() {
            return item_no;
        }

        public void setItem_no(String item_no) {
            this.item_no = item_no;
        }

        public String getParent_item_no() {
            return parent_item_no;
        }

        public void setParent_item_no(String parent_item_no) {
            this.parent_item_no = parent_item_no;
        }

        public String getPack_ratio() {
            return pack_ratio;
        }

        public void setPack_ratio(String pack_ratio) {
            this.pack_ratio = pack_ratio;
        }

        public String getPro_img() {
            return pro_img;
        }

        public void setPro_img(String pro_img) {
            this.pro_img = pro_img;
        }

        public String getPro_qrcode() {
            return pro_qrcode;
        }

        public void setPro_qrcode(String pro_qrcode) {
            this.pro_qrcode = pro_qrcode;
        }

        public String getPro_texture() {
            return pro_texture;
        }

        public void setPro_texture(String pro_texture) {
            this.pro_texture = pro_texture;
        }

        public String getPro_remark() {
            return pro_remark;
        }

        public void setPro_remark(String pro_remark) {
            this.pro_remark = pro_remark;
        }

        public String getPro_sales() {
            return pro_sales;
        }

        public void setPro_sales(String pro_sales) {
            this.pro_sales = pro_sales;
        }

        public String getInventory_warning() {
            return inventory_warning;
        }

        public void setInventory_warning(String inventory_warning) {
            this.inventory_warning = inventory_warning;
        }

        public String getPro_status() {
            return pro_status;
        }

        public void setPro_status(String pro_status) {
            this.pro_status = pro_status;
        }

        public String getCompany_user_id() {
            return company_user_id;
        }

        public void setCompany_user_id(String company_user_id) {
            this.company_user_id = company_user_id;
        }

        public String getPro_cost_price() {
            return pro_cost_price;
        }

        public void setPro_cost_price(String pro_cost_price) {
            this.pro_cost_price = pro_cost_price;
        }

        public String getPro_retail_price() {
            return pro_retail_price;
        }

        public void setPro_retail_price(String pro_retail_price) {
            this.pro_retail_price = pro_retail_price;
        }

        public String getPro_stock_price() {
            return pro_stock_price;
        }

        public void setPro_stock_price(String pro_stock_price) {
            this.pro_stock_price = pro_stock_price;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getPro_browse() {
            return pro_browse;
        }

        public void setPro_browse(String pro_browse) {
            this.pro_browse = pro_browse;
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

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public List<ProdinfoBean> getProdinfo() {
            return prodinfo;
        }

        public void setProdinfo(List<ProdinfoBean> prodinfo) {
            this.prodinfo = prodinfo;
        }

        public static class ProdinfoBean {
            /**
             * pro_specs : 1
             * spec_name : X
             * spec_store : 0
             * color : [{"pro_stock":"0","pro_color":1,"color_name":"红色"},{"pro_stock":"0","pro_color":3,"color_name":"橙色"},{"pro_stock":"0","pro_color":4,"color_name":"绿色"}]
             */

            private String pro_specs;
            private String spec_name;
            private String spec_store;
            private List<ColorBean> color;

            public String getPro_specs() {
                return pro_specs;
            }

            public void setPro_specs(String pro_specs) {
                this.pro_specs = pro_specs;
            }

            public String getSpec_name() {
                return spec_name;
            }

            public void setSpec_name(String spec_name) {
                this.spec_name = spec_name;
            }

            public String getSpec_store() {
                return spec_store;
            }

            public void setSpec_store(String spec_store) {
                this.spec_store = spec_store;
            }

            public List<ColorBean> getColor() {
                return color;
            }

            public void setColor(List<ColorBean> color) {
                this.color = color;
            }

            public static class ColorBean {
                /**
                 * pro_stock : 0
                 * pro_color : 1
                 * color_name : 红色
                 * c_color
                 */

                private String pro_stock;
                private String pro_color;
                private String color_name;
                private String c_color;

                public void setC_color(String mC_color) {
                    c_color = mC_color;
                }

                public String getC_color() {
                    return c_color;
                }

                public String getPro_stock() {
                    return pro_stock;
                }

                public void setPro_stock(String pro_stock) {
                    this.pro_stock = pro_stock;
                }

                public String getPro_color() {
                    return pro_color;
                }

                public void setPro_color(String pro_color) {
                    this.pro_color = pro_color;
                }

                public String getColor_name() {
                    return color_name;
                }

                public void setColor_name(String color_name) {
                    this.color_name = color_name;
                }
            }
        }
    }
}
