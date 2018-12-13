package com.micropole.inventorysystem.ui.personal.shopmall.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.OrderListContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       OrderListPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 9:11
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListPresent : OrderListContract.Present() {
    override fun orderList(stat: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().orderList(stat).ui({
            getView()?.dismissLoadingDialog()
            getView()?.orderList(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

}