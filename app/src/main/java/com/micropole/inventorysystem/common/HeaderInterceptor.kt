package com.micropole.inventorysystem.common

import com.blankj.utilcode.util.ActivityUtils
import com.micropole.baseapplibrary.appconst.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @ClassName       HeaderInterceptor
 * @Description     OK http 拦截 添加 header
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/4 13:44
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HeaderInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()
        val newBuilder = request?.newBuilder()
        val headers = request?.headers()
        val names = headers?.names()
        for (i in names!!.iterator()){
            when (i) {
                "token" -> {
                    newBuilder?.removeHeader(i)
                    newBuilder?.addHeader(i,Constants.getShotToken())
                }
                "language" -> {
                    val language = ActivityUtils.getTopActivity().baseContext.resources.configuration.locale.toString()
                    newBuilder?.removeHeader(i)
                    newBuilder?.addHeader(i,language)
                }
                "long_token" -> {
                    newBuilder?.removeHeader(i)
                    newBuilder?.addHeader(i,Constants.getLongToken())
                }
            }
        }

        return chain.proceed(newBuilder?.build())
    }
}