package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.AddColorContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       AddColorPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 11:21
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddColorPresent : AddColorContract.Presente() {

    override fun addcolor(name: String, color: String) {
        if (name.isEmpty()){
            getView()?.showToast(getView()?.getResString(R.string.color_name_hint))
            return
        }else if (color.isEmpty() || ( color.length != 4 && color.length != 7 && color.length != 9)){
            getView()?.showToast(getView()?.getResString(R.string.check_sure_color_id))
            return
        }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().addColor(name, color).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): AddColorContract.Model {
        return AddColorContract.Model()
    }
}