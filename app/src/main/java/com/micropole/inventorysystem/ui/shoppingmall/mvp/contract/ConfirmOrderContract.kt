package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ConfirmOrderBean
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

    interface View : BaseMvpView{
//        fun addCartSuccess(num: String)
        fun setUIData(bean : ConfirmOrderBean?)
        fun addError()
        fun buyOrder()
    }

    class Model{
        fun confirmBuy(cartId:String,num: String,re_id:String,proInfo:String)
                = AppService.Api!!.confirmBuy(cartId,num,re_id,proInfo)
        fun buyOrder(cartId:String,num: String,re_id:String,proInfo:String,remark:String)
                = AppService.Api!!.buyOrder(cartId,num,re_id,proInfo,remark)
    }

    abstract class Presenter : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model = Model()
        abstract fun confirmBuy(cartId:String,num: String,re_id:String,proInfo:String)
        abstract fun buyOrder(cartId:String,num: String,re_id:String,proInfo:String,remark:String)
    }
}