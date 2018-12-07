package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MineCompanyContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       MineCompanyPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/7 16:53
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCompanyPresent : MineCompanyContract.Present(){
    override fun isAgreeCompany(id: String, stat: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().isAgreeCompany(id, stat).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun companyMsg() {
        getModel().companyMsg().ui({
            getView()?.setData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MineCompanyContract.Model {
        return MineCompanyContract.Model()
    }
}