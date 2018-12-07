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
                     @Field("cover_img") cover_img : String,@Field("pack_ratio") pack_ratio : String,
                     @Field("product_name") name : String) : Observable<BaseResponseEntity<List<String>>>

        /**
         * 添加公司
         */
        @Headers("token:1","language:1")
        @POST("Company/company_add")
        @FormUrlEncoded
        fun addCompany(@Field("company_postbox") email : String,@Field("company_address") address : String,
                     @Field("company_img") cover_img : String,@Field("company_contact") contact : String,
                     @Field("company_name") name : String) : Observable<BaseResponseEntity<List<String>>>

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
    }
}