package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.AboutAsContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.NewsContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AboutAsPresent : AboutAsContract.Presenter() {
    override fun aboutas() {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().aboutas().ui({
            getView()?.dismissLoadingDialog()
            getView()?.aboutAs(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): AboutAsContract.Model {
        return AboutAsContract.Model()
    }

}