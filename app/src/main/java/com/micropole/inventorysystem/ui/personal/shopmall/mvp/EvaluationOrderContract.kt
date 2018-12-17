package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CommentsBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       EvaluationOrderContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/13 17:22
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationOrderContract {

    interface View : BaseMvpView{
        fun imgUP(s : String)
    }

    class Model{
        fun evaluationOrder(id:String,data:String) = AppService.Api!!.evaluationOrder(id, data)
        fun imgUp(img:String) = AppService.Api!!.imgUp(img)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun evaluationOrder(id:String,list:ArrayList<CommentsBean>)
        abstract fun imgSup(img:String)
    }
}