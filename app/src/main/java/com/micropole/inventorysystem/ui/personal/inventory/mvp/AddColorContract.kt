package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       AddColorContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 11:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddColorContract {

    interface View : BaseMvpView

    class Model(){
        fun addColor(name:String,color : String) = AppService.Api!!.addColor(name, color)
    }

    abstract class Presente : BaseMvpPresenter<Model,View>(){
        abstract fun addcolor(name: String,color: String)
    }
}