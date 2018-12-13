package com.micropole.inventorysystem.ui.personal.shopmall.mvp

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.CollectBean
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       MineCollectContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/11 16:59
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCollectContract {

    interface View : BaseRvConstract.View{
        fun setData(data : List<CollectBean>)
        fun deleteSuccess()
    }

    class Model{
        fun collectList() = AppService.Api!!.collectList()
        fun footList() = AppService.Api!!.footList()
        fun deletePro(type : Int,id:String) : Observable<BaseResponseEntity<List<String>>> {
            return if (type == 0){
                AppService.Api!!.deleteCollect(id)
            }else{
                AppService.Api!!.deletefoot(id)
            }
        }
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        override fun createModel(): Model {
            return Model()
        }
        abstract fun collectList()
        abstract fun footList()
        abstract fun deletePro(type: Int,id: String)
    }
}