package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.OrderListBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       OrderListContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 9:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListContract {

    interface View : BaseMvpView{
        fun orderList(data : List<OrderListBean>?)
    }

    class Model{
        fun orderList(stat : Int) = AppService.Api!!.orderList(stat)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun orderList(stat: Int)
    }
}