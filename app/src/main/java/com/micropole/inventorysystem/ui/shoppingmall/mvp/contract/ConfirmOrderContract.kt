package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       ConfirmOrderContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/13 10:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ConfirmOrderContract {

    interface View : BaseMvpView

    class Model{

    }

    abstract class Presenter : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model = Model()
    }
}