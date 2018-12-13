package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ClassityContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ShoppingMallContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ClassityPresenter: ClassityContract.Presenter() {
    override fun classity() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().classity().ui({
            getView()?.classity(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun createModel()= ClassityContract.Model()
}