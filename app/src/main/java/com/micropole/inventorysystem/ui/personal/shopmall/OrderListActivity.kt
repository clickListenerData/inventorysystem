package com.micropole.inventorysystem.ui.personal.shopmall

import android.content.Context
import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import com.micropole.inventorysystem.util.ScalePagerTitleView
import com.micropole.inventorysystem.util.initMagic
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_order_list.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView

/**
 * @ClassName       OrderListActivity
 * @Description     订单列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/23 17:17
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListActivity : BaseMvpViewActivity() {

    val fragmens = arrayListOf<OrderListFragment>()
    lateinit var data : Array<String>
    override fun getActivityLayoutId(): Int = R.layout.activity_order_list

    override fun initData() {
        setTitleText(res = R.string.order_list_txt)
        data = resources.getStringArray(R.array.order_title_array)
        for (i in data.indices){
            fragmens.add(OrderListFragment.newFragment(i))
        }
        initVp()
        initMagic()
    }

    override fun initEvent() {
    }

    fun initVp(){
        vp_order.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragmens[position]
            }

            override fun getCount(): Int {
                return fragmens.size
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

            }

        }

        vp_order.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                (fragmens[position]).loadData()
            }
        })
    }

    fun initMagic(){
        val commonNavigator = CommonNavigator(this)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val simplePagerTitleView = ScalePagerTitleView(context)
                simplePagerTitleView.selectedColor = Color.parseColor("#007AFF")
                simplePagerTitleView.normalColor = Color.parseColor("#666666")
                simplePagerTitleView.textSize = 13f
                simplePagerTitleView.text = data[index]
                simplePagerTitleView.setOnClickListener {
                    vp_order.currentItem = index
                }
                return simplePagerTitleView
            }

            override fun getCount(): Int {
                return data.size
            }

            override fun getIndicator(p0: Context?): IPagerIndicator? {
                return null
            }

        }
        magic_order.navigator = commonNavigator
        ViewPagerHelper.bind(magic_order,vp_order)
    }
}