package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName CategoryBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/11/21 14:02
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class CategoryBean {


    private List<AreaListBean> area_list;

    public List<AreaListBean> getArea_list() {
        return area_list;
    }

    public void setArea_list(List<AreaListBean> area_list) {
        this.area_list = area_list;
    }

    public static class AreaListBean {
        /**
         * area_id : 1
         * area_name : 毛绒大衣
         * product_count : 0
         */

        private String area_id;
        private String area_name;
        private String product_count;

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getProduct_count() {
            return product_count;
        }

        public void setProduct_count(String product_count) {
            this.product_count = product_count;
        }
    }
}
