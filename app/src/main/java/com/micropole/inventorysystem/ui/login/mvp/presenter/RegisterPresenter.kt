package com.micropole.inventorysystem.ui.login.mvp.presenter

import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.micropole.inventorysystem.ui.login.mvp.contract.RegisterContract
import com.micropole.inventorysystem.ui.login.mvp.model.LoginModel
import com.micropole.inventorysystem.ui.login.mvp.model.RegisterModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class RegisterPresenter:RegisterContract.Presenter() {
    override fun createModel()=RegisterModel()
}