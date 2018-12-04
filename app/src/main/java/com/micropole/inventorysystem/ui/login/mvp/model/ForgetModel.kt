package com.micropole.inventorysystem.ui.login.mvp.model

import com.micropole.inventorysystem.App
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.LoginBean
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.login.mvp.contract.FotgetContract
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ForgetModel:FotgetContract.Model {
    override fun sendSMS(phone: String): Observable<BaseResponseEntity<LoginBean>> {
        return AppService.Api!!.sendSms(phone)
    }

    override fun forgetPwd(phone: String, code: String, pwd: String) : Observable<BaseResponseEntity<List<String>>>{
        return AppService.Api!!.forgetPwd(phone, code, pwd)
    }
}