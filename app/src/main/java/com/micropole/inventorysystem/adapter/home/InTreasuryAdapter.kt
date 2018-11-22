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
class InTreasuryAdapter(context:Context):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_inttreasury) {
    private lateinit var context:Context
    init {
        this.context=context
    }
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
        var recyclerView=helper?.getView<RecyclerView>(R.id.recyclerView)
        var adapter=InTreasuryTwoAdapter()
        recyclerView!!.layoutManager=LinearLayoutManager(context)
        recyclerView!!.adapter=adapter
        recyclerView.isNestedScrollingEnabled=false
        adapter.setNewData(arrayListOf("",""))

    }
}