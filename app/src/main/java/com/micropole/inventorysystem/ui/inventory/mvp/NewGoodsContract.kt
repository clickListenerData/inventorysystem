package com.micropole.inventorysystem.ui.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       NewGoodsContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/6 9:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewGoodsContract {

    interface View : BaseMvpView{}

    class Model{
        fun newGoods(name:String,categoryId:String,huohao:String,cost_price:String,retial_price:String,remark:String,
                     colorId:String,specId:String,material:String,img:String,pack:String) =
                AppService.Api!!.addGoods(categoryId,huohao,cost_price,retial_price,remark,colorId,specId,material,img,pack)
        fun imgUp(img: String) = AppService.Api!!.imgUp(img)
    }

    abstract class Present : BaseMvpPresenter<Model, View>(){
        abstract fun newGoods(name:String,categoryId:String,huohao:String,cost_price:String,retial_price:String,remark:String,
                              colorId:String,specId:String,material:String,img:String,pack: String)
    }
}