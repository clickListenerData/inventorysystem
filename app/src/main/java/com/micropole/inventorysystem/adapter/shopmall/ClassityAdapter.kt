package com.micropole.inventorysystem.adapter.shopmall

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ClassityBean
import com.micropole.inventorysystem.widght.NormalLlView

/**
 * author: xiaoguagnfei
 * date: 2018/12/13
 * describe:
 */
class ClassityAdapter:BaseQuickAdapter<ClassityBean, BaseViewHolder>(R.layout.item_category_view){
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: ClassityBean?) {
        helper?.getView<NormalLlView>(R.id.nl_name)!!.setMainTitle(item?.area_name!!)
    }
}