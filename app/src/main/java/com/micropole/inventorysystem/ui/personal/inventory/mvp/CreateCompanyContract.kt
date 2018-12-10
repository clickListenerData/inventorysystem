package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       CreateCompanyContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 14:53
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CreateCompanyContract {

    interface View : BaseMvpView{
        fun editSuccess(name:String,email:String,contact:String,img:String,address:String,industry:String,country:String,notice:String)
        fun getImg() : String
        fun getCountry(data : List<String>)
    }

    class Model{
        fun addCompany(name:String,email:String,contact:String,img:String,address:String,industry:String,country:String,notice:String) =
                AppService.Api!!.addCompany(email,address,img,contact,name,industry,country,notice)
        fun imgUp(img: String) = AppService.Api!!.imgUp(img)
        fun editCompany(name:String,email:String,contact:String,img:String,address:String,industry:String,country:String,notice:String) =
                AppService.Api!!.editCompany(email,address,img,contact,name,industry,country,notice)
        fun getCountry() = AppService.Api!!.getCountry()
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun addCompany(name:String,email:String,contact:String,img:String,address:String,industry:String,country:String,notice:String)
        abstract fun editCompany(name:String,email:String,contact:String,img:String,address:String,industry:String,country:String,notice:String)
        abstract fun getCountry()
    }
}