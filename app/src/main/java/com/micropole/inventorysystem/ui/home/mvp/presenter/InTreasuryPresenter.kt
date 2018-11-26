package com.micropole.inventorysystem.ui.home.mvp.presenter

import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class InTreasuryPresenter:InTreasuryContract.Presenter() {
    override fun createModel()=InTreasuryModel()
}