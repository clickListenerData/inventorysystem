package com.micropole.inventorysystem.ui.shoppingmall.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ProductDetailBean
import com.xx.baseuilibrary.mvp.BaseMvpView
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
    }

    class Model{
        fun productDetail(id:String) = AppService.Api!!.productDetail(id)
    }

    abstract class Prenset() : BaseMvpPresenter<Model,View>(){
        abstract fun productDetail(id: String)
    }
}