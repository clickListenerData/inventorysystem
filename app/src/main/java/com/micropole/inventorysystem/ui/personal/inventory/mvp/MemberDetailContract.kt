package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.SearchMemberBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       MemberDetailContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/7 10:39
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberDetailContract {

    interface View : BaseMvpLcecView<SearchMemberBean?>{
    }

    class Model{
        fun getMember(userId : String) = AppService.Api!!.searchMember(id = userId)
        fun addMember(phone:String?,country : String?,birthday : String?,remark : String?,role : String?,userId: String?,email:String?) =
                AppService.Api!!.addMember(phone, country, birthday, remark, role, userId,email)
        fun removeMember(userId: String) = AppService.Api!!.removeMember(userId)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getMember(userId: String)
        abstract fun addMember(phone:String?,country : String?,birthday : String?,remark : String?,role : String?,userId: String?,email:String?)
        abstract fun removeMember(userId: String)
    }
}