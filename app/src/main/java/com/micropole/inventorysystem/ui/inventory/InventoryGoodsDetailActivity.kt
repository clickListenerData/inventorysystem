package com.micropole.inventorysystem.ui.inventory

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.AddInputAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_inventory_goods_detail.*

/**
 * @ClassName       InventoryGoodsDetailActivity
 * @Description     商品详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:38
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class InventoryGoodsDetailActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_inventory_goods_detail

    override fun initData() {
        rv_goods_detail.layoutManager = LinearLayoutManager(mContext)
        val addInputAdapter = AddInputAdapter()
        rv_goods_detail.adapter = addInputAdapter

        addInputAdapter.addHeaderView(getHeadView())
    }

    override fun initEvent() {
    }

    fun getHeadView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_inventory_goods_detail_head, null, false)
        return view
    }
}