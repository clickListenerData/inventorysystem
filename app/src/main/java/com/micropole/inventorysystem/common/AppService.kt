package com.micropole.inventorysystem.common

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.micropole.baseapplibrary.appconst.AppApi
import com.micropole.inventorysystem.entity.*
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import com.xx.baseutilslibrary.network.gson.XxGsonConverterFactory
import io.reactivex.Observable
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * @ClassName       AppService
 * @Description     api
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/4 10:59
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
object AppService {

    var Api : API? = null
        get() {
            if (field == null){
                initRetrofit()
                field = AppApi.Api()
            }
            return field
        }

    fun initRetrofit(){
        AppApi.setTimeOut()
        AppApi.setIntercept(StethoInterceptor(),HeaderInterceptor(),TokenInterceptor(), HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        AppApi.setConverterFactory(XxGsonConverterFactory.create())
    }

    interface API{
        /**
         * 刷新token
         */
        @POST("login/get_short_token")
        @FormUrlEncoded
        fun refreshToken(@Field("long_token") token:String) : Call<BaseResponseEntity<ShortTokenBean>>

        /**
         * 图片上传
         */
        @POST("Index/imgup")
        @FormUrlEncoded
        fun imgUp(@Field("img") img : String) : Observable<BaseResponseEntity<ImgUpBean>>

        /**
         * 发送验证码
         */
        @Headers("language:1")
        @POST("login/sendSMS")
        @FormUrlEncoded
        fun sendSms(@Field("phone") phone: String) : Observable<BaseResponseEntity<LoginBean>>

        @POST("Index/get_country")
        fun getCountry() : Observable<BaseResponseEntity<List<String>>>

        /**
         * 登录
         */
        @Headers("language:1")
        @POST("login/login")
        @FormUrlEncoded
        fun login(@Field("user_phone") phone:String, @Field("sign") pwd:String) : Observable<BaseResponseEntity<LoginBean>>

        /**
         * 注册
         */
        @Headers("language:1")
        @POST("login/reg")
        @FormUrlEncoded
        fun register(@Field("user_img") img:String, @Field("nickname") nickname:String,
                     @Field("user_nationality") country:String,@Field("user_birthday") birthday:String,
                     @Field("user_phone") phone:String,@Field("code") code:String,
                     @Field("user_pwd") pwd:String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 公司角色,合作方类型，合作方等级
         */
        @Headers("token:1","language:1")
        @POST("index/get_config_message")
        @FormUrlEncoded
        fun getConfigMsg(@Field("type") type : Int) : Observable<BaseResponseEntity<List<PositionBean>>>

        /**
         * 忘记密码
         */
        @POST("login/forget_passwd")
        @FormUrlEncoded
        fun forgetPwd(@Field("user_phone") phone:String,@Field("code") code:String,
                      @Field("user_pwd") pwd:String) : Observable<BaseResponseEntity<List<String>>>
        /**
         * 修改手机
         */
        @Headers("token:1")
        @POST("User/update_user_phone")
        @FormUrlEncoded
        fun settingPhone(@Field("old_user_phone") old_user_phone:String,@Field("new_user_phone") new_user_phone:String,
                      @Field("new_code") new_code:String,@Field("old_code")old_code:String) : Observable<BaseResponseEntity<List<String>>>
        /**
         * 修改密码
         */
        @Headers("token:1")
        @POST("user/update_user_pwd")
        @FormUrlEncoded
        fun settingPW(@Field("old_user_pwd") old_user_pwd	:String,@Field("new_user_pwd") new_user_pwd:String,
                         @Field("confirm_user_pwd") comfirm_user_pwd:String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 用户信息
         */
        @Headers("token:1","language:1")
        @POST("User/index")
        fun userInfo() : Observable<BaseResponseEntity<UserInfoBean>>
        /**
         * 修改用户昵称或者修改性别或修改用户头像
         */
        @Headers("token:1")
        @POST("User/update_user")
        @FormUrlEncoded
        fun settingInfo(@Field("nickname")nickname:String,@Field("user_sex")user_sex:String,@Field("user_img")user_img:String,@Field("user_birthday")user_birthday:String) : Observable<BaseResponseEntity<List<String>>>
        /**
         * 意见反馈
         */
        @Headers("token:1")
        @POST("user/user_feetback")
        @FormUrlEncoded
        fun feedback(@Field("content") content:String) : Observable<BaseResponseEntity<List<String>>>
        /**
         * 关于我们
         */
        @Headers("token:1")
        @POST("user/about_us")
        fun aboutAs() : Observable<BaseResponseEntity<AboutAsBean>>
        /**
         * 公司信息
         */
        @Headers("token:1","language:1")
        @POST("User/user_company")
        fun companyMsg() : Observable<BaseResponseEntity<UserInfoBean>>

        /**
         * 分类列表
         */
        @Headers("token:1","language:1")
        @POST("area/area_list")
        fun categoryList() : Observable<BaseResponseEntity<CategoryBean>>

        /**
         * 添加分类
         */
        @Headers("token:1","language:1")
        @POST("area/add_area")
        @FormUrlEncoded
        fun addCategory(@Field("area_name") name : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 编辑分类
         */
        @Headers("token:1","language:1")
        @POST("area/edit_area")
        @FormUrlEncoded
        fun editCategory(@Field("area_id") id : String,@Field("area_name") name : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 删除分类
         */
        @Headers("token:1","language:1")
        @POST("area/delete_area")
        @FormUrlEncoded
        fun deleteCategory(@Field("area_id") id : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 颜色列表
         */
        @Headers("token:1","language:1")
        @POST("color/color_list")
        fun colorList() : Observable<BaseResponseEntity<ColorBean>>

        /**
         * 添加颜色
         */
        @Headers("token:1","language:1")
        @POST("color/add_color")
        @FormUrlEncoded
        fun addColor(@Field("color_name") name : String,@Field("color") color : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 删除颜色
         */
        @Headers("token:1","language:1")
        @POST("color/delete_color")
        @FormUrlEncoded
        fun deleteColor(@Field("color_id") id : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 材质列表
         */
        @Headers("token:1","language:1")
        @POST("texture/texture_list")
        fun materialList() : Observable<BaseResponseEntity<MaterialBean>>

        /**
         * 添加材质
         */
        @Headers("token:1","language:1")
        @POST("texture/add_texture")
        @FormUrlEncoded
        fun addMaterial(@Field("texture_name") name : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 删除材质
         */
        @Headers("token:1","language:1")
        @POST("texture/delete_texture")
        @FormUrlEncoded
        fun deleteMaterial(@Field("texture_id") id : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 规格列表
         */
        @Headers("token:1","language:1")
        @POST("spec/spec_list")
        fun sizeList() : Observable<BaseResponseEntity<SpecBean>>

        /**
         * 添加规格
         */
        @Headers("token:1","language:1")
        @POST("spec/add_spec")
        @FormUrlEncoded
        fun addSize(@Field("spec_name") name : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 删除规格
         */
        @Headers("token:1","language:1")
        @POST("spec/delete_spec")
        @FormUrlEncoded
        fun deleteSize(@Field("spec_id") id : String,@Field("product_id") product_id :String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 新增商品
         */
        @Headers("token:1","language:1")
        @POST("product/add_product")
        @FormUrlEncoded
        fun addGoods(@Field("area_id") category : String,@Field("product_sn") sn : String,
                     @Field("cost_price") cost_price : String,@Field("retail_price") retail_price : String,
                     @Field("remark") remark : String,@Field("color") color : String,
                     @Field("spec") spec : String,@Field("texture") texture : String,
                     @Field("cover_img") cover_img : String,@Field("pack_ratio") pack_ratio : String)
                : Observable<BaseResponseEntity<List<String>>>


        /**
         * 商品详情
         */
        @Headers("token:1","language:1")
        @POST("product/product_detail")
        @FormUrlEncoded
        fun goodsDetail(@Field("product_id") id: String) : Observable<BaseResponseEntity<GoodsDetailBean>>

        /**
         * 商品列表
         */
        @Headers("token:1","language:1")
        @POST("product/product_list")
        @FormUrlEncoded
        fun goodsList(@Field("area_id") category:String,@Field("sort") sort : Int) : Observable<BaseResponseEntity<InventoryGoodsBean>>

        /**
         * 添加公司
         */
        @Headers("token:1","language:1")
        @POST("Company/company_add")
        @FormUrlEncoded
        fun addCompany(@Field("company_postbox") email : String,@Field("company_address") address : String,
                     @Field("company_img") cover_img : String,@Field("company_contact") contact : String,
                     @Field("company_name") name : String,@Field("company_industry") industry : String,
                       @Field("company_nationality") country : String,@Field("company_notice") notice : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 更新公司信息
         */
        @Headers("token:1","language:1")
        @POST("Company/company_update")
        @FormUrlEncoded
        fun editCompany(@Field("company_postbox") email : String,@Field("company_address") address : String,
                        @Field("company_img") cover_img : String,@Field("company_contact") contact : String,
                        @Field("company_name") name : String,@Field("company_industry") industry : String,
                        @Field("company_nationality") country : String,@Field("company_notice") notice : String)
                : Observable<BaseResponseEntity<List<String>>>

        /**
         * 公司成员列表
         */
        @Headers("token:1","language:1")
        @POST("Company/get_user_list")
        fun memberList() : Observable<BaseResponseEntity<List<MemberListBean>>>

        /**
         * 已邀请成员列表
         */
        @Headers("token:1","language:1")
        @POST("Company/invitation_user_list")
        fun invitationMember() : Observable<BaseResponseEntity<InvitationBean>>

        /**
         * 搜索用户信息
         */
        @Headers("token:1","language:1")
        @POST("Company/get_user")
        @FormUrlEncoded
        fun searchMember(@Field("user_id") id : String = "",@Field("user_phone") phone : String = "") : Observable<BaseResponseEntity<SearchMemberBean>>

        /**
         * 公司添加成员
         */
        @Headers("token:1","language:1")
        @POST("Company/add_company_user")
        @FormUrlEncoded
        fun addMember(@Field("user_phone") phone : String?,@Field("user_nationality") country : String?,
                      @Field("user_birthday") birthday: String?,@Field("user_remark") remark: String?,
                      @Field("r_role") role : String?,@Field("user_id") userId : String?,@Field("user_email") email : String?)
                : Observable<BaseResponseEntity<List<String>>>

        /**
         * 公司移除成员
         */
        @Headers("token:1","language:1")
        @POST("Company/delete_company_user")
        @FormUrlEncoded
        fun removeMember(@Field("user_id") userId : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 转让公司
         */
        @Headers("token:1","language:1")
        @POST("Company/transfer_user")
        @FormUrlEncoded
        fun transferCompany(@Field("user_id") id : String) : Observable<BaseResponseEntity<SearchMemberBean>>

        /**
         * 同意拒绝加入公司
         */
        @Headers("token:1","language:1")
        @POST("Company/update_company_user")
        @FormUrlEncoded
        fun isagreeCompany(@Field("company_id") id: String,@Field("stat") stat : String): Observable<BaseResponseEntity<List<String>>>


        /*入库*/
        @Headers("token:1","language:1")
        @POST("order/order_list")
        @FormUrlEncoded
        fun treasurylist(@Field("type") type : Int,@Field("page") page : Int,
                         @Field("order_deac") deac : Int,@Field("company_id") companyID : String)
                        : Observable<BaseResponseEntity<TreasuryBean>>


        /**
         * 商城首页
         */
        @Headers("token:1","language:1")
        @POST("Sproduct/store_index")
        @FormUrlEncoded
        fun shopMall(@Field("page") page:String,@Field("post_desc")post_desc:String) : Observable<BaseResponseEntity<List<ShopMall>>>

        /**
         * 商品详情
         */
        @Headers("token:1","language:1")
        @POST("Sproduct/product_detail")
        @FormUrlEncoded
        fun productDetail(@Field("pro_id") id : String) : Observable<BaseResponseEntity<ProductDetailBean>>

        /**
         * 立即购买
         */
        @Headers("token:1","language:1")
        @POST("sorder/purchase_order")
        @FormUrlEncoded
        fun confirmBuy(@Field("sh_id") id : String,@Field("pro_num") num : String,@Field("re_id") re_id : String,
                       @Field("prodinfo") mo :String) : Observable<BaseResponseEntity<ConfirmOrderBean>>

        /**
         * 生成订单
         */
        @Headers("token:1","language:1")
        @POST("sorder/add_order")
        @FormUrlEncoded
        fun buyOrder(@Field("sh_id") id : String,@Field("pro_num") num : String,@Field("re_id") re_id : String,
                     @Field("prodinfo") mo :String,@Field("or_leave_json") json : String) : Observable<BaseResponseEntity<BuyOrderBean>>

        /**
         * 选择规格
         */
        @Headers("token:1","language:1")
        @POST("Sproduct/select_spec")
        @FormUrlEncoded
        fun selectProSpec(@Field("pro_id") id : String,@Field("sp_name") sp : String,
                          @Field("mo_name") mo : String) : Observable<BaseResponseEntity<SelectSpecBean>>

        /**
         * 收藏商品
         */
        @Headers("token:1","language:1")
        @POST("scollect/collect_add")
        @FormUrlEncoded
        fun collectProduct(@Field("pro_id") id : String) : Observable<BaseResponseEntity<List<String>>>
        /**
         * 购物车信息
         */
        @Headers("token:1","language:1")
        @POST("shopp/shopp_list")
        fun car() : Observable<BaseResponseEntity<CarBean>>
        /**
         * 加入购物车
         */
        @Headers("token:1","language:1")
        @POST("shopp/add_shopp")
        @FormUrlEncoded
        fun addCar(@Field("pro_id") pro_id : String,@Field("pro_num") pro_num:String,@Field("sp_name")sp_name:String,@Field("mo_name") mo_name:String)
                : Observable<BaseResponseEntity<List<String>>>
        /**
         * 购物车更新
         */
        @Headers("token:1","language:1")
        @POST("shopp/update_shopp")
        @FormUrlEncoded
        fun updateCar(@Field("sh_id") sh_id : String,@Field("pro_num") pro_num:String,@Field("check_status")check_status:String)
                : Observable<BaseResponseEntity<UpdateCar>>
        /**
         * 删除购物车
         */
        @Headers("token:1","language:1")
        @POST("shopp/del_shopp")
        @FormUrlEncoded
        fun deleteCar(@Field("sh_id") sh_id : String): Observable<BaseResponseEntity<List<String>>>
        /**
         * 商城搜索
         */
        @Headers("token:1","language:1")
        @POST("sproduct/search_index")
        fun hotSearch( ): Observable<BaseResponseEntity<SearchBean>>
        /**
         * 搜索商品
         */
        @Headers("token:1","language:1")
        @POST("sproduct/search")
        @FormUrlEncoded
        fun searchProduct(@Field("keyword")keyword:String,@Field("order_desc") order_desc:String): Observable<BaseResponseEntity<SearchPotuct>>
        /**
         * 分类列表
         */
        @Headers("token:1","language:1")
        @POST("Sarea/area_list")
        fun classity(): Observable<BaseResponseEntity<List<ClassityBean>>>
        /**
         * 收藏列表
         */
        @Headers("token:1","language:1")
        @POST("scollect/collect_list")
        fun collectList() : Observable<BaseResponseEntity<List<CollectBean>>>

        /**
         * 足迹列表
         */
        @Headers("token:1","language:1")
        @POST("Sfootprint/footprint_list")
        fun footList() : Observable<BaseResponseEntity<List<CollectBean>>>

        /**
         * 删除收藏
         */
        @Headers("token:1","language:1")
        @POST("scollect/collect_del")
        @FormUrlEncoded
        fun deleteCollect(@Field("pro_id") id : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 删除足迹
         */
        @Headers("token:1","language:1")
        @POST("Sfootprint/footprint_del")
        @FormUrlEncoded
        fun deletefoot(@Field("pro_id") id : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 订单列表
         */
        @Headers("token:1","language:1")
        @POST("sorder/order_list")
        @FormUrlEncoded
        fun orderList(@Field("or_stat") stat: String) : Observable<BaseResponseEntity<List<OrderListBean>>>

        /**
         * 订单详情
         */
        @Headers("token:1","language:1")
        @POST("sorder/order_detail")
        @FormUrlEncoded
        fun orderDetail(@Field("or_id") id: String) : Observable<BaseResponseEntity<OrderDetailBean>>

        /**
         * 地址列表
         */
        @Headers("token:1","language:1")
        @POST("saddress/user_address")
        fun addressList() : Observable<BaseResponseEntity<List<AddressBean>>>

        /**
         * 添加收货地址
         */
        @Headers("token:1","language:1")
        @POST("saddress/add_address")
        @FormUrlEncoded
        fun addAddress(@Field("rece_name") name: String,@Field("rece_phone") phone: String,
                       @Field("address") address: String,@Field("is_default") default:Int) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 编辑收货地址
         */
        @Headers("token:1","language:1")
        @POST("saddress/edit_address")
        @FormUrlEncoded
        fun editAddress(@Field("rece_name") name: String,@Field("rece_phone") phone: String,
                       @Field("address") address: String,@Field("is_default") default:Int,
                        @Field("address_id") id: String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 删除收货地址
         */
        @Headers("token:1","language:1")
        @POST("saddress/delete_address")
        @FormUrlEncoded
        fun deleteAddress(@Field("address_id") id: String) : Observable<BaseResponseEntity<List<String>>>

    }
}