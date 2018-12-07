package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.blankj.utilcode.util.RegexUtils
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.AddMemberContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       AddMemberPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/6 17:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddMemberPresent : AddMemberContract.Present(){
    override fun memberList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().memberList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.memberList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun searchMember(phone: String) {
        when{
            phone.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_input_phone))
            !RegexUtils.isMobileSimple(phone) -> getView()?.showToast(getView()?.getResString(R.string.reg_sure_xu_phone))
            else -> {
                getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
                getModel().searchMember(phone).ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.getMember(it.data!!)},{
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it)
                })
            }
        }
    }

    override fun createModel(): AddMemberContract.Model {
        return AddMemberContract.Model()
    }
}