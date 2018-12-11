package com.micropole.inventorysystem.ui.inventory.mvp.present

import android.os.Build.VERSION_CODES.P
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.mvp.AddInputContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       AddInputPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 14:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddInputPresent : AddInputContract.Present(){
    override fun goodsDetail(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().goodsDetail(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.goodsDetail(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }
}