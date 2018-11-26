package com.micropole.inventorysystem.ui.inventory.input

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_goods_input.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator

/**
 * @ClassName       GoodsInputActivity
 * @Description     商品入库
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 13:32
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GoodsInputActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_goods_input

    override fun initData() {
        setTitleText(res = R.string.inventory_by_hand)
        initMagic(magic_inventory)
    }

    override fun initEvent() {
    }

    fun initMagic(magic : MagicIndicator){
        val fragmentContainerHelper = FragmentContainerHelper()
        val commonNavigator = CommonNavigator(mContext)
        commonNavigator.adapter = IndicatorAdapter(arrayListOf("大衣", "短袖", "裤子", "鞋子")) { view, index ->
            fragmentContainerHelper.handlePageSelected(index, false)
            //
        }
        magic.navigator = commonNavigator
        fragmentContainerHelper.attachMagicIndicator(magic)
    }
}