package com.micropole.inventorysystem.ui.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.GoodsDetailBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       AddInputContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 14:06
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddInputContract {
    interface View : BaseMvpView{
        fun goodsDetail(bean : GoodsDetailBean?)
    }

    class Model{
        fun goodsDetail(id:String) = AppService.Api!!.goodsDetail(id)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun goodsDetail(id: String)
    }
}