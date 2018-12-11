package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CollectBean
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       MineCollectContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 16:59
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCollectContract {

    interface View : BaseRvConstract.View{
        fun setData(data : List<CollectBean>)
    }

    class Model{
        fun collectList() = AppService.Api!!.collectList()
        fun footList() = AppService.Api!!.footList()
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun collectList()
        abstract fun footList()
    }
}