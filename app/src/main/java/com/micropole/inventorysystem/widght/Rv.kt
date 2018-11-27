package com.micropole.inventorysystem.widght

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * @ClassName       Rv
 * @Description     禁止手动滚动 RecyclerView
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/27 9:20
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class Rv(context: Context,attributeSet: AttributeSet) : RecyclerView(context,attributeSet) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        return false
    }
}