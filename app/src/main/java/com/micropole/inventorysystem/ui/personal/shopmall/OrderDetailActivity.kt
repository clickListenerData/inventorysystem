package com.micropole.inventorysystem.ui.personal.shopmall

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.blankj.utilcode.util.TimeUtils
import com.flyco.dialog.widget.ActionSheetDialog
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.rv_order_detail
import com.micropole.inventorysystem.R.id.tv_btn
import com.micropole.inventorysystem.adapter.personal.LogisAdapter
import com.micropole.inventorysystem.adapter.shopmall.OrderAdapter
import com.micropole.inventorysystem.entity.OrderDetailBean
import com.micropole.inventorysystem.entity.OrderListBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.OrderDetailContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.OrderDetailPresent
import com.micropole.inventorysystem.ui.shoppingmall.ApplyAfterActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.view_order_address.*
import java.util.*

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
    val mLAdapter = LogisAdapter()
    var mBean : OrderDetailBean? = null

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

        rv_logistics.layoutManager = LinearLayoutManager(mContext)
        rv_logistics.adapter = mLAdapter
        loadData(true)
    }

    override fun initEvent() {
        tv_btn.setOnClickListener { showBuyDialog() }
        stv_btn_one.setOnClickListener {
            presenter.confirmOrder(mOId)
            showToast("确认收货")
        }
        stv_btn_two.setOnClickListener {
            when(it.tag){
                2 -> {
                    ApplyAfterActivity.startApplyAfter(this, mBean?.orprod as ArrayList<OrderListBean.OrProdBean>,mBean?.or_id ?: "")
                    showToast("取消订单")
                }
                3 -> { showToast("延迟收货") }
                4 -> {
                    EvaluationOrderActivity.startEvaluationOrder(this,mBean?.orprod as ArrayList<OrderListBean.OrProdBean>,mBean?.or_id ?: "")
                    showToast("立即评价")
                }
                5 -> {
                    ApplyAfterActivity.startApplyAfter(this, mBean?.orprod as ArrayList<OrderListBean.OrProdBean>,mBean?.or_id ?: "")
                    showToast("申请售后")
                }
            }
        }
    }

    override fun setData(data: OrderDetailBean?) {
        if (data != null){
            showContent()
            mBean = data
            tv_stat_desc.text = data.or_stat_desc
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                setBtnVG(data)
            }

            tv_name.text = getString(R.string.received_personal) + ": ${data.user_address.consignee}"
            tv_phone.text = data.user_address.phone
            tv_address.text = getString(R.string.received_address) + ": ${data.user_address.address}"

            mAdapter.setNewData(data.orprod)

            imv_yunfei.setInputContent(data.or_weight)  //运费
            imv_youhui.setInputContent(data.discounts_price)              //优惠
            tv_detail_remark.text = data.or_leave                 //备注

            tv_detail_price.text = "¥ ${data.or_money}"
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun setBtnVG(bean : OrderDetailBean?){
        tv_btn.visibility = View.GONE
        stv_btn_two.visibility = View.VISIBLE
        when(bean?.or_stat){
            "0" -> {
                tv_btn.visibility = View.VISIBLE
                stv_btn_two.visibility = View.GONE
                msToDate(bean.unpaid_overdue_time.toLong())
            }
            "2" -> {
                tv_stat_desc.setCompoundDrawablesRelativeWithIntrinsicBounds(null,resources.getDrawable(R.drawable.ic_tobeshipped_n),null,null)
                stv_btn_two.text = "取消订单"
                stv_btn_two.tag = 2
            }
            "3" -> {
                tv_stat_desc.setCompoundDrawablesRelativeWithIntrinsicBounds(null,resources.getDrawable(R.drawable.ic_goodstobereceived_n),null,null)
                stv_btn_one.visibility = View.VISIBLE
                stv_btn_one.text = "确认收货"
                stv_btn_two.text = "延迟收货"
                stv_btn_two.tag = 3
                tv_logsitics.visibility = View.VISIBLE
                mLAdapter.setNewData(bean.logistics)
            }
            "4" -> {
                tv_stat_desc.setCompoundDrawablesRelativeWithIntrinsicBounds(null,resources.getDrawable(R.drawable.ic_tobeevaluate_n),null,null)
                if (bean.is_comment == "0"){
                    stv_btn_two.text = "立即评价"
                    stv_btn_two.tag = 4
                }else{
                    stv_btn_two.visibility = View.GONE
                }
                tv_logsitics.visibility = View.VISIBLE
                mLAdapter.setNewData(bean.logistics)
            }
            "5" -> {
                tv_stat_desc.setCompoundDrawablesRelativeWithIntrinsicBounds(null,resources.getDrawable(R.drawable.ic_complet_n),null,null)
                stv_btn_two.text = "申请售后"
                stv_btn_two.tag = 5
                tv_logsitics.visibility = View.VISIBLE
                mLAdapter.setNewData(bean.logistics)
            }
            "1","6" -> {
                stv_btn_two.visibility = View.GONE
                if (bean.or_stat == "6"){
                    tv_logsitics.visibility = View.VISIBLE
                    mLAdapter.setNewData(bean.logistics)
                }
            }
        }
    }

    /**
     * 支付弹框
     */
    fun showBuyDialog(){
        val actionSheetDialog = ActionSheetDialog(this, resources.getStringArray(R.array.buy_pay_list), null)
        actionSheetDialog.isTitleShow(false)
        actionSheetDialog.cancelText(Color.parseColor("#007aff"))
        actionSheetDialog.itemTextColor(Color.parseColor("#007aff"))
        actionSheetDialog.setOnOperItemClickL { parent, view, position, id ->
            if (position == 0){   //支付宝
                showToast("支付宝")
            }else if(position == 1){  //微信
                showToast("微信")
            }
            actionSheetDialog.dismiss()
        }
        actionSheetDialog.show()
    }

    fun msToDate(ms : Long){
        val l = ms - System.currentTimeMillis() / 1000
        val seconds = l % 60
        val hours = l / 3600
        tv_desc.text = getString(R.string.auto_close_order).format(hours,seconds)
    }
}