package com.micropole.inventorysystem.adapter.inventorydetail

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.SpecBean

/**
 * @ClassName       SelectColorAdapter
 * @Description     选择颜色
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 16:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectSizeAdapter : BaseQuickAdapter<SpecBean.SpecListBean,BaseViewHolder>(R.layout.item_select_size) {

    override fun convert(helper: BaseViewHolder?, item: SpecBean.SpecListBean?) {
        helper?.apply {
            setText(R.id.tv_spec_t,item?.spec_name)
            addOnClickListener(R.id.iv_check)
        }
    }
}