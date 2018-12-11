package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.inventorysystem.common.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       EditAddressContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 14:38
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EditAddressContract {
    interface View : BaseMvpView

    class Model{
        fun addAddress(name:String,phone:String,address:String,default:Int)
                = AppService.Api!!.addAddress(name, phone, address, default)
        fun editAddress(name:String,phone:String,address:String,default:Int,id:String) =
                AppService.Api!!.editAddress(name, phone, address, default, id)
        fun deleteAddreess(id:String) = AppService.Api!!.deleteAddress(id)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun addAddress(name:String,phone:String,address:String,default:Int)
        abstract fun editAddress(name:String,phone:String,address:String,default:Int,id:String)
        abstract fun deleteAddress(id:String)
    }
}