package com.micropole.inventorysystem.adapter.shopmall

import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CarBean
import com.micropole.inventorysystem.entity.OrderListBean
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * @ClassName       CartAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 16:06
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ConfirmOrderAdapter : BaseQuickAdapter<OrderListBean.OrProdBean,BaseViewHolder>(R.layout.item_shop_cart) {
    override fun convert(helper: BaseViewHolder?, item: OrderListBean.OrProdBean?) {
        helper?.apply {
            setGone(R.id.cb_product_checked,false)
            addOnClickListener(R.id.stv_quantity_add)
            addOnClickListener(R.id.stv_quantity_remove)
            getView<ImageView>(R.id.iv_product_img).loadImag(item?.pro_img)
            setText(R.id.tv_product_title,item?.pro_name)
            setText(R.id.tv_product_size,item?.mo_name+"/"+item?.sp_name)
            setText(R.id.tv_product_price,"￥"+item?.pro_money)
            setText(R.id.tv_quantity,item?.pro_num)
        }
    }
}