package com.micropole.inventorysystem.util

import android.graphics.Color
import android.view.View
import android.widget.EditText
import com.blankj.utilcode.util.EncodeUtils
import com.blankj.utilcode.util.EncryptUtils
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator

/**
 * @ClassName       Extend
 * @Description     扩展类
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/27 13:40
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
fun MagicIndicator.initMagic(list : List<String>,action : (view : View,index : Int) -> Unit){
    val fragmentContainerHelper = FragmentContainerHelper()
    val commonNavigator = CommonNavigator(this.context)
    commonNavigator.isAdjustMode = true
    commonNavigator.adapter = IndicatorAdapter(list) { view, index ->
        fragmentContainerHelper.handlePageSelected(index, false)
        action.invoke(view,index)
    }
    this.navigator = commonNavigator
    fragmentContainerHelper.attachMagicIndicator(this)
}

fun EditText.addFocusListener(view : View){
    this.setOnFocusChangeListener { v, hasFocus ->
        view.setBackgroundColor(if (hasFocus) Color.parseColor("#007AFF") else Color.parseColor("#DDDDDD"))
    }
}

fun String.md5() = EncryptUtils.encryptMD5ToString(EncryptUtils.encryptMD5ToString(this + "mcjp")
        .toLowerCase()).toLowerCase()