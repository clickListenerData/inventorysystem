package com.micropole.inventorysystem.ui.inventory.mvp.present

import com.blankj.utilcode.util.DeviceUtils.getModel
import com.blankj.utilcode.util.SnackbarUtils.getView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.mvp.SelectContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       SelectPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 16:26
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectPresent : SelectContract.Present(){
    override fun positionList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().positionList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.positionList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun colorList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().colorList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.colorList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun materialList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().materialList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.materialList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun addMaterial(name: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().addMaterial(name).ui({
            materialList()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun specList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().specList().ui({
            getView()?.dismissLoadingDialog()
            getView()?.specList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun addSpec(name: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().addSpec(name).ui({
            specList()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): SelectContract.Model {
        return SelectContract.Model()
    }
}