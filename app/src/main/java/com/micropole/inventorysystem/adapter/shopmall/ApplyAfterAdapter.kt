package com.micropole.inventorysystem.adapter.shopmall

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.OrderListBean
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * @ClassName       ApplyAfterAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 14:37
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ApplyAfterAdapter : BaseQuickAdapter<OrderListBean.OrProdBean,BaseViewHolder>(R.layout.item_apply_after) {
    var mIsAll = false
    set(value) {
        if (value != field){
            field = value
            notifyDataSetChanged()
        }
    }
    override fun convert(helper: BaseViewHolder?, item: OrderListBean.OrProdBean?) {
        helper?.apply {
            val view = getView<ImageView>(R.id.iv_check_product)
            view.isSelected = mIsAll
            getView<ImageView>(R.id.iv_order_img).loadImag(item?.pro_img)
            setText(R.id.tv_product_title,item?.pro_name)
            setText(R.id.tv_product_size,item?.sp_name+"/${item?.mo_name}")
            setText(R.id.tv_product_price,"¥${item?.pro_money}")
            setText(R.id.tv_product_count,"X${item?.pro_num}")
            addOnClickListener(R.id.iv_check_product)
        }
    }
}