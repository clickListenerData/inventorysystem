package com.micropole.inventorysystem.adapter.shopmall

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.inventorysystem.R

/**
 * @ClassName       OrderAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 16:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderAdapter : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_order_view) {

    override fun convert(helper: BaseViewHolder?, item: Any?) {
        helper?.setRvAdapter(R.id.rv_order,LinearLayoutManager(mContext),ItemAdapter(arrayListOf(Any(),Any())))
    }

    class ItemAdapter(data : List<Any>) : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_order_product,data){

        override fun convert(helper: BaseViewHolder?, item: Any?) {

        }
    }
}