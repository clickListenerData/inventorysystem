package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.NewsContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.PersonalMsgContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalMsgPresent : PersonalMsgContract.Presenter() {
    override fun settringInfo(nickname: String, user_sex: String, user_img: String, user_birthday: String) {
        getModel().settingInfo(nickname, user_sex, user_img, user_birthday).ui({

        },{
        })
    }

    override fun createModel()=PersonalMsgContract.Model()

}