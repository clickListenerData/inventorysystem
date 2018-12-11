package com.micropole.inventorysystem.ui.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.InventoryGoodsBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       GoodsInputContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 11:02
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GoodsInputContract {
    interface View : BaseMvpView{
        fun categoryList(bean : CategoryBean)
        fun goodsList(data : InventoryGoodsBean)
    }

    class Model{
        fun categoryList() = AppService.Api!!.categoryList()
        fun goodsList(id:String,sort:Int) = AppService.Api!!.goodsList(id,sort)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun categoryList()
        abstract fun goodsList(id:String,sort:Int)

        override fun createModel(): Model {
            return Model()
        }
    }
}