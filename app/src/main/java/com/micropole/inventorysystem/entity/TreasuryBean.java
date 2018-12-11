package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName TreasuryBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/11 9:53
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class TreasuryBean {

    /**
     * order_data : [{"or_id":"3","or_price":"200","or_tax":"0","or_vat":"0","additional_charge":"0","discount_amount":"0","outstanding_account":"0","user_phone":"18926146071","user_id":"4011","rece_name":"0","rece_phone":"0","add_time":"2018-11-29 13:57:18","or_number":"20181129897716","or_stat":"3","or_leave":"20181128手动入库","or_show":"0","true_time":"0","company_id":"1","share_user_id":"4011","receive_user_id":"4011","color_text":"","spec_text":"","all_pro_number":"1","orprod_data":[{"op_id":"5","pro_id":"4","pro_name":"纯棉花花公子长袖T恤男士秋季加绒纯色修身","pro_img":"/static/admin/images/admin.jpg","pro_num":"2","pro_price":"400","area_name":"","box_title":"0箱余2件","or_id":"3","pro_color":"绿色/黄色","pro_specs":"165/m/170/xxl","pro_spec_stock":"165/m:1件,170/xxl:1件","item_no":"002"},{"op_id":"6","pro_id":"5","pro_name":"长袖T恤男士秋季加绒纯色修身","pro_img":"/static/admin/images/admin.jpg","pro_num":"1","pro_price":"200","area_name":"","box_title":"0箱余1件","or_id":"3","pro_color":"绿色","pro_specs":"165/m","pro_spec_stock":"165/m:2件,170/xxl:1件","item_no":"002"}],"company_name":"泰国球鞋","type_detail":"入库单","or_stat_detail":"已入库"},{"or_id":"4","or_price":"100","or_tax":"0","or_vat":"0","additional_charge":"0","discount_amount":"0","outstanding_account":"0","user_phone":"18926146071","user_id":"4011","rece_name":"0","rece_phone":"0","add_time":"2018-11-29 14:04:05","or_number":"20181129075549","or_stat":"3","or_leave":"20181128手动入库","or_show":"0","true_time":"0","company_id":"1","share_user_id":"0","receive_user_id":"4011","color_text":"","spec_text":"","all_pro_number":"1","orprod_data":[{"op_id":"7","pro_id":"4","pro_name":"纯棉花花公子长袖T恤男士秋季加绒纯色修身","pro_img":"/static/admin/images/admin.jpg","pro_num":"2","pro_price":"200","area_name":"","box_title":"0箱余2件","or_id":"4","pro_color":"绿色/黄色","pro_specs":"165/m/170/xxl","pro_spec_stock":"165/m:1件,170/xxl:1件","item_no":"002"},{"op_id":"8","pro_id":"5","pro_name":"长袖T恤男士秋季加绒纯色修身","pro_img":"/static/admin/images/admin.jpg","pro_num":"1","pro_price":"100","area_name":"","box_title":"0箱余1件","or_id":"4","pro_color":"绿色","pro_specs":"165/m","pro_spec_stock":"165/m:2件,170/xxl:1件","item_no":"002"}],"company_name":"泰国球鞋","type_detail":"入库单","or_stat_detail":"已入库"}]
     * order_num : 2
     * or_price : 300
     * pro_num : 6
     * company_name : [{"company_id":"1","company_name":"泰国球鞋"}]
     */

    private String order_num;
    private String or_price;
    private String pro_num;
    private List<OrderDataBean> order_data;
    private List<CompanyNameBean> company_name;

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getOr_price() {
        return or_price;
    }

    public void setOr_price(String or_price) {
        this.or_price = or_price;
    }

    public String getPro_num() {
        return pro_num;
    }

    public void setPro_num(String pro_num) {
        this.pro_num = pro_num;
    }

    public List<OrderDataBean> getOrder_data() {
        return order_data;
    }

    public void setOrder_data(List<OrderDataBean> order_data) {
        this.order_data = order_data;
    }

    public List<CompanyNameBean> getCompany_name() {
        return company_name;
    }

    public void setCompany_name(List<CompanyNameBean> company_name) {
        this.company_name = company_name;
    }

    public static class OrderDataBean {
        /**
         * or_id : 3
         * or_price : 200
         * or_tax : 0
         * or_vat : 0
         * additional_charge : 0
         * discount_amount : 0
         * outstanding_account : 0
         * user_phone : 18926146071
         * user_id : 4011
         * rece_name : 0
         * rece_phone : 0
         * add_time : 2018-11-29 13:57:18
         * or_number : 20181129897716
         * or_stat : 3
         * or_leave : 20181128手动入库
         * or_show : 0
         * true_time : 0
         * company_id : 1
         * share_user_id : 4011
         * receive_user_id : 4011
         * color_text :
         * spec_text :
         * all_pro_number : 1
         * orprod_data : [{"op_id":"5","pro_id":"4","pro_name":"纯棉花花公子长袖T恤男士秋季加绒纯色修身","pro_img":"/static/admin/images/admin.jpg","pro_num":"2","pro_price":"400","area_name":"","box_title":"0箱余2件","or_id":"3","pro_color":"绿色/黄色","pro_specs":"165/m/170/xxl","pro_spec_stock":"165/m:1件,170/xxl:1件","item_no":"002"},{"op_id":"6","pro_id":"5","pro_name":"长袖T恤男士秋季加绒纯色修身","pro_img":"/static/admin/images/admin.jpg","pro_num":"1","pro_price":"200","area_name":"","box_title":"0箱余1件","or_id":"3","pro_color":"绿色","pro_specs":"165/m","pro_spec_stock":"165/m:2件,170/xxl:1件","item_no":"002"}]
         * company_name : 泰国球鞋
         * type_detail : 入库单
         * or_stat_detail : 已入库
         */

        private String or_id;
        private String or_price;
        private String or_tax;
        private String or_vat;
        private String additional_charge;
        private String discount_amount;
        private String outstanding_account;
        private String user_phone;
        private String user_id;
        private String rece_name;
        private String rece_phone;
        private String add_time;
        private String or_number;
        private String or_stat;
        private String or_leave;
        private String or_show;
        private String true_time;
        private String company_id;
        private String share_user_id;
        private String receive_user_id;
        private String color_text;
        private String spec_text;
        private String all_pro_number;
        private String company_name;
        private String type_detail;
        private String or_stat_detail;
        private List<OrprodDataBean> orprod_data;

        public String getOr_id() {
            return or_id;
        }

        public void setOr_id(String or_id) {
            this.or_id = or_id;
        }

        public String getOr_price() {
            return or_price;
        }

        public void setOr_price(String or_price) {
            this.or_price = or_price;
        }

        public String getOr_tax() {
            return or_tax;
        }

        public void setOr_tax(String or_tax) {
            this.or_tax = or_tax;
        }

        public String getOr_vat() {
            return or_vat;
        }

        public void setOr_vat(String or_vat) {
            this.or_vat = or_vat;
        }

        public String getAdditional_charge() {
            return additional_charge;
        }

        public void setAdditional_charge(String additional_charge) {
            this.additional_charge = additional_charge;
        }

        public String getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(String discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getOutstanding_account() {
            return outstanding_account;
        }

        public void setOutstanding_account(String outstanding_account) {
            this.outstanding_account = outstanding_account;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getRece_name() {
            return rece_name;
        }

        public void setRece_name(String rece_name) {
            this.rece_name = rece_name;
        }

        public String getRece_phone() {
            return rece_phone;
        }

        public void setRece_phone(String rece_phone) {
            this.rece_phone = rece_phone;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getOr_number() {
            return or_number;
        }

        public void setOr_number(String or_number) {
            this.or_number = or_number;
        }

        public String getOr_stat() {
            return or_stat;
        }

        public void setOr_stat(String or_stat) {
            this.or_stat = or_stat;
        }

        public String getOr_leave() {
            return or_leave;
        }

        public void setOr_leave(String or_leave) {
            this.or_leave = or_leave;
        }

        public String getOr_show() {
            return or_show;
        }

        public void setOr_show(String or_show) {
            this.or_show = or_show;
        }

        public String getTrue_time() {
            return true_time;
        }

        public void setTrue_time(String true_time) {
            this.true_time = true_time;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getShare_user_id() {
            return share_user_id;
        }

        public void setShare_user_id(String share_user_id) {
            this.share_user_id = share_user_id;
        }

        public String getReceive_user_id() {
            return receive_user_id;
        }

        public void setReceive_user_id(String receive_user_id) {
            this.receive_user_id = receive_user_id;
        }

        public String getColor_text() {
            return color_text;
        }

        public void setColor_text(String color_text) {
            this.color_text = color_text;
        }

        public String getSpec_text() {
            return spec_text;
        }

        public void setSpec_text(String spec_text) {
            this.spec_text = spec_text;
        }

        public String getAll_pro_number() {
            return all_pro_number;
        }

        public void setAll_pro_number(String all_pro_number) {
            this.all_pro_number = all_pro_number;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getType_detail() {
            return type_detail;
        }

        public void setType_detail(String type_detail) {
            this.type_detail = type_detail;
        }

        public String getOr_stat_detail() {
            return or_stat_detail;
        }

        public void setOr_stat_detail(String or_stat_detail) {
            this.or_stat_detail = or_stat_detail;
        }

        public List<OrprodDataBean> getOrprod_data() {
            return orprod_data;
        }

        public void setOrprod_data(List<OrprodDataBean> orprod_data) {
            this.orprod_data = orprod_data;
        }

        public static class OrprodDataBean {
            /**
             * op_id : 5
             * pro_id : 4
             * pro_name : 纯棉花花公子长袖T恤男士秋季加绒纯色修身
             * pro_img : /static/admin/images/admin.jpg
             * pro_num : 2
             * pro_price : 400
             * area_name :
             * box_title : 0箱余2件
             * or_id : 3
             * pro_color : 绿色/黄色
             * pro_specs : 165/m/170/xxl
             * pro_spec_stock : 165/m:1件,170/xxl:1件
             * item_no : 002
             */

            private String op_id;
            private String pro_id;
            private String pro_name;
            private String pro_img;
            private String pro_num;
            private String pro_price;
            private String area_name;
            private String box_title;
            private String or_id;
            private String pro_color;
            private String pro_specs;
            private String pro_spec_stock;
            private String item_no;

            public String getOp_id() {
                return op_id;
            }

            public void setOp_id(String op_id) {
                this.op_id = op_id;
            }

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

            public String getPro_img() {
                return pro_img;
            }

            public void setPro_img(String pro_img) {
                this.pro_img = pro_img;
            }

            public String getPro_num() {
                return pro_num;
            }

            public void setPro_num(String pro_num) {
                this.pro_num = pro_num;
            }

            public String getPro_price() {
                return pro_price;
            }

            public void setPro_price(String pro_price) {
                this.pro_price = pro_price;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getBox_title() {
                return box_title;
            }

            public void setBox_title(String box_title) {
                this.box_title = box_title;
            }

            public String getOr_id() {
                return or_id;
            }

            public void setOr_id(String or_id) {
                this.or_id = or_id;
            }

            public String getPro_color() {
                return pro_color;
            }

            public void setPro_color(String pro_color) {
                this.pro_color = pro_color;
            }

            public String getPro_specs() {
                return pro_specs;
            }

            public void setPro_specs(String pro_specs) {
                this.pro_specs = pro_specs;
            }

            public String getPro_spec_stock() {
                return pro_spec_stock;
            }

            public void setPro_spec_stock(String pro_spec_stock) {
                this.pro_spec_stock = pro_spec_stock;
            }

            public String getItem_no() {
                return item_no;
            }

            public void setItem_no(String item_no) {
                this.item_no = item_no;
            }
        }
    }

    public static class CompanyNameBean {
        /**
         * company_id : 1
         * company_name : 泰国球鞋
         */

        private String company_id;
        private String company_name;

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
    }
}
