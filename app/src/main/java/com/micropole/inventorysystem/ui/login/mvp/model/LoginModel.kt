package com.micropole.inventorysystem.ui.login.mvp.model

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.LoginBean
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class LoginModel:LoginContract.Model {
    override fun login(phone: String, pwd: String): Observable<LoginBean> {
        return AppService.Api!!.login(phone, pwd)
    }
}