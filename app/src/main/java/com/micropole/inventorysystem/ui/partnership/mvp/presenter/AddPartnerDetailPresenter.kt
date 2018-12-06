package com.micropole.inventorysystem.ui.partnership.mvp.presenter

import com.micropole.inventorysystem.ui.partnership.mvp.contract.AddPartnerContract
import com.micropole.inventorysystem.ui.partnership.mvp.contract.AddPartnerDetailContract
import com.micropole.inventorysystem.ui.partnership.mvp.model.AddpartnerDetailModel
import com.micropole.inventorysystem.ui.partnership.mvp.model.AddpartnerModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class AddPartnerDetailPresenter:AddPartnerDetailContract.Presenter() {
    override fun createModel()=AddpartnerDetailModel()
}