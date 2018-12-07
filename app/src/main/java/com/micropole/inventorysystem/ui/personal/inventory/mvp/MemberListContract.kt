package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.MemberListBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       MemberListContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/6 16:43
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberListContract {

    interface View : BaseMvpView{
        fun memberList(data : List<MemberListBean>)
    }

    class Model{
        fun memberList() = AppService.Api!!.memberList()
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun memberList()
    }
}