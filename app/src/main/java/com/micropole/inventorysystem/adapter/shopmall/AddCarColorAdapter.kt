package com.micropole.inventorysystem.adapter.shopmall

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R

/**
 * author: xiaoguagnfei
 * date: 2018/12/11
 * describe:
 */
class AddCarColorAdapter :BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_addcar_color){
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
    }
}