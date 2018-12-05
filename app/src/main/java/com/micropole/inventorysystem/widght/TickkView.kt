package com.micropole.inventorysystem.widght

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.micropole.inventorysystem.R
import kotlinx.android.synthetic.main.view_submit_tickk.view.*

/**
 * @ClassName       TickkView
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 16:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class TickkView@JvmOverloads constructor(context : Context, attrs : AttributeSet? = null, def : Int = 0) : LinearLayout(context, attrs,def) {

    var count = 3
    set(value) {
        field = value
        setCount()
    }

    var data = arrayListOf<String>()
    set(value) {
        if (value.size == tvs.size){
            for (i in tvs.indices){
                tvs[i].text = value[i]
            }
        }
        field = value
    }

    var tvs = arrayListOf<TextView>()

    init {
        orientation = LinearLayout.HORIZONTAL
    }

    fun setCount(){
        for (i in 0..count){
            val view = View.inflate(context, R.layout.view_submit_tickk, null)
            view.view_one.setBackgroundColor(Color.parseColor("#cccccc"))
            view.view_two.setBackgroundColor(Color.parseColor("#cccccc"))
            view.iv_tickk.isSelected = false
            view.tv_title.isSelected = false
            tvs.add(view.tv_title)
            addView(view)
        }
        postInvalidate()
    }


}