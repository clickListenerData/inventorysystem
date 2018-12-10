package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ShoppingMallContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ShoppingMallPresenter: ShoppingMallContract.Presenter() {
    override fun shopMall(page: String, post_desc: String) {
        getModel().shopMall(page,post_desc).ui({
            getView()?.setData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel()= ShoppingMallContract.Model()
}