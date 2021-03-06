package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CommentsBean
import com.micropole.inventorysystem.entity.EvaluationListBean
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       EvalationListContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/13 17:17
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvalationListContract {

    interface View : BaseRvConstract.View{
        fun evaluationList(bean : List<CommentsBean>)
    }

    class Model{
        fun evalutionList(id:String,page : Int) = AppService.Api!!.evaluationList(id, page)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun evalutionList(id:String,page : Int)
    }
}