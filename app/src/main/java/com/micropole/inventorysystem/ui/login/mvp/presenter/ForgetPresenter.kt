package com.micropole.inventorysystem.ui.login.mvp.presenter

import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.model.InTreasuryModel
import com.micropole.inventorysystem.ui.login.mvp.contract.FotgetContract
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.micropole.inventorysystem.ui.login.mvp.model.ForgetModel
import com.micropole.inventorysystem.ui.login.mvp.model.LoginModel

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class ForgetPresenter:FotgetContract.Presenter() {
    override fun createModel()=ForgetModel()
}