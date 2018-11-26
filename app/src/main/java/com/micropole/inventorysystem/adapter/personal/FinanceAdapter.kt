package com.micropole.inventorysystem.adapter.personal

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.inventorysystem.R

/**
 * @ClassName       FinanceAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 17:14
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FinanceAdapter : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_rv_finance) {
    override fun convert(helper: BaseViewHolder?, item: Any?) {
        helper?.apply {
            setRvAdapter(R.id.rv_finance_item,LinearLayoutManager(mContext),ItemAdapter(arrayListOf(Any(),Any())))
        }
    }

    class ItemAdapter(data : List<Any>) : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_finace_item,data){
        override fun convert(helper: BaseViewHolder?, item: Any?) {

        }
    }
}