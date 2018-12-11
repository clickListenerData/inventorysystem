package com.micropole.inventorysystem.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.coorchice.library.SuperTextView
import com.micropole.baseapplibrary.appconst.setRvAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.GoodsDetailBean
import com.micropole.inventorysystem.util.ColorUtils
import com.micropole.inventorysystem.widght.CustomCenterView

/**
 * @ClassName       AddInputAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:12
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddInputAdapter : BaseQuickAdapter<GoodsDetailBean.ProductBean.ProdinfoBean,BaseViewHolder>(R.layout.item_rv_add_input) {

    override fun convert(helper: BaseViewHolder?, item: GoodsDetailBean.ProductBean.ProdinfoBean?) {
        helper?.apply {
            val view = getView<CustomCenterView>(R.id.ccv_detail_specs)
            view.setTopTxtContent(item?.spec_name ?: "")
            view.setBottomTxtContent(item?.spec_store ?: "")
            setRvAdapter(R.id.rv_item_color,LinearLayoutManager(mContext),ItemAdapter(item?.color))
        }
    }

    class ItemAdapter(data : List<GoodsDetailBean.ProductBean.ProdinfoBean.ColorBean>?) : BaseQuickAdapter
    <GoodsDetailBean.ProductBean.ProdinfoBean.ColorBean,BaseViewHolder>(R.layout.item_add_input_color,data){
        override fun convert(helper: BaseViewHolder?, item: GoodsDetailBean.ProductBean.ProdinfoBean.ColorBean?) {
            helper?.apply {
                getView<SuperTextView>(R.id.stv_color).solid = ColorUtils.string2Color(item?.c_color ?: "")
                setText(R.id.tv_color_name,item?.color_name)
            }
        }
    }
}