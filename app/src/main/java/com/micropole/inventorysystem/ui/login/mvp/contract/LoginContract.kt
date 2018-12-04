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
class LoginContract {
    interface View:BaseMvpView{

    }
    interface Model{
        fun login(phone :String,pwd:String) : Observable<BaseResponseEntity<LoginBean>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun login(phone: String,pwd: String)
    }

}