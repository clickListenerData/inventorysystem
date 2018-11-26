package com.micropole.inventorysystem.ui.home.mvp.presenter

import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.contract.NewBuildOrderContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel
import com.micropole.inventorysystem.ui.home.mvp.model.NewBuildOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class NewBuildOrderPresenter:NewBuildOrderContract.Presenter() {
    override fun createModel()=NewBuildOrderModel()
}