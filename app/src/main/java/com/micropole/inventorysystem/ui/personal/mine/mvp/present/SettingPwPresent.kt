package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.SettingPWContract
import com.micropole.inventorysystem.util.md5
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SettingPwPresent : SettingPWContract.Presenter() {
    override fun settingPW(old_user_pwd: String, new_user_pwd: String, comfirm_user_pwd: String) {
            if (!new_user_pwd.equals(comfirm_user_pwd)){
                getView()?.showToast("请输入相同密码")
                return
            }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().settingPW(old_user_pwd.md5(), new_user_pwd.md5(), comfirm_user_pwd.md5()).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()

        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): SettingPWContract.Model {
        return SettingPWContract.Model()
    }


}