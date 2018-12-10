package com.micropole.inventorysystem.ui.partnership.mvp.presenter

import com.micropole.inventorysystem.ui.partnership.mvp.contract.PartnerShipContract
import com.micropole.inventorysystem.ui.partnership.mvp.model.PartnerShipModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class PartnerShipPresenter:PartnerShipContract.Presenter() {
    override fun createModel()=PartnerShipModel()
}