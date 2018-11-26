package com.micropole.inventorysystem.ui.home.mvp.presenter

import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.contract.OutTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.contract.OutTreasuryDetailContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel
import com.micropole.inventorysystem.ui.home.mvp.model.OutTreasuryDetailModel
import com.micropole.inventorysystem.ui.home.mvp.model.OutTreasuryModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class OutTreasuryDetailPresenter:OutTreasuryDetailContract.Presenter() {
    override fun createModel()=OutTreasuryDetailModel()
}