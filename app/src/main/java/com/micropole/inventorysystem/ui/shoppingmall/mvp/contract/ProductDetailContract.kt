package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.inventorysystem.App
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ConfirmOrderBean
import com.micropole.inventorysystem.entity.ProductDetailBean
import com.micropole.inventorysystem.entity.SelectSpecBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

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
        fun confirmBuy(bean : ConfirmOrderBean?)
    }

    class Model{
        fun productDetail(id:String) = AppService.Api!!.productDetail(id)
        fun collectProduct(id: String) = AppService.Api!!.collectProduct(id)
        fun selectSpec(id: String,sp:String,mo:String) = AppService.Api!!.selectProSpec(id, sp, mo)
        fun addCart(id: String,sp: String,mo: String,num:String) = AppService.Api!!.addCar(id,num,sp,mo)
        fun confirmBuy(id: String,reid: String,mo: String,num: String)
                = AppService.Api!!.confirmBuy(id,num,reid, mo)
        fun addFoot(id: String) = AppService.Api!!.addFoot(id)
    }

    abstract class Prenset() : BaseMvpPresenter<Model, View>(){
        abstract fun productDetail(id: String)
        abstract fun collectProduct(id: String)
        abstract fun selectSpec(id: String,sp:String,mo:String)
        abstract fun addCart(id: String,sp: String,mo: String,num:String)
        abstract fun confirmBuy(id: String,sp: String,mo: String,num: String)
        abstract fun addFoot(id: String)
    }
}