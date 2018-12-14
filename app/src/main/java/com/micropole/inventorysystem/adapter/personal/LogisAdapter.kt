package com.micropole.inventorysystem.adapter.personal

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.LoginBean
import com.micropole.inventorysystem.entity.LogisticsBean

/**
 * @ClassName       LogisAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/14 16:55
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class LogisAdapter : BaseQuickAdapter<LogisticsBean,BaseViewHolder>(R.layout.item_logistics) {
    override fun convert(helper: BaseViewHolder?, item: LogisticsBean?) {
        helper?.setText(R.id.tv_logistics_date,item?.time)
        helper?.setText(R.id.tv_logistics_des,item?.context)
    }
}