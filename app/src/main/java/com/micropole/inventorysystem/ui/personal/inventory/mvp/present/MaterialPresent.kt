package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.blankj.utilcode.util.SnackbarUtils.getView
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.entity.MaterialBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.ColorConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MaterialConstract

/**
 * @ClassName       CategoryPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MaterialPresent : MaterialConstract.Present(){
    override fun getMaterialList() {
        getView()?.getData(arrayListOf(MaterialBean(),MaterialBean()))
    }

    override fun createModel(): MaterialConstract.Model {
        return MaterialConstract.Model()
    }


}