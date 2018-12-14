package com.micropole.inventorysystem.adapter.shopmall

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.baseapplibrary.appconst.setUrl
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.OrderListBean
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * @ClassName       OrderAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 16:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderAdapter : BaseQuickAdapter<OrderListBean,BaseViewHolder>(R.layout.item_order_view) {

    override fun convert(helper: BaseViewHolder?, item: OrderListBean?) {
        helper?.apply {
            setText(R.id.tv_order_sub,item?.or_text)
            setText(R.id.tv_order_count,mContext.getString(R.string.count_goods).format(item?.or_num))
            setText(R.id.tv_order_price,"¥${item?.or_money}")
            setRvAdapter(R.id.rv_order,LinearLayoutManager(mContext),ItemAdapter(item?.or_prod))
            getView<RecyclerView>(R.id.rv_order).setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_UP){
                    onItemClickListener.onItemClick(this@OrderAdapter,null,adapterPosition)
                }
                return@setOnTouchListener false
            }
        }
    }

    class ItemAdapter(data : List<OrderListBean.OrProdBean>?) : BaseQuickAdapter<OrderListBean.OrProdBean,BaseViewHolder>(R.layout.item_order_product,data){

        override fun convert(helper: BaseViewHolder?, item: OrderListBean.OrProdBean?) {
            helper?.apply {
                if (helper.adapterPosition == data.size - 1) setGone(R.id.view_line,false)
                getView<ImageView>(R.id.iv_order_img).loadImag(item?.pro_img)
                setText(R.id.tv_product_title,item?.pro_name)
                setText(R.id.tv_product_size,item?.sp_name+"/${item?.mo_name}")
                setText(R.id.tv_product_price,"¥${item?.pro_money}")
                setText(R.id.tv_product_count,"X${item?.pro_num}")
            }
        }
    }
}