package com.micropole.inventorysystem.adapter.personal

import android.graphics.Color
import android.os.Build
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R

/**
 * @ClassName       MemberListAdapter
 * @Description     成员列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 10:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberListAdapter : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.view_normal_ll) {
    override fun convert(helper: BaseViewHolder?, item: Any?) {
        val view = helper?.getView<TextView>(R.id.tv_custom)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            view?.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,mContext.resources.getDrawable(R.drawable.ic_towardstheright_n),null)
        }
        view?.setTextColor(Color.parseColor("#007AFF"))

        helper?.apply {
            setText(R.id.tv_custom,"管理员")
            setText(R.id.tv_main_title,"any")
        }
    }
}