package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       CreateCompanyContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 14:53
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CreateCompanyContract {

    interface View : BaseMvpView

    class Model{}

    abstract class Present : BaseMvpPresenter<Model,View>(){

    }
}