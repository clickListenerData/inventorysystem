package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CategoryBean
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import io.reactivex.Observable

/**
 * @ClassName       CategoryConstract
 * @Description     分类
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CategoryConstract {

    interface View : BaseRvConstract.View{
        fun getData(data : CategoryBean)
        fun addSuccess(name: String)
        fun editSuccess(id: String,name: String)
        fun deleteSuccess()
    }

    class Model{
        fun getCategoryList() = AppService.Api!!.categoryList()
        fun addCategory(name:String) = AppService.Api!!.addCategory(name)
        fun editCategory(id : String,name: String) = AppService.Api!!.editCategory(id, name)
        fun deleteCategory(id : String) = AppService.Api!!.deleteCategory(id)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getCategoryList()
        abstract fun editCategory(id: String,name: String)
        abstract fun addCategory(name: String)
        abstract fun deleteCategory(id: String)
    }
}