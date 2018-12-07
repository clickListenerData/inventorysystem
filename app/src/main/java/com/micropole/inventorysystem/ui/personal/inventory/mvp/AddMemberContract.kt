package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.InvitationBean
import com.micropole.inventorysystem.entity.MemberListBean
import com.micropole.inventorysystem.entity.SearchMemberBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       AddMemberContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/6 17:43
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddMemberContract {

    interface View : BaseMvpView{
        fun getMember(bean : SearchMemberBean)
        fun memberList(data : InvitationBean)
    }

    class Model{
        fun searchMember(phone:String) = AppService.Api!!.searchMember(phone = phone)
        fun memberList() = AppService.Api!!.invitationMember()
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun searchMember(phone: String)
        abstract fun memberList()
    }
}