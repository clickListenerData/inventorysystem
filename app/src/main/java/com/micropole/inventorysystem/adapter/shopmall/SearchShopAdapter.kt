package com.micropole.inventorysystem.adapter.shopmall

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.SearchPotuct
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/12/13
 * describe:
 */
class SearchShopAdapter :BaseQuickAdapter<SearchPotuct.ProductBean,BaseViewHolder>(R.layout.item_home_goods){
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: SearchPotuct.ProductBean?) {
        helper?.getView<ImageView>(R.id.iv_goods_img)!!.loadImag(item?.pro_img)
        helper?.setText(R.id.tv_goods_name,item?.pro_name)
        helper?.setText(R.id.tv_goods_des,item?.pro_label)
        helper?.setText(R.id.tv_goods_price,item?.pro_shop_price)
        helper?.getView<ImageView>(R.id.iv_hot)!!.visibility=View.GONE

    }
}