package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract

/**
 * @ClassName       CategoryPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CategoryPresent : CategoryConstract.Present(){
    override fun getCategoryList() {
        getView()?.getData(arrayListOf(CategoryBean(),CategoryBean()))
    }

    override fun createModel(): CategoryConstract.Model {
        return CategoryConstract.Model()
    }


}