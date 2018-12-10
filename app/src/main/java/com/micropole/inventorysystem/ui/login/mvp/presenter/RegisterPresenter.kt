package com.micropole.inventorysystem.ui.login.mvp.presenter

import com.blankj.utilcode.util.RegexUtils
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.login.mvp.contract.RegisterContract
import com.micropole.inventorysystem.ui.login.mvp.model.RegisterModel
import com.micropole.inventorysystem.util.md5
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class RegisterPresenter:RegisterContract.Presenter() {
    override fun getCountry() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().getCountry().ui({
            getView()?.dismissLoadingDialog()
            getView()?.getCountry(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun sendSMS(phone: String) {
        getModel().sendSMS(phone).ui({
            getView()?.showToast(it.msg)
        },{
            getView()?.showToast(it)
        })
    }

    override fun register(img: String, name: String, country: String, birthday: String, phone: String, code: String, pwd: String) {
        when {
            img.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_select_img))
            name.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.reg_name))
            birthday.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.reg_xu_bri))
            phone.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.reg_xu_phone))
            country == getView()?.getResString(R.string.reg_xu_contry) -> getView()?.showToast(getView()?.getResString(R.string.reg_xu_contry))
            !RegexUtils.isMobileSimple(phone) -> getView()?.showToast(getView()?.getResString(R.string.reg_sure_xu_phone))
            code.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.reg_tian_code))
            pwd.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_input_pwd))
            else -> {
                getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
                imgUp(img){
                    getModel().register(it,name,country, birthday, phone, code, pwd.md5()).ui({
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
    }

    fun imgUp(img : String,action : (s : String) -> Unit){
        getModel().imgUp(img).ui({
            action.invoke(it.data!!.imgUrl)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel()=RegisterModel()
}