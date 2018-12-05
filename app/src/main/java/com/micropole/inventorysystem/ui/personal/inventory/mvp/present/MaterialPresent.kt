package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.blankj.utilcode.util.SnackbarUtils.getView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.string.name
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.entity.MaterialBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.ColorConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MaterialConstract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       CategoryPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MaterialPresent : MaterialConstract.Present(){
    override fun addMaterial(name: String) {
        if (name.isEmpty()){
            getView()?.showToast(getView()?.getResString(R.string.new_create_material_hint))
            return
        }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().addMaterial(name).ui({
            getView()?.showToast(it.msg)
            getMaterialList()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun deleteMaterial(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().deleteMaterial(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.deleteSuccess()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun getMaterialList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().materialList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.getData(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MaterialConstract.Model {
        return MaterialConstract.Model()
    }


}