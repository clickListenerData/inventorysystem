package com.micropole.inventorysystem.ui.personal.mvp

import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       PersonalPresenter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 9:24
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalPresenter : PersonalContract.Presenter() {
    override fun userInfo() {
        getModel().userInfo().ui({
            getView()?.setData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): PersonalContract.Model {
        return PersonalContract.Model()
    }
}