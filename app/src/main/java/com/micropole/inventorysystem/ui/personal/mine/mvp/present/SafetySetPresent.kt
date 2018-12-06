package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.SafetySetContract

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SafetySetPresent : SafetySetContract.Presenter() {
    override fun createModel(): SafetySetContract.Model {
        return SafetySetContract.Model()
    }


}