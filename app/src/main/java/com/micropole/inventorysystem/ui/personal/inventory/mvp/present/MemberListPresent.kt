package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MemberListContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       MemberListPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/6 17:11
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberListPresent : MemberListContract.Present() {
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

    override fun createModel(): MemberListContract.Model {
        return MemberListContract.Model()
    }
}