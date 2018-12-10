package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.R
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
    override fun getImg(img: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().getImg(img).ui({
            getView()?.getImg(it.data!!)
        },{
            getView()?.showToast(it)

        })
    }

    override fun settringInfo(nickname: String, user_sex: String, user_img: String, user_birthday: String,index:Int) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().settingInfo(nickname, user_sex, user_img, user_birthday).ui({
                    getView()?.showToast(it.msg)
            getView()?.getData(index)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel()=PersonalMsgContract.Model()

}