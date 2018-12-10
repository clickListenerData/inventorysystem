package com.micropole.inventorysystem.ui.personal.mine.mvp.contract

import com.micropole.baseapplibrary.recyclerview.mvp.BaseRvConstract
import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.ImgUpBean
import com.micropole.inventorysystem.entity.NewsBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       NewsContract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:42
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalMsgContract {

    interface View : BaseMvpView{
        fun getData(index: Int)
        fun getImg(img: ImgUpBean)

    }

    class Model {
        fun settingInfo(nickname:String,user_sex:String,user_img:String,user_birthday:String)=AppService.Api!!.settingInfo(nickname,user_sex,user_img,user_birthday)
        fun getImg(img:String)=AppService.Api!!.imgUp(img)
    }

    abstract class Presenter : BaseMvpPresenter<Model, View>(){
        abstract  fun settringInfo(nickname:String,user_sex:String,user_img:String,user_birthday:String,index:Int)
        abstract  fun getImg(img:String)
    }
}