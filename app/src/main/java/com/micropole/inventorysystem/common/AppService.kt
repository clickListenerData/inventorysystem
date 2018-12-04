package com.micropole.inventorysystem.common

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.micropole.baseapplibrary.appconst.AppApi
import com.micropole.inventorysystem.entity.ImgUpBean
import com.micropole.inventorysystem.entity.LoginBean
import com.micropole.inventorysystem.entity.ShortTokenBean
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
        @Headers("long_token:1")
        @POST("login/get_short_token")
        fun refreshToken() : Call<BaseResponseEntity<ShortTokenBean>>

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
                     @Field("user_pwd") pwd:String) : Observable<BaseResponseEntity<LoginBean>>

        /**
         * 忘记密码
         */
        @POST("login/forget_passwd")
        @FormUrlEncoded
        fun forgetPwd(@Field("user_phone") phone:String,@Field("code") code:String,
                      @Field("user_pwd") pwd:String) : Observable<BaseResponseEntity<List<String>>>
    }
}