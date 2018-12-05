package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.ui.personal.inventory.mvp.CreateCompanyContract

/**
 * @ClassName       CreateCompanyPresent
 * @Description     创建公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 14:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CreateCompanyPresent : CreateCompanyContract.Present(){

    override fun createModel(): CreateCompanyContract.Model {
        return CreateCompanyContract.Model()
    }
}