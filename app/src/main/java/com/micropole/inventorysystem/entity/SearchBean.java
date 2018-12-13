package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/12/13
 * describe:
 */
public class SearchBean {

    private List<HotKeysBean> hot_keys;

    public List<HotKeysBean> getHot_keys() {
        return hot_keys;
    }

    public void setHot_keys(List<HotKeysBean> hot_keys) {
        this.hot_keys = hot_keys;
    }

    public static class HotKeysBean {
        /**
         * key_name :
         * key_num : 25
         */

        private String key_name;
        private int key_num;

        public String getKey_name() {
            return key_name;
        }

        public void setKey_name(String key_name) {
            this.key_name = key_name;
        }

        public int getKey_num() {
            return key_num;
        }

        public void setKey_num(int key_num) {
            this.key_num = key_num;
        }
    }
}
