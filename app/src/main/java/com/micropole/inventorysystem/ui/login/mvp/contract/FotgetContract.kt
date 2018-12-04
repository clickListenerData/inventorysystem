package com.micropole.inventorysystem.ui.login.mvp.contract

import com.micropole.inventorysystem.entity.LoginBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class FotgetContract {
    interface View:BaseMvpView{

    }
    interface Model{
        fun sendSMS(phone : String) : Observable<BaseResponseEntity<LoginBean>>
        fun forgetPwd(phone: String,code : String,pwd : String) : Observable<BaseResponseEntity<List<String>>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun sendSMS(phone: String)
        abstract fun forgetPwd(phone: String,code: String,pwd: String)
    }

}