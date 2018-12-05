package com.micropole.inventorysystem.ui.personal.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.UserInfoBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       PersonalContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 9:16
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalContract {

    interface View : BaseMvpLcecView<UserInfoBean>

    class Model{
        fun userInfo() = AppService.Api!!.userInfo()
    }

    abstract class Presenter() : BaseMvpPresenter<Model,View>(){
        abstract fun userInfo()
    }
}