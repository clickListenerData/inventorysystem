package com.micropole.inventorysystem.ui.home.mvp.presenter

import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryDetailContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryDetailModel
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class InTreasuryDetailPresenter:InTreasuryDetailContract.Presenter() {
    override fun createModel()=InTreasuryDetailModel()
}