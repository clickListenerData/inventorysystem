package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.SearchPotuct
import com.micropole.inventorysystem.entity.ShopMall
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ClassitySearchContract {
    interface View: BaseMvpView {
        fun searchProduct(searchPotuct: SearchPotuct)

    }
    class Model{
        fun searchProduct(keyword:String,order_desc:String,area_id:String)=AppService.Api!!.searchProduct(keyword,order_desc,area_id)

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun searchProduct(keyword:String,order_desc:String,area_id:String)

    }

}