package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName MaterialBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/11/21 15:07
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class MaterialBean {


    private List<TextureListBean> texture_list;

    public List<TextureListBean> getTexture_list() {
        return texture_list;
    }

    public void setTexture_list(List<TextureListBean> texture_list) {
        this.texture_list = texture_list;
    }

    public static class TextureListBean {
        /**
         * t_id : 1
         * t_name : 亚麻
         */

        private String t_id;
        private String t_name;

        public String getT_id() {
            return t_id;
        }

        public void setT_id(String t_id) {
            this.t_id = t_id;
        }

        public String getT_name() {
            return t_name;
        }

        public void setT_name(String t_name) {
            this.t_name = t_name;
        }
    }
}
