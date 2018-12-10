package com.micropole.inventorysystem.ui.personal.mine.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
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
class SettingPWContract {

    interface View : BaseMvpView{
    }

    class Model {
        fun settingPW(old_user_pwd:String,new_user_pwd:String,comfirm_user_pwd:String)=AppService.Api!!.settingPW(old_user_pwd,new_user_pwd,comfirm_user_pwd)
    }

    abstract class Presenter : BaseMvpPresenter<Model, View>(){
        abstract  fun settingPW(old_user_pwd:String,new_user_pwd:String,comfirm_user_pwd:String)
    }
}