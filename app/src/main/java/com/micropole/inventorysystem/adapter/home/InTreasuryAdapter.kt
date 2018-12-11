package com.micropole.inventorysystem.adapter.home

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.coorchice.library.SuperTextView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.TreasuryBean

/**
 * author: xiaoguagnfei
 * date: 2018/11/22
 * describe: 1 : 进销存明细
 */
class InTreasuryAdapter(val type : Int = 1):BaseQuickAdapter<TreasuryBean.OrderDataBean,BaseViewHolder>(R.layout.item_inttreasury_date) {

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: TreasuryBean.OrderDataBean?) {
        /*val view = helper?.getView<SuperTextView>(R.id.tv_guaqi)

        if (type == 2){
            view?.solid = Color.TRANSPARENT
            view?.corner = 0f
            view?.setTextColor(Color.parseColor("#007AFF"))
            view?.textSize = 15f
        }
        
        var recyclerView=helper?.getView<RecyclerView>(R.id.recyclerView)
        var adapter=InTreasuryTwoAdapter()
        recyclerView!!.layoutManager=LinearLayoutManager(mContext)
        recyclerView!!.adapter=adapter
        recyclerView.isNestedScrollingEnabled=false
        adapter.setNewData(arrayListOf("",""))*/

    }
}