package com.micropole.inventorysystem.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.TreasuryBean

/**
 * author: xiaoguagnfei
 * date: 2018/11/22
 * describe:
 */
class InTreasuryTwoAdapter:BaseQuickAdapter<TreasuryBean.OrderDataBean,BaseViewHolder>(R.layout.item_inttreasury_date_two) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: TreasuryBean.OrderDataBean?) {

    }
}