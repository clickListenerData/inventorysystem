package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ClassityBean
import com.micropole.inventorysystem.entity.ShopMall
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ClassityContract {
    interface View: BaseMvpView {
        fun classity(classityBean: List<ClassityBean>)
    }
    class Model{
        fun classity()=AppService.Api!!.classity()
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
      abstract  fun classity()

    }

}