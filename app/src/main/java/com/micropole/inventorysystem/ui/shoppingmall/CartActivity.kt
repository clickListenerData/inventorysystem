package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.CartAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_cart.*

/**
 * @ClassName       CartActivity
 * @Description     购物车
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 15:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CartActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int  = R.layout.activity_cart

    override fun initData() {
        rrv_cart.mLayoutManager = LinearLayoutManager(mContext)
        val cartAdapter = CartAdapter()
        rrv_cart.mAdapter = cartAdapter

        cartAdapter.setNewData(arrayListOf(Any(), Any(),Any()))
    }

    override fun initEvent() {
    }
}