package com.micropole.inventorysystem.ui.inventory

import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.micropole.inventorysystem.R
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
        tv_goods_inventory.isSelected = true
        switchFragment(0)
    }

    override fun initEvent() {
        tv_goods_inventory.setOnClickListener { view -> switchTxt(view) }
        tv_goods_sale.setOnClickListener { view -> switchTxt(view) }
        tv_goods_customer.setOnClickListener { view -> switchTxt(view) }
    }

    fun switchTxt(text : View){
        text.isSelected = true
        (text as TextView).setTextColor(mContext.resources.getColor(R.color.text_color_white))
        when(text){
            tv_goods_inventory -> {
                tv_goods_sale.setTextColor(mContext.resources.getColor(R.color.text_normal))
                tv_goods_customer.setTextColor(mContext.resources.getColor(R.color.text_normal))
                tv_goods_sale.isSelected = false
                tv_goods_customer.isSelected = false
                switchFragment(0)
            }
            tv_goods_sale -> {
                tv_goods_inventory.setTextColor(mContext.resources.getColor(R.color.text_normal))
                tv_goods_customer.setTextColor(mContext.resources.getColor(R.color.text_normal))
                tv_goods_inventory.isSelected = false
                tv_goods_customer.isSelected = false
                switchFragment(1)
            }
            tv_goods_customer -> {
                tv_goods_sale.setTextColor(mContext.resources.getColor(R.color.text_normal))
                tv_goods_inventory.setTextColor(mContext.resources.getColor(R.color.text_normal))
                tv_goods_sale.isSelected = false
                tv_goods_inventory.isSelected = false
                switchFragment(2)
            }
        }
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