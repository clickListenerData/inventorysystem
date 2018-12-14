package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ApplyAfterContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       ApplyAfterPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/14 9:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ApplyAfterPresent : ApplyAfterContract.Present(){
    override fun applyAfter(oid: String, type: String, pro_id: String, reason: String, remark: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().applyAfter(oid, type, pro_id, reason, remark).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

}