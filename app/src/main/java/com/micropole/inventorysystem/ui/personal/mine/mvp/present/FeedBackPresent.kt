package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.FeedBackContract
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
class FeedBackPresent : FeedBackContract.Presenter() {
    override fun feedback(content: String) {
        if (content.isNullOrEmpty()){
            getView()?.showToast("请输入内容")
            return
        }
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().feedback(content).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun createModel(): FeedBackContract.Model {
        return FeedBackContract.Model()
    }

}