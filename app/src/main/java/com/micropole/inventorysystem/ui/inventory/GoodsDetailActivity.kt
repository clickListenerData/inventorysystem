package com.micropole.inventorysystem.ui.inventory

import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.*
import com.micropole.inventorysystem.util.initMagic
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_goods_details.*

/**
 * @ClassName       GoodsDetailActivity
 * @Description     商品详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 15:23
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GoodsDetailActivity : BaseMvpViewActivity(){

    var mFragments = arrayListOf(GoodsDetailFragment.newCreateFragmetn(GoodsDetailFragment.INVENTORY_GOODS),
            GoodsDetailFragment.newCreateFragmetn(GoodsDetailFragment.SALE_DETAILS),
            GoodsDetailFragment.newCreateFragmetn(GoodsDetailFragment.CUSTOMER_LIST))

    override fun getActivityLayoutId(): Int = R.layout.activity_goods_details

    override fun initData() {
        magic_goods_detail.initMagic(resources.getStringArray(R.array.goods_detail_array).toList()){
            view, index ->
            switchFragment(index)
        }
        switchFragment(0)
    }

    override fun initEvent() {

    }

    fun switchFragment(index : Int){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var fragment: Fragment
        var i = 0
        val j = mFragments.size
        while (i < j) {
            if (i == index) {
                i++
                continue
            }
            fragment = mFragments[i]
            if (fragment.isAdded) {
                fragmentTransaction.hide(fragment)
            }
            i++
        }
        fragment = mFragments[index]
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
        } else {
            fragmentTransaction.add(com.micropole.baseapplibrary.R.id.fl_content, fragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}