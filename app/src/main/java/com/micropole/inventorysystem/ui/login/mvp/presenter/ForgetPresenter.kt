package com.micropole.inventorysystem.ui.login.mvp.presenter

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel
import com.micropole.inventorysystem.ui.login.mvp.contract.FotgetContract
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.micropole.inventorysystem.ui.login.mvp.model.ForgetModel
import com.micropole.inventorysystem.ui.login.mvp.model.LoginModel
import com.micropole.inventorysystem.util.md5
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ForgetPresenter:FotgetContract.Presenter() {
    override fun sendSMS(phone: String) {
        getModel().sendSMS(phone).ui({
            getView()?.showToast(it.msg)
        },{
            getView()?.showToast(it)
        })
    }

    override fun forgetPwd(phone: String, code: String, pwd: String) {
        when{
            phone.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_input_phone))
            code.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.reg_tian_code))
            pwd.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_input_pwd))
            else -> {
                getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
                getModel().forgetPwd(phone, code, pwd.md5()).ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it.msg)
                    getView()?.finishActivity()
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it)
                })
            }
        }
    }

    override fun createModel()=ForgetModel()
}