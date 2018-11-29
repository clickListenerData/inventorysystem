package com.micropole.inventorysystem.adapter.inventorydetail

import android.graphics.Color
import android.widget.EditText
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.widght.InputMsgView

/**
 * @ClassName       CustomerListAdapter
 * @Description     客户名单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 16:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CustomerListAdapter : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.view_input_message){
    override fun convert(helper: BaseViewHolder?, item: Any?) {
        val view = helper?.getView<EditText>(R.id.et_input_msg)
        view?.textSize = 15f
        view?.setTextColor(mContext.resources.getColor(R.color.txt_price))
        helper?.apply {
            setText(R.id.tv_input_title,"优衣库")
            setText(R.id.et_input_msg,"1200件")
        }
    }
}