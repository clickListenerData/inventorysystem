package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import android.os.Build.VERSION_CODES.P
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       CategoryPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CategoryPresent : CategoryConstract.Present(){
    override fun getCategoryList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().getCategoryList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.getData(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun addCategory(name: String) {
        if (name.isEmpty()){
            getView()?.showToast(getView()?.getResString(R.string.input_category_hint))
        }else{
            getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
            getModel().addCategory(name).ui({
                getView()?.showToast(it.msg)
                getView()?.addSuccess(name)
            },{
                getView()?.dismissLoadingDialog()
                getView()?.showToast(it)
            })
        }
    }

    override fun editCategory(id: String, name: String) {
        if (name.isEmpty()){
            getView()?.showToast(getView()?.getResString(R.string.input_category_hint))
            return
        }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().editCategory(id,name).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.editSuccess(id,name)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun deleteCategory(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().deleteCategory(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.deleteSuccess()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): CategoryConstract.Model {
        return CategoryConstract.Model()
    }


}