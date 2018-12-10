package com.micropole.inventorysystem.ui.personal.mine.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.NewsBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       NewsContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:42
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FeedBackContract {

    interface View : BaseMvpView{
    }

    class Model {
        fun feedback(content:String)=AppService.Api!!.feedback(content)
    }

    abstract class Presenter : BaseMvpPresenter<Model, View>(){
        abstract fun feedback(content:String)
    }
}