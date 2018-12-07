package com.micropole.inventorysystem.ui.personal.inventory.mvp

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.UserInfoBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       MineCompanyContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/7 16:51
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCompanyContract {

    interface View : BaseMvpLcecView<UserInfoBean?>

    class Model{
        fun companyMsg() = AppService.Api!!.companyMsg()
        fun isAgreeCompany(id:String,stat:String) = AppService.Api!!.isagreeCompany(id,stat)
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun companyMsg()
        abstract fun isAgreeCompany(id:String,stat:String)
    }
}