package com.micropole.inventorysystem.adapter.inventorydetail

import android.graphics.drawable.ColorDrawable
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.util.ColorUtils
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @ClassName       SelectColorAdapter
 * @Description     选择颜色
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 16:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectColorAdapter : BaseQuickAdapter<ColorBean.ColorListBean,BaseViewHolder>(R.layout.item_select_color) {

    override fun convert(helper: BaseViewHolder?, item: ColorBean.ColorListBean?) {
        helper?.apply {
            setText(R.id.tv_color_t,item?.c_name)
            val view = getView<CircleImageView>(R.id.cv_color_img)
            view.setImageDrawable(ColorDrawable(ColorUtils.string2Color(item?.c_color!!)))
            addOnClickListener(R.id.iv_check)
        }
    }
}