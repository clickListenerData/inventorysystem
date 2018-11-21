package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
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
        fun getData(data : List<ColorBean>)
    }

    class Model{}

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getColorList()
    }
}