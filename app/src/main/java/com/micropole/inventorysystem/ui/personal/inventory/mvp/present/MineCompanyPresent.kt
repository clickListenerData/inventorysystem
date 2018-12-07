package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.ui.personal.inventory.mvp.MineCompanyContract

/**
 * @ClassName       MineCompanyPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/7 16:53
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCompanyPresent : MineCompanyContract.Present(){

    override fun createModel(): MineCompanyContract.Model {
        return MineCompanyContract.Model()
    }
}