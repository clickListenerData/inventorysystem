package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MemberDetailContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       MemberDetailPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/7 10:45
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberDetailPresent : MemberDetailContract.Present() {
    override fun addMember(phone: String?, country: String?, birthday: String?, remark: String?, role: String?, userId: String?,email:String?) {
        when{
            role.isNullOrEmpty() -> getView()?.showToast(getView()?.getResString(R.string.select_position))
            else -> {
                getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
                getModel().addMember(phone, country, birthday, remark, role, userId,email).ui({
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

    override fun removeMember(userId: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().removeMember(userId).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun getMember(userId: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().getMember(userId).ui({
            getView()?.dismissLoadingDialog()
            getView()?.setData(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MemberDetailContract.Model = MemberDetailContract.Model()
}