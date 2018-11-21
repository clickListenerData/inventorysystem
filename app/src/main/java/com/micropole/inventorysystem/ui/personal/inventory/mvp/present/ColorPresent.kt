package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.ColorConstract

/**
 * @ClassName       CategoryPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ColorPresent : ColorConstract.Present(){
    override fun getColorList() {
        getView()?.getData(arrayListOf(ColorBean(),ColorBean()))
    }

    override fun createModel(): ColorConstract.Model {
        return ColorConstract.Model()
    }


}