package com.micropole.inventorysystem.adapter.personal

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.flyco.dialog.utils.CornerUtils

/**
 * @ClassName       BottomListDialog
 * @Description     底部选择框
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/29 15:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class BottomListDialog(val mData : List<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val mContext = parent?.context
        val llItem = LinearLayout(mContext)
        llItem.orientation = LinearLayout.HORIZONTAL
        llItem.gravity = Gravity.CENTER_VERTICAL

        val ivItem = ImageView(mContext)
        ivItem.setPadding(0, 0, ConvertUtils.dp2px(15f), 0)
        llItem.addView(ivItem)

        val tvItem = TextView(mContext)
        tvItem.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        tvItem.setSingleLine(true)
        tvItem.gravity = Gravity.CENTER
        if (position == 0)
            tvItem.setTextColor(Color.parseColor("#007AFF"))
        else
            tvItem.setTextColor(Color.parseColor("#FE3824"))
        tvItem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17.5f)
        tvItem.height = ConvertUtils.dp2px(48f)
        tvItem.text = mData[position]

        llItem.addView(tvItem)
        val radius = ConvertUtils.dp2px(5f).toFloat()
        llItem.setBackgroundDrawable(CornerUtils.listItemSelector(radius, Color.TRANSPARENT, Color.parseColor("#ffcccccc"),
                mData.size, position))
        return llItem
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mData.size
    }
}