package com.micropole.inventorysystem.ui.home.mvp.contract

import com.micropole.inventorysystem.entity.TreasuryBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class InTreasuryContract {
    interface View:BaseMvpView{
        fun treasuryList(bean : TreasuryBean?)
    }
    interface Model{
        fun treasuryList(type:Int,page:Int,deac : Int,companyId : String) : Observable<BaseResponseEntity<TreasuryBean>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun treasuryList(type: Int,page: Int)
    }

}