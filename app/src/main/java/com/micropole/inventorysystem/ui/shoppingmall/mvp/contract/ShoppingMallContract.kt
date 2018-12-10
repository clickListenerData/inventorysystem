package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ShopMall
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ShoppingMallContract {
    interface View: BaseMvpLcecView<List<ShopMall>> {

    }
    class Model{
        fun shopMall(page:String,post_desc:String)=AppService.Api!!.shopMall(page,post_desc)
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun shopMall(page:String,post_desc:String)

    }

}