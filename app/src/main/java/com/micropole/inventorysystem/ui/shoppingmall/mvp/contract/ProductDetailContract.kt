package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.App
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ProductDetailBean
import com.micropole.inventorysystem.entity.SelectSpecBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       ProductDetailContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/10 11:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ProductDetailContract {

    interface View : BaseMvpLcecView<ProductDetailBean?>{
        fun specResult(bean : SelectSpecBean?)
    }

    class Model{
        fun productDetail(id:String) = AppService.Api!!.productDetail(id)
        fun collectProduct(id: String) = AppService.Api!!.collectProduct(id)
        fun selectSpec(id: String,sp:String,mo:String) = AppService.Api!!.selectProSpec(id, sp, mo)
        fun addCart(id: String,sp: String,mo: String,num:String) = AppService.Api!!.addCar(id,num,sp,mo)
    }

    abstract class Prenset() : BaseMvpPresenter<Model, View>(){
        abstract fun productDetail(id: String)
        abstract fun collectProduct(id: String)
        abstract fun selectSpec(id: String,sp:String,mo:String)
        abstract fun addCart(id: String,sp: String,mo: String,num:String)
    }
}