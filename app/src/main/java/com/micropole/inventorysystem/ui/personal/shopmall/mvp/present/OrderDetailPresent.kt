package com.micropole.inventorysystem.ui.personal.shopmall.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.OrderDetailContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       OrderDetailPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/12 9:28
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailPresent : OrderDetailContract.Present(){
    override fun confirmOrder(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().confirmOrder(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun orderDetail(id: String) {
        getModel().orderDetail(id).ui({
            getView()?.setData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

}