package com.micropole.inventorysystem

import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.micropole.baseapplibrary.activity.BaseNavigationActivity
import com.micropole.inventorysystem.ui.home.HomeFragment
import com.micropole.inventorysystem.ui.inventory.InventoryManagerFragment
import com.micropole.inventorysystem.ui.partnership.PartnerShipFragment
import com.micropole.inventorysystem.ui.personal.PersonalFragment
import com.micropole.inventorysystem.ui.shoppingmall.ShoppingMallFragment
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView

class MainActivity : BaseNavigationActivity() {

    override fun getPagerTitleView(index: Int): IPagerTitleView {
        val mBottomTitle = mContext.resources.getStringArray(R.array.main_bottom_title)
        val commonPagerTitleView = CommonPagerTitleView(this)
        val customLayout = LayoutInflater.from(this).inflate(R.layout.simple_pager_title_layout, null)
        val titleImg = customLayout.findViewById<View>(R.id.title_img) as ImageView
        val titleText = customLayout.findViewById<View>(R.id.title_text) as TextView
        titleImg.setImageResource(android.R.drawable.btn_star_big_off)
        titleText.text = mBottomTitle[index]
        commonPagerTitleView.setContentView(customLayout)

        commonPagerTitleView.onPagerTitleChangeListener = object : CommonPagerTitleView.OnPagerTitleChangeListener {

            override fun onSelected(index: Int, totalCount: Int) {
                titleImg.setImageResource(android.R.drawable.btn_star_big_on)
            }

            override fun onDeselected(index: Int, totalCount: Int) {
                titleImg.setImageResource(android.R.drawable.btn_star_big_off)
            }

            override fun onLeave(index: Int, totalCount: Int, leavePercent: Float, leftToRight: Boolean) {
            }

            override fun onEnter(index: Int, totalCount: Int, enterPercent: Float, leftToRight: Boolean) {
            }
        }

        commonPagerTitleView.setOnClickListener {
            checkItem(index)
        }

        return commonPagerTitleView
    }

    override fun getFragments(): List<Fragment> {
        return arrayListOf(HomeFragment(),InventoryManagerFragment(),PartnerShipFragment(),ShoppingMallFragment(),PersonalFragment())
    }

}
