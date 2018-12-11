package com.micropole.inventorysystem.ui.personal.shopmall.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.string.name
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.EditAddressContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       EditAddressPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 14:45
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EditAddressPresent : EditAddressContract.Present() {
    override fun editAddress(name: String, phone: String, address: String, default: Int, id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().editAddress(name, phone, address, default, id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun deleteAddress(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().deleteAddreess(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun addAddress(name: String, phone: String, address: String, default: Int) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().addAddress(name,phone, address, default).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }
}