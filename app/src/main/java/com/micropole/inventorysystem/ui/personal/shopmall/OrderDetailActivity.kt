package com.micropole.inventorysystem.ui.personal.shopmall

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.rv_order_detail
import com.micropole.inventorysystem.R.id.tv_btn
import com.micropole.inventorysystem.adapter.shopmall.OrderAdapter
import com.micropole.inventorysystem.entity.OrderDetailBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.OrderDetailContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.OrderDetailPresent
import com.micropole.inventorysystem.ui.shoppingmall.ApplyAfterActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.view_order_address.*

/**
 * @ClassName       OrderDetailActivity
 * @Description     订单详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 16:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailActivity : BaseMvpLcecActivity<View,OrderDetailBean?,OrderDetailContract.Model,OrderDetailContract.View,OrderDetailContract.Present>(),OrderDetailContract.View{

    companion object {
        fun startOrderDetail(context: Context,id:String){
            val intent = Intent(context, OrderDetailActivity::class.java)
            intent.putExtra("order_id",id)
            context.startActivity(intent)
        }
    }

    var mOId = "0"
    var mAdapter = OrderAdapter.ItemAdapter(arrayListOf())

    override fun getActivityLayoutId(): Int = R.layout.activity_order_detail

    override fun createPresenter(): OrderDetailContract.Present {
        return OrderDetailPresent()
    }

    override fun loadData(refresh: Boolean) {
        presenter.orderDetail(mOId)
    }

    override fun initData() {
        super.initData()
        mOId = intent.getStringExtra("order_id")
        rv_order_detail.layoutManager = LinearLayoutManager(mContext)
        rv_order_detail.adapter = mAdapter
        loadData(true)
    }

    override fun initEvent() {
        tv_btn.setOnClickListener { startActivity<ApplyAfterActivity>() }
    }

    override fun setData(data: OrderDetailBean?) {
        if (data != null){
            showContent()
            tv_stat_desc.text = data.or_stat_desc

            tv_name.text = getString(R.string.received_personal) + ": ${data.user_address.consignee}"
            tv_phone.text = data.user_address.phone
            tv_address.text = getString(R.string.received_address) + ": ${data.user_address.address}"

            mAdapter.setNewData(data.orprod)

            imv_yunfei.setInputContent(data.or_weight)
            imv_youhui.setInputContent("")
            tv_detail_remark.text = ""

            tv_detail_price.text = "¥ ${data.or_money}"
        }
    }

    fun setBtnVG(stat : String){

    }
}