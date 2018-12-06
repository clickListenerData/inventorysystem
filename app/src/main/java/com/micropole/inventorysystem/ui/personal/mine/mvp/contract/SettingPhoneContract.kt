package com.micropole.inventorysystem.ui.personal.mine.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.App
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.NewsBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       NewsContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:42
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SettingPhoneContract {

    interface View : BaseMvpView{
        fun getCode()

    }

    class Model {
        fun settPhone(old_user_phone:String,new_user_phone:String,new_code:String,old_code:String)=AppService.Api!!.settingPhone(old_user_phone,new_user_phone,new_code,old_code)
        fun getCode(phone:String)=AppService.Api!!.sendSms(phone)
    }

    abstract class Presenter : BaseMvpPresenter<Model, View>(){
        abstract fun settingPhone(old_user_phone:String,new_user_phone:String,new_code:String,old_code:String)
        abstract fun getCode(phone:String)
    }
}