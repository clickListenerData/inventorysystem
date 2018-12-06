package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import android.os.Handler
import android.os.Message
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.SettingPWContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.SettingPhoneContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SettingPhonePresent : SettingPhoneContract.Presenter() {

    override fun getCode(phone: String) {
        if (phone.isNullOrEmpty()){
            getView()?.showToast("请输入手机号码")
            return
        }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().getCode(phone).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.getCode()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun settingPhone(old_user_phone: String, new_user_phone: String, new_code: String, old_code: String) {
        when{
            old_user_phone.isNullOrEmpty()->getView()?.showToast("请输入旧手机号")
            new_user_phone.isNullOrEmpty()->getView()?.showToast("请输入新手机号")
            old_code.isNullOrEmpty()->getView()?.showToast("请输入旧手机验证码")
            new_code.isNullOrEmpty()->getView()?.showToast("请输入新手机验证码")
            else->{
                getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
                getModel().settPhone(old_user_phone, new_user_phone, new_code, old_code).ui({
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

    override fun createModel(): SettingPhoneContract.Model {
        return SettingPhoneContract.Model()
    }


}