package com.micropole.inventorysystem.ui.login.mvp.contract

import com.micropole.inventorysystem.entity.ImgUpBean
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
class RegisterContract {
    interface View:BaseMvpView{
        fun getCountry(data : List<String>)
    }
    interface Model{
        fun register(img : String,name : String,country : String,
                     birthday : String,phone : String,code : String,pwd : String) : Observable<BaseResponseEntity<List<String>>>
        fun sendSMS(phone: String) : Observable<BaseResponseEntity<LoginBean>>

        fun imgUp(img: String) : Observable<BaseResponseEntity<ImgUpBean>>
        fun getCountry() : Observable<BaseResponseEntity<List<String>>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun register(img : String,name : String,country : String,
                              birthday : String,phone : String,code : String,pwd : String)

        abstract fun sendSMS(phone: String)

        abstract fun getCountry()
    }

}