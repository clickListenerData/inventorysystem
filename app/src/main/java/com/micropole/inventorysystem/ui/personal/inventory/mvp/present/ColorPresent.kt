package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.ColorConstract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       CategoryPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ColorPresent : ColorConstract.Present(){

    override fun deleteColor(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().deleteColor(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.deleteSuccess()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun getColorList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().colorList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.getData(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ColorConstract.Model {
        return ColorConstract.Model()
    }


}