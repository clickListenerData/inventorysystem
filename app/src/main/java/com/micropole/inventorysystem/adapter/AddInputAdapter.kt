package com.micropole.inventorysystem.adapter

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.inventorysystem.R

/**
 * @ClassName       AddInputAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:12
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddInputAdapter : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_rv_add_input) {

    override fun convert(helper: BaseViewHolder?, item: Any?) {
        helper?.apply {
            setRvAdapter(R.id.rv_item_color,LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false),ItemAdapter(arrayListOf(Any(), Any(),Any())))
        }
    }

    class ItemAdapter(data : List<Any>) : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_add_input_color,data){
        override fun convert(helper: BaseViewHolder?, item: Any?) {

        }
    }
}