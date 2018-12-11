package com.micropole.inventorysystem.ui.home.mvp.presenter

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class InTreasuryPresenter:InTreasuryContract.Presenter() {
    override fun treasuryList(type: Int, page: Int) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().treasuryList(type,page,0,"0").ui({
            getView()?.dismissLoadingDialog()
            getView()?.treasuryList(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel()=InTreasuryModel()
}