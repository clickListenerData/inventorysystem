package com.micropole.inventorysystem.util

import android.view.View
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