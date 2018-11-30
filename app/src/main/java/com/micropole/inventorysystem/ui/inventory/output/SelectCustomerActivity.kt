package com.micropole.inventorysystem.ui.inventory.output

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.partnership.PartnerShipAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_select_customer.*

/**
 * @ClassName       SelectCustomerActivity
 * @Description     选择客户   1.新建订单   2.添加回款记录
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/29 9:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectCustomerActivity : BaseMvpViewActivity() {
    val adapter = PartnerShipAdapter()
    override fun getActivityLayoutId(): Int = R.layout.activity_select_customer

    override fun initData() {
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        recycler_view.adapter = adapter
        adapter.setNewData(arrayListOf("","",""))
    }

    override fun initEvent() {
    }
}