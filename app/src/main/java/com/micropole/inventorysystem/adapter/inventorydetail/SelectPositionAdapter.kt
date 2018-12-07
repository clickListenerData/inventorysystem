package com.micropole.inventorysystem.adapter.inventorydetail

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.PositionBean
import com.micropole.inventorysystem.widght.NormalLlView

/**
 * @ClassName       SelectPositionAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/7 11:51
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectPositionAdapter : BaseQuickAdapter<PositionBean,BaseViewHolder>(R.layout.item_select_member) {

    override fun convert(helper: BaseViewHolder?, item: PositionBean?) {
        helper?.getView<NormalLlView>(R.id.nll_select_title)?.setMainTitle(item?.r_role ?: "")
    }
}