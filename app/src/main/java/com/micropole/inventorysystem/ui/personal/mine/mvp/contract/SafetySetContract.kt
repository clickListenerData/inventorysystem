package com.micropole.inventorysystem.ui.personal.mine.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.entity.NewsBean
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       NewsContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:42
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SafetySetContract {

    interface View : BaseRvConstract.View{
    }

    class Model {}

    abstract class Presenter : BaseMvpPresenter<Model, View>(){
    }
}