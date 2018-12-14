package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.common.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       ApplyAfterContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/14 9:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ApplyAfterContract {

    class Model{
        fun applyAfter(oid:String,type:String,pro_id:String,reason:String,remark:String)
                = AppService.Api!!.applyAfter(oid,type,pro_id,reason,remark)
    }

    abstract class Present : BaseMvpPresenter<Model,BaseMvpView>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun applyAfter(oid:String,type:String,pro_id:String,reason:String,remark:String)
    }
}