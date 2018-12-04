package com.micropole.inventorysystem.adapter.shopmall

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.inventorysystem.R

/**
 * @ClassName       ShopMallAdapter
 * @Description     商城
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 15:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ShopMallAdapter : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_shop_mall){
    override fun convert(helper: BaseViewHolder?, item: Any?) {
        helper?.setRvAdapter(R.id.rv_shop_goods,LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false),ItemAdapter(arrayListOf(Any(), Any(), Any(),Any())))

    }

    class ItemAdapter(data : List<Any>) : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_shop_product,data){
        override fun convert(helper: BaseViewHolder?, item: Any?) {

        }
    }
}