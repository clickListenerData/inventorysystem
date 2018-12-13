package com.micropole.inventorysystem.ui.shoppingmall

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import com.flyco.dialog.widget.ActionSheetDialog
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.*
import com.micropole.inventorysystem.adapter.shopmall.OrderAdapter
import com.micropole.inventorysystem.entity.AddressBean
import com.micropole.inventorysystem.entity.ConfirmOrderBean
import com.micropole.inventorysystem.ui.personal.shopmall.AddressManagerActivity
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ConfirmOrderContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.ConfirmOrderPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_comfirm_order.*
import kotlinx.android.synthetic.main.view_order_address.*

/**
 * @ClassName       ConfirmOrderActivity
 * @Description     立即下单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 17:03
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ConfirmOrderActivity : BaseMvpActivity<ConfirmOrderContract.Presenter>(),ConfirmOrderContract.View{

    companion object {
        fun startConfirmOrder(context: Context,bean : ConfirmOrderBean){
            val intent = Intent(context, ConfirmOrderActivity::class.java)
            intent.putExtra("confirm_bean",bean)
            context.startActivity(intent)
        }
    }

    var mAddressId = ""
    val mAdapter = OrderAdapter.ItemAdapter(arrayListOf())

    override fun getActivityLayoutId(): Int = R.layout.activity_comfirm_order

    override fun createPresenter(): ConfirmOrderContract.Presenter = ConfirmOrderPresent()

    override fun initData() {
        rv_comfirm_order.layoutManager = LinearLayoutManager(mContext)
        rv_comfirm_order.adapter = mAdapter
        val bean = intent.getParcelableExtra<ConfirmOrderBean>("confirm_bean")
        setUIData(bean)
    }

    override fun initEvent() {
        ll_select_address.setOnClickListener { AddressManagerActivity.startAddressManager(this,1) }
        tv_btn.setOnClickListener {
            showBuyDialog()
        }
    }

    fun setUIData(bean : ConfirmOrderBean?){
        if (bean != null){
            if (!bean.rece_name.isNullOrEmpty()){
                mAddressId = bean.re_id
                tv_name.text = getString(R.string.received_personal)+":${bean.rece_name}"
                tv_phone.text = bean.rece_phone
                tv_address.text = getString(R.string.received_address)+":${bean.or_address}"
            }
            if (bean.orprod_data != null && bean.orprod_data.isNotEmpty()) mAdapter.setNewData(bean.orprod_data[0].prodinfo)
            tv_or_price.text = "¥${bean.or_moneys}"
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

            }else if(position == 1){  //微信

            }
        }
        actionSheetDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0x11 && resultCode == 0x12 && data != null){
            val bean = data.getParcelableExtra<AddressBean>("address_bean")
            if (bean != null) setAddress(bean)
        }
    }

    /**
     * 选择设置地址
     */
    fun setAddress(bean : AddressBean){
        mAddressId = bean.ua_id
        tv_name.text = getString(R.string.received_personal)+":${bean.consignee}"
        tv_phone.text = bean.phone
        tv_address.text = getString(R.string.received_address)+":${bean.address}"
    }
}