package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.AddressBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       AddressManagerContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 9:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddressManagerContract {

    interface View : BaseMvpView{
        fun addressList(data : List<AddressBean>)
    }

    class Model{
        fun addressList() = AppService.Api!!.addressList()
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun addressList()
    }
}