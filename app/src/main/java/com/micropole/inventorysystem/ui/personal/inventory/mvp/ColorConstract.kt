package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.ColorBean
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       CategoryConstract
 * @Description     分类
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ColorConstract {

    interface View : BaseRvConstract.View{
        fun getData(data : ColorBean)
        fun deleteSuccess()
    }

    class Model{
        fun colorList() = AppService.Api!!.colorList()
        fun deleteColor(id : String) = AppService.Api!!.deleteColor(id)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getColorList()
        abstract fun deleteColor(id: String)
    }
}