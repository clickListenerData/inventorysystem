package com.micropole.inventorysystem.ui.login.mvp.model

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ImgUpBean
import com.micropole.inventorysystem.entity.LoginBean
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.micropole.inventorysystem.ui.login.mvp.contract.RegisterContract
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class RegisterModel:RegisterContract.Model {
    override fun getCountry(): Observable<BaseResponseEntity<List<String>>> {
        return AppService.Api!!.getCountry()
    }

    override fun imgUp(img: String): Observable<BaseResponseEntity<ImgUpBean>> {
        return AppService.Api!!.imgUp(img)
    }

    override fun sendSMS(phone: String): Observable<BaseResponseEntity<LoginBean>> {
        return AppService.Api!!.sendSms(phone)
    }

    override fun register(img: String, name: String, country: String, birthday: String, phone: String, code: String, pwd: String): Observable<BaseResponseEntity<List<String>>> {
        return AppService.Api!!.register(img,name,country, birthday, phone, code, pwd)
    }
}