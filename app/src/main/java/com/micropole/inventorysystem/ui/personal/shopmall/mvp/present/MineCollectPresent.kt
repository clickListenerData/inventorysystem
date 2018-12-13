package com.micropole.inventorysystem.ui.personal.shopmall.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.MineCollectContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       MineCollectPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 17:01
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCollectPresent : MineCollectContract.Present() {
    override fun deletePro(type: Int, id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().deletePro(type, id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.deleteSuccess()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun collectList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().collectList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.setData(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun footList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().footList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.setData(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }
}