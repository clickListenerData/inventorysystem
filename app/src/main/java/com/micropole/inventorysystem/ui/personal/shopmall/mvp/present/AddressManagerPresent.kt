package com.micropole.inventorysystem.ui.personal.shopmall.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.AddressManagerContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       AddressManagerPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 9:12
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddressManagerPresent : AddressManagerContract.Present() {
    override fun addressList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().addressList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.addressList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }
}