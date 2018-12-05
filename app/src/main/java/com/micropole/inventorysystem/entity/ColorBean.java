package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName ColorBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/11/21 14:53
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class ColorBean {

    private List<ColorListBean> color_list;

    public List<ColorListBean> getColor_list() {
        return color_list;
    }

    public void setColor_list(List<ColorListBean> color_list) {
        this.color_list = color_list;
    }

    public static class ColorListBean {
        /**
         * c_id : 1
         * c_name : 红色
         * c_color : #FF3030
         * product_count : 0
         */

        private String c_id;
        private String c_name;
        private String c_color;
        private String product_count;

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public String getC_color() {
            return c_color;
        }

        public void setC_color(String c_color) {
            this.c_color = c_color;
        }

        public String getProduct_count() {
            return product_count;
        }

        public void setProduct_count(String product_count) {
            this.product_count = product_count;
        }
    }
}
