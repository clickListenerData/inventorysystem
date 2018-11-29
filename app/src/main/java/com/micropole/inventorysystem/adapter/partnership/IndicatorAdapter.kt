package com.micropole.inventorysystem.adapter.partnership

import android.content.Context
import android.graphics.Color
import android.view.View
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView

/**
 * @ClassName       IndicatorAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/9/29 16:42
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class IndicatorAdapter(val mDatas : List<String>,val action : (view : View,index : Int) -> Unit) : CommonNavigatorAdapter() {

    override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
        val titleView = ColorTransitionPagerTitleView(context)
        titleView.text = mDatas[index]
        titleView.textSize = 15f
        titleView.normalColor = Color.parseColor("#000000")
        titleView.selectedColor = Color.parseColor("#007AFF")
        titleView.setOnClickListener {
            action.invoke(it,index)
        }
        return titleView
    }

    override fun getCount(): Int {
        return mDatas.size
    }

    override fun getIndicator(context: Context?): IPagerIndicator {
        val pagerIndicator = LinePagerIndicator(context)
        pagerIndicator.setColors(Color.parseColor("#007AFF"))
        pagerIndicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
        pagerIndicator.lineHeight = UIUtil.dip2px(context!!,2.0).toFloat()
//        pagerIndicator.lineWidth = UIUtil.dip2px(context!!,30.00).toFloat()
        pagerIndicator.roundRadius = UIUtil.dip2px(context!!,1.0).toFloat()
        return pagerIndicator
    }

}