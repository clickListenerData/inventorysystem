package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName SpecBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/5 16:29
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class SpecBean {

    private List<SpecListBean> spec_list;

    public List<SpecListBean> getSpec_list() {
        return spec_list;
    }

    public void setSpec_list(List<SpecListBean> spec_list) {
        this.spec_list = spec_list;
    }

    public static class SpecListBean {
        /**
         * spec_id : 1
         * spec_name : X
         */

        private String spec_id;
        private String spec_name;

        public String getSpec_id() {
            return spec_id;
        }

        public void setSpec_id(String spec_id) {
            this.spec_id = spec_id;
        }

        public String getSpec_name() {
            return spec_name;
        }

        public void setSpec_name(String spec_name) {
            this.spec_name = spec_name;
        }
    }
}
