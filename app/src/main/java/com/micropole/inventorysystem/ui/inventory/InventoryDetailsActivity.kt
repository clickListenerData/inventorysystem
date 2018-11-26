package com.micropole.inventorysystem.ui.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.home.InTreasuryAdapter
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_inventory_details.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator

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
        initMagic(magic_inventory_detail)
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        val inTreasuryAdapter = InTreasuryAdapter(mContext)
        recycler_view.adapter = inTreasuryAdapter

        inTreasuryAdapter.setNewData(arrayListOf("","",""))
    }

    override fun initEvent() {

    }

    fun initMagic(magic : MagicIndicator){
        val fragmentContainerHelper = FragmentContainerHelper()
        val commonNavigator = CommonNavigator(mContext)
        commonNavigator.adapter = IndicatorAdapter(arrayListOf("全部", "入库明细", "销售明细")) { view, index ->
            fragmentContainerHelper.handlePageSelected(index, false)
            //
        }
        magic.navigator = commonNavigator
        fragmentContainerHelper.attachMagicIndicator(magic)
    }
}