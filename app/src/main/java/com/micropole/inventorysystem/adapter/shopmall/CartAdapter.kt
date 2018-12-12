package com.micropole.inventorysystem.adapter.shopmall

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CarBean

/**
 * @ClassName       CartAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 16:06
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CartAdapter : BaseQuickAdapter<CarBean.ShoppBean,BaseViewHolder>(R.layout.item_shop_cart) {
    override fun convert(helper: BaseViewHolder?, item: CarBean.ShoppBean?) {
        helper?.apply {
            addOnClickListener(R.id.cb_product_checked)
            addOnClickListener(R.id.stv_quantity_add)
            addOnClickListener(R.id.stv_quantity_remove)
            addOnClickListener(R.id.stv_delete)
        }
    }
}