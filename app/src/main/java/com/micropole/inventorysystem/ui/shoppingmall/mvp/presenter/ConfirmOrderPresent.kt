package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ConfirmOrderContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       ConfirmOrderPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/13 10:11
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ConfirmOrderPresent : ConfirmOrderContract.Presenter() {
    override fun buyOrder(cartId: String, num: String, re_id: String, proInfo: String, remark: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().buyOrder(cartId, num, re_id, proInfo, remark).ui({
            getView()?.dismissLoadingDialog()
            getView()?.buyOrder()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun confirmBuy(cartId: String, num: String, re_id: String, proInfo: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().confirmBuy(cartId, num, re_id, proInfo).ui({
            getView()?.dismissLoadingDialog()
            getView()?.setUIData(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
            getView()?.addError()
        })
    }
}