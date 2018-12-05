package com.micropole.inventorysystem.ui.login.mvp.presenter

import com.micropole.baseapplibrary.appconst.Constants
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.micropole.inventorysystem.ui.login.mvp.model.LoginModel
import com.micropole.inventorysystem.util.md5
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class LoginPresenter:LoginContract.Presenter() {
    override fun login(phone: String, pwd: String) {
        if (phone.isEmpty()){
            getView()?.showToast(getView()?.getResString(R.string.dialog_input_phone))
            return
        }
        if (pwd.isEmpty()){
            getView()?.showToast(getView()?.getResString(R.string.dialog_input_pwd))
            return
        }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading_login))
        getModel().login(phone, pwd.md5()).ui({
            Constants.putLongToken(it.data!!.long_token)
            Constants.putShortToken(it.data!!.short_token)
            Constants.login()
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel()=LoginModel()
}