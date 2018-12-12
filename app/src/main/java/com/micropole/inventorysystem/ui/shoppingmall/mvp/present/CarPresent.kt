package com.micropole.inventorysystem.ui.shoppingmall.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.NewsContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.CarContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CarPresent : CarContract.Presenter() {
    override fun car() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().car().ui({
            getView()?.dismissLoadingDialog()
            getView()?.carSucceeful(it.data!!)

        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel()=CarContract.Model()

}