package com.micropole.inventorysystem.util

import android.content.Context
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView

/**
 * @ClassName       ScalePagerTitleView
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/4 10:25
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ScalePagerTitleView(context: Context?) : SimplePagerTitleView(context) {

    override fun onSelected(index: Int, totalCount: Int) {
        super.onSelected(index, totalCount)
        this.textSize = 15f
    }

    override fun onDeselected(index: Int, totalCount: Int) {
        super.onDeselected(index, totalCount)
        this.textSize = 13f
    }
}