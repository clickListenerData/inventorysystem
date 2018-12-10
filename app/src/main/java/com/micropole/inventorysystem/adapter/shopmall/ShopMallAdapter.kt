package com.micropole.inventorysystem.adapter.shopmall

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ShopMall
import com.micropole.inventorysystem.ui.shoppingmall.ProductDetailActivity
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * @ClassName       ShopMallAdapter
 * @Description     商城
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 15:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ShopMallAdapter : BaseQuickAdapter<ShopMall,BaseViewHolder>(R.layout.item_shop_mall){
    override fun convert(helper: BaseViewHolder?, item: ShopMall) {
        val itemAdapter = ItemAdapter(item.product_data)
        helper?.setRvAdapter(R.id.rv_shop_goods,LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false),itemAdapter)
        helper?.setText(R.id.tv_name_tit,item.area_name)

        itemAdapter.setOnItemClickListener { adapter, view, position ->
            ProductDetailActivity.startProductDetail(mContext,(adapter as ItemAdapter).data[position].pro_id)
        }
    }

    class ItemAdapter(data : List<ShopMall.ProductDataBean>) : BaseQuickAdapter<ShopMall.ProductDataBean,BaseViewHolder>(R.layout.item_shop_product,data){
        override fun convert(helper: BaseViewHolder?, item: ShopMall.ProductDataBean?) {
            helper?.setText(R.id.tv_product_name,item?.pro_name)
                    ?.setText(R.id.tv_product_des,item?.pro_label)
                    ?.setText(R.id.tv_product_price,"￥"+item?.pro_shop_price)
            helper?.getView<ImageView>(R.id.iv_product_img)?.loadImag(item?.pro_img)
        }
    }
}