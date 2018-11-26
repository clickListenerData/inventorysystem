package com.micropole.inventorysystem

import com.micropole.baseapplibrary.BaseApplication
import com.xx.baseutilslibrary.network.provider.XxApiConfigProvider
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager

/**
 * @ClassName       App
 * @Description     applicaiton
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/20 9:36
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class App : BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        initApi()
    }

    private fun initApi(){
        Retrofit2Manager.instance.apiConfigProvider = object : XxApiConfigProvider {
            override fun getReleaseHost(): String = BuildConfig.RELEASE_DOMAIN

            override fun getDebugHost(): String = BuildConfig.DEV_DOMAIN

            override fun getApiRelativePath(): String = "/api/"

            override fun isDebug(): Boolean = false
        }
    }
}