package com.micropole.inventorysystem.ui.partnership.mvp.presenter

import com.micropole.inventorysystem.ui.partnership.mvp.contract.PartnerDetailContract
import com.micropole.inventorysystem.ui.partnership.mvp.model.PartnerDetailModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class PartnerDetailPresenter: PartnerDetailContract.Presenter() {
    override fun createModel()= PartnerDetailModel()
}