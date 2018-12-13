package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.SearchBean
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
class SearchShopContract {
    interface View: BaseMvpView {
        fun hotSeacrh(hotSearchBean: SearchBean)
        fun searchProduct(searchPotuct: SearchPotuct)

    }
    class Model{
        fun hotSeacrch()=AppService.Api!!.hotSearch()
        fun searchProduct(keyword:String,order_desc	:String)=AppService.Api!!.searchProduct(keyword,order_desc)
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun hotSearch()
        abstract fun searchProduct(keyword:String,order_desc:String)

    }

}