package com.micropole.inventorysystem.adapter.home

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R

/**
 * author: xiaoguagnfei
 * date: 2018/11/22
 * describe:
 */
class InTreasuryDetailAdapter():BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_intreasurydetail) {

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {


    }
}