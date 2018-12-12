package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName ProductDetailBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/10 11:31
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class ProductDetailBean {

    /**
     * pro_id : 116
     * pro_name : qwe
     * pro_label : qwe
     * pro_text : <p><img src="/ueditor/php/upload/image/20181204/1543918038306601.png" title="1543918038306601.png" alt="5bb81efc8f84d.png"/></p><p><br/></p>
     * pro_img : /uploads/20181211/e1139da3be71ae4b752b57464ecbf29f.jpg
     * pro_imgs : ["/uploads/20181211/3d7efd37b04d0096d6a3922d6f7d190c.jpg","/uploads/20181211/a5a64b1d399878e3c5b85fba9be360f1.jpg","/uploads/20181211/d7da2a4e53952e0498bf3a1e0e571328.jpg","/uploads/20181211/ad7cb3c68e6902722f73e8445d553dc1.jpg"]
     * pro_stock : 0
     * pro_recos : 0
     * pro_sort : 0
     * pro_sales : 0
     * area_id : 103
     * pro_status : 1
     * pro_commission : 0
     * pro_shop_price : 23
     * pro_market_price : 123
     * pro_addtime : 1544515603
     * pro_browse : 0
     * pro_weight : 0.00
     * pro_type : 0
     * bulk_number : 0
     * bulk_end_time : 0
     * bulk_start_time : 0
     * is_del : 0
     * del_time : 0
     * pro_years : 0
     * is_pinkage : 0
     * is_pinkage_store : 0
     * pinkage_start_time : 0
     * pinkage_end_time : 0
     * pinkage_number : 0
     * integral : 0
     * audit : 1
     * bulk_integral : 0
     * activity : qwe
     * store_user_id : 0
     * pro_score : 5.00
     * bar_code : qwe
     * is_copy : 0
     * is_all_return : 1
     * bulkteam : {}
     * bulkteam_number : 0
     * shopp_number : 0
     * pro_collect : 0
     * store_collect : 0
     * store : {"store_id":1,"user_id":0,"st_name":"其力汽车总店","st_image":"http://qili.car.pf868.com/uploads/20181109/8a39397ce9a11e1e56930e4ea3821b2f.jpg","charge_name":"","charge_telephone":"0","st_type":0,"business_time":"","business_scope":"","province":"广东省","city":"广州市","district":"天河区","address":"","st_introduce":"","outside_img":"","inside_img":"","license_name":"","legal_user_name":"","license_number":"","business_license":"","examine_status":1,"examine_time":0,"score":0,"label":"0","telephone":"","lat_long":"113.3","fans_num":103,"product_num":8,"store_qr_code":"","stat":1,"sort":0,"add_time":0}
     * sp_name_arr : ["红色"]
     * mo_name_arr : ["件"]
     * monthly_sale : 0
     */

    private String pro_id;
    private String pro_name;
    private String pro_label;
    private String pro_text;
    private String pro_img;
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
    private String bulkteam_number;
    private String shopp_number;
    private String pro_collect;
    private String store_collect;
    private StoreBean store;
    private String monthly_sale;
    private List<String> pro_imgs;
    private List<String> sp_name_arr;
    private List<String> mo_name_arr;

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



    public String getBulkteam_number() {
        return bulkteam_number;
    }

    public void setBulkteam_number(String bulkteam_number) {
        this.bulkteam_number = bulkteam_number;
    }

    public String getShopp_number() {
        return shopp_number;
    }

    public void setShopp_number(String shopp_number) {
        this.shopp_number = shopp_number;
    }

    public String getPro_collect() {
        return pro_collect;
    }

    public void setPro_collect(String pro_collect) {
        this.pro_collect = pro_collect;
    }

    public String getStore_collect() {
        return store_collect;
    }

    public void setStore_collect(String store_collect) {
        this.store_collect = store_collect;
    }

    public StoreBean getStore() {
        return store;
    }

    public void setStore(StoreBean store) {
        this.store = store;
    }

    public String getMonthly_sale() {
        return monthly_sale;
    }

    public void setMonthly_sale(String monthly_sale) {
        this.monthly_sale = monthly_sale;
    }

    public List<String> getPro_imgs() {
        return pro_imgs;
    }

    public void setPro_imgs(List<String> pro_imgs) {
        this.pro_imgs = pro_imgs;
    }

    public List<String> getSp_name_arr() {
        return sp_name_arr;
    }

    public void setSp_name_arr(List<String> sp_name_arr) {
        this.sp_name_arr = sp_name_arr;
    }

    public List<String> getMo_name_arr() {
        return mo_name_arr;
    }

    public void setMo_name_arr(List<String> mo_name_arr) {
        this.mo_name_arr = mo_name_arr;
    }

    public static class BulkteamBean {
    }

    public static class StoreBean {
        /**
         * store_id : 1
         * user_id : 0
         * st_name : 其力汽车总店
         * st_image : http://qili.car.pf868.com/uploads/20181109/8a39397ce9a11e1e56930e4ea3821b2f.jpg
         * charge_name :
         * charge_telephone : 0
         * st_type : 0
         * business_time :
         * business_scope :
         * province : 广东省
         * city : 广州市
         * district : 天河区
         * address :
         * st_introduce :
         * outside_img :
         * inside_img :
         * license_name :
         * legal_user_name :
         * license_number :
         * business_license :
         * examine_status : 1
         * examine_time : 0
         * score : 0
         * label : 0
         * telephone :
         * lat_long : 113.3
         * fans_num : 103
         * product_num : 8
         * store_qr_code :
         * stat : 1
         * sort : 0
         * add_time : 0
         */

        private String store_id;
        private String user_id;
        private String st_name;
        private String st_image;
        private String charge_name;
        private String charge_telephone;
        private String st_type;
        private String business_time;
        private String business_scope;
        private String province;
        private String city;
        private String district;
        private String address;
        private String st_introduce;
        private String outside_img;
        private String inside_img;
        private String license_name;
        private String legal_user_name;
        private String license_number;
        private String business_license;
        private String examine_status;
        private String examine_time;
        private String score;
        private String label;
        private String telephone;
        private String lat_long;
        private String fans_num;
        private String product_num;
        private String store_qr_code;
        private String stat;
        private String sort;
        private String add_time;

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSt_name() {
            return st_name;
        }

        public void setSt_name(String st_name) {
            this.st_name = st_name;
        }

        public String getSt_image() {
            return st_image;
        }

        public void setSt_image(String st_image) {
            this.st_image = st_image;
        }

        public String getCharge_name() {
            return charge_name;
        }

        public void setCharge_name(String charge_name) {
            this.charge_name = charge_name;
        }

        public String getCharge_telephone() {
            return charge_telephone;
        }

        public void setCharge_telephone(String charge_telephone) {
            this.charge_telephone = charge_telephone;
        }

        public String getSt_type() {
            return st_type;
        }

        public void setSt_type(String st_type) {
            this.st_type = st_type;
        }

        public String getBusiness_time() {
            return business_time;
        }

        public void setBusiness_time(String business_time) {
            this.business_time = business_time;
        }

        public String getBusiness_scope() {
            return business_scope;
        }

        public void setBusiness_scope(String business_scope) {
            this.business_scope = business_scope;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSt_introduce() {
            return st_introduce;
        }

        public void setSt_introduce(String st_introduce) {
            this.st_introduce = st_introduce;
        }

        public String getOutside_img() {
            return outside_img;
        }

        public void setOutside_img(String outside_img) {
            this.outside_img = outside_img;
        }

        public String getInside_img() {
            return inside_img;
        }

        public void setInside_img(String inside_img) {
            this.inside_img = inside_img;
        }

        public String getLicense_name() {
            return license_name;
        }

        public void setLicense_name(String license_name) {
            this.license_name = license_name;
        }

        public String getLegal_user_name() {
            return legal_user_name;
        }

        public void setLegal_user_name(String legal_user_name) {
            this.legal_user_name = legal_user_name;
        }

        public String getLicense_number() {
            return license_number;
        }

        public void setLicense_number(String license_number) {
            this.license_number = license_number;
        }

        public String getBusiness_license() {
            return business_license;
        }

        public void setBusiness_license(String business_license) {
            this.business_license = business_license;
        }

        public String getExamine_status() {
            return examine_status;
        }

        public void setExamine_status(String examine_status) {
            this.examine_status = examine_status;
        }

        public String getExamine_time() {
            return examine_time;
        }

        public void setExamine_time(String examine_time) {
            this.examine_time = examine_time;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getLat_long() {
            return lat_long;
        }

        public void setLat_long(String lat_long) {
            this.lat_long = lat_long;
        }

        public String getFans_num() {
            return fans_num;
        }

        public void setFans_num(String fans_num) {
            this.fans_num = fans_num;
        }

        public String getProduct_num() {
            return product_num;
        }

        public void setProduct_num(String product_num) {
            this.product_num = product_num;
        }

        public String getStore_qr_code() {
            return store_qr_code;
        }

        public void setStore_qr_code(String store_qr_code) {
            this.store_qr_code = store_qr_code;
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
