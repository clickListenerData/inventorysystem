package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import android.util.Log
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ClassitySearchContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ClassitySearchPresenter: ClassitySearchContract.Presenter() {
    override fun searchProduct(keyword: String,order_desc:String,area_id:String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().searchProduct(keyword,order_desc,area_id).ui({
            getView()?.searchProduct(it.data!!)
            getView()?.dismissLoadingDialog()
            Log.i("asasas",it.data!!.toString())
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun createModel()= ClassitySearchContract.Model()
}