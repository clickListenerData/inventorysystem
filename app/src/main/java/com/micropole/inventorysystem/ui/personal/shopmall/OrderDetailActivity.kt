package com.micropole.inventorysystem.ui.personal.shopmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.OrderAdapter
import com.micropole.inventorysystem.ui.shoppingmall.ApplyAfterActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_order_detail.*

/**
 * @ClassName       OrderDetailActivity
 * @Description     订单详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 16:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_order_detail

    override fun initData() {
        rv_order_detail.layoutManager = LinearLayoutManager(mContext)
        rv_order_detail.adapter = OrderAdapter.ItemAdapter(arrayListOf(Any(), Any()))
    }

    override fun initEvent() {
        tv_btn.setOnClickListener { startActivity<EvaluationOrderActivity>() }
    }
}