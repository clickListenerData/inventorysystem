package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.ShopMallAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_shop_mall.*

/**
 * @ClassName       ShoppingMallFragment
 * @Description     商城
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:51
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ShoppingMallFragment : BaseMvpViewFragment() {
    override fun getFragmentLayoutId(): Int = R.layout.fragment_shop_mall

    override fun initView(view: View?) {
        rrv_shop_mall.mLayoutManager = LinearLayoutManager(mContext)
        val shopMallAdapter = ShopMallAdapter()
        rrv_shop_mall.mAdapter = shopMallAdapter

        shopMallAdapter.setNewData(arrayListOf(Any(), Any(),Any()))
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
    }
}