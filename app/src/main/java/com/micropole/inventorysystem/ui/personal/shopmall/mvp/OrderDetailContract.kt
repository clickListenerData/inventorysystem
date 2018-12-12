package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.OrderDetailBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       OrderDetailContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/12 9:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailContract {

    interface View : BaseMvpLcecView<OrderDetailBean?>

    class Model{
        fun orderDetail(id:String) = AppService.Api!!.orderDetail(id)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun orderDetail(id: String)
    }
}