package com.micropole.inventorysystem.ui.partnership

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.partnership.PartnerShipAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_partner_ship.*
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       PartnerShipFragment
 * @Description     合作关系
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PartnerShipFragment : BaseMvpViewFragment() {
    var adapter= PartnerShipAdapter()
    override fun getFragmentLayoutId(): Int  = R.layout.fragment_partner_ship

    override fun initView(view: View?) {
        ib_back.visibility=View.GONE
        tv_right.visibility=View.VISIBLE

        rrv_partner_ship.mLayoutManager = LinearLayoutManager(mContext)
        rrv_partner_ship.mAdapter = adapter
        adapter.setNewData(arrayListOf("","",""))
        tv_title.text=getString(R.string.partner_hezuoguanxi)
        tv_right.text=getString(R.string.partner_add_hezuoguanxi)

    }

    override fun initEvent(view: View?) {
        tv_right.setOnClickListener {
            AddPartnerActivity.startAddPartnerActivity(mContext)
        }
        adapter.setOnItemClickListener { adapter, view, position ->
            PartnerDetailTwoActivity.startPartnerDetailTwoActivity(mContext)
        }
    }

    override fun initData() {
    }
}