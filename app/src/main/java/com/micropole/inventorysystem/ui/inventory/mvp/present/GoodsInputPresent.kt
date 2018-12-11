package com.micropole.inventorysystem.ui.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.mvp.GoodsInputContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       GoodsInputPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 11:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GoodsInputPresent : GoodsInputContract.Present(){
    override fun categoryList() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().categoryList().ui({
            getView()?.categoryList(it.data!!)
            goodsList("0",1)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun goodsList(id: String, sort: Int) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().goodsList(id,sort).ui({
            getView()?.dismissLoadingDialog()
            getView()?.goodsList(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

}