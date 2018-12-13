package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.SearchShopContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class SearchShopPresenter: SearchShopContract.Presenter() {
    override fun searchProduct(keyword: String,order_desc:String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().searchProduct(keyword,order_desc).ui({
            getView()?.searchProduct(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun hotSearch() {
        getModel().hotSeacrch().ui({
                getView()?.hotSeacrh(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }


    override fun createModel()= SearchShopContract.Model()
}