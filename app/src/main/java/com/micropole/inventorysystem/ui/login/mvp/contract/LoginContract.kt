package com.micropole.inventorysystem.ui.login.mvp.contract

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class LoginContract {
    interface View:BaseMvpView{

    }
    interface Model{

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){

    }

}