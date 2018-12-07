package com.micropole.inventorysystem.ui.inventory.mvp

import com.micropole.baseapplibrary.appconst.AppApi
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.entity.MaterialBean
import com.micropole.inventorysystem.entity.PositionBean
import com.micropole.inventorysystem.entity.SpecBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       SelectContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 16:25
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectContract {

    interface View : BaseMvpView{
        fun colorList(bean : ColorBean)
        fun materialList(bean : MaterialBean)
        fun specList(bean : SpecBean)
        fun positionList(data : List<PositionBean>)
    }

    class Model{
        fun colorList() = AppService.Api!!.colorList()
        fun materialList() = AppService.Api!!.materialList()
        fun addMaterial(name:String) = AppService.Api!!.addMaterial(name)
        fun specList() = AppService.Api!!.sizeList()
        fun addSpec(name: String) = AppService.Api!!.addSize(name)
        fun positionList() = AppService.Api!!.getConfigMsg(1)

    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun colorList()
        abstract fun materialList()
        abstract fun addMaterial(name: String)
        abstract fun specList()
        abstract fun addSpec(name: String)
        abstract fun positionList()
    }
}