package com.micropole.inventorysystem.widght

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.flyco.dialog.widget.popup.base.BasePopup

/**
 * @ClassName       AfterPopup
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/14 10:17
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AfterPopup(context: Context,val data : ArrayList<String>,val action : (index : Int,s : String) -> Unit) : BasePopup<AfterPopup>(context) {

    lateinit var listView: ListView

    override fun setUiBeforShow() {
        val params = LinearLayout.LayoutParams(mAnchorView.width, LinearLayout.LayoutParams.WRAP_CONTENT)
        listView.layoutParams = params
        listView.adapter = Adapter(data)
        listView.setOnItemClickListener { parent, view, position, id ->
            action.invoke(position,data[position])
            dismiss()
        }
    }

    override fun onCreatePopupView(): View {
        listView = ListView(mContext)
        return listView
    }

    class Adapter(val data : ArrayList<String>) : BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val tvItem = TextView(parent?.context)
            tvItem.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            tvItem.setSingleLine(true)
            tvItem.setBackgroundColor(Color.parseColor("#ffffff"))
            tvItem.gravity = Gravity.CENTER
            tvItem.setTextColor(Color.parseColor("#007AFF"))
            tvItem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17.5f)
            tvItem.height = ConvertUtils.dp2px(48f)
            tvItem.text = data[position]
            return tvItem
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return data.size
        }

    }
}