package com.micropole.inventorysystem.ui.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.home.InTreasuryAdapter
import com.micropole.inventorysystem.ui.home.InTreasuryDetailActivity
import com.micropole.inventorysystem.util.initMagic
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_inventory_details.*

/**
 * @ClassName       InventoryDetailsActivity
 * @Description     进销存明细
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:25
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class InventoryDetailsActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_inventory_details

    override fun initData() {
        magic_inventory.initMagic(arrayListOf("全部", "入库明细", "销售明细")){
            view, index ->

        }
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        val inTreasuryAdapter = InTreasuryAdapter(2)
        recycler_view.adapter = inTreasuryAdapter

        inTreasuryAdapter.setNewData(arrayListOf("","",""))

        inTreasuryAdapter.setOnItemClickListener { adapter, view, position ->
            InTreasuryDetailActivity.startInTreasuryDetailActivity(mContext,InTreasuryDetailActivity.TYPE_DETAIL)
        }
    }

    override fun initEvent() {

    }
}