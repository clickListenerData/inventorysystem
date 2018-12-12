package com.micropole.inventorysystem.ui.shoppingmall.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CarBean
import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.entity.UpdateCar
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       NewsContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:42
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CarContract {

    interface View : BaseMvpView{
        fun carSucceeful(cars:CarBean)
        fun deleteSucceeful(msg:String,position:Int)
        fun  updateCar(updateCar: UpdateCar,position:Int,isAdd:Boolean)

    }

    class Model {
        fun car()=AppService.Api!!.car()
        fun deleteCar(sh_id:String)=AppService.Api!!.deleteCar(sh_id)
        fun updateCar(sh_id:String,pro_num:String)=AppService.Api!!.updateCar(sh_id,pro_num,"")
    }

    abstract class Presenter : BaseMvpPresenter<Model, View>(){

       abstract fun car()
        abstract fun deleteCar(sh_id:String,position:Int)
        abstract fun updateCar(sh_id:String,pro_num:String,position:Int,isAdd:Boolean)

    }
}