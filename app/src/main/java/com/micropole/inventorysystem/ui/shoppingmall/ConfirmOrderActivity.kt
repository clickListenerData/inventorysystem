package com.micropole.inventorysystem.ui.shoppingmall

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import com.flyco.dialog.widget.ActionSheetDialog
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.*
import com.micropole.inventorysystem.adapter.shopmall.ConfirmOrderAdapter
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
        fun startConfirmOrder(context: Context,bean : ConfirmOrderBean,data : String = ""){
            val intent = Intent(context, ConfirmOrderActivity::class.java)
            intent.putExtra("confirm_bean",bean)
            intent.putExtra("confirm_cart",data)
            context.startActivity(intent)
        }
    }

    var mAddressId = ""
    val mAdapter = ConfirmOrderAdapter()
    var mCartId :List<String>? = null
    var mNums = arrayListOf<String>()
    var mProInfo = ""
    var mBean : ConfirmOrderBean? = null

    override fun getActivityLayoutId(): Int = R.layout.activity_comfirm_order

    override fun createPresenter(): ConfirmOrderContract.Presenter = ConfirmOrderPresent()

    override fun initData() {
        rv_comfirm_order.layoutManager = LinearLayoutManager(mContext)
        rv_comfirm_order.adapter = mAdapter
        val bean = intent.getParcelableExtra<ConfirmOrderBean>("confirm_bean")
        val cartId = intent.getStringExtra("confirm_cart")
        if (!cartId.isNullOrEmpty()){
            mCartId = cartId.split(",")
        }
        setUIData(bean)
    }

    override fun initEvent() {
        ll_select_address.setOnClickListener { AddressManagerActivity.startAddressManager(this,1) }
        tv_btn.setOnClickListener {
            confirmBuy(1)
        }
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            var s = mNums[position].toInt()
            when(view.id){
                R.id.stv_quantity_add -> {
                    ++s
                    mNums[position] = s.toString()
                }
                R.id.stv_quantity_remove -> {
                    --s
                    mNums[position] = s.toString()
                }
            }
            confirmBuy()
        }
    }

    override fun setUIData(bean : ConfirmOrderBean?){
        mBean = bean
        if (bean != null){
            if (!bean.rece_name.isNullOrEmpty()){
                mAddressId = bean.re_id
                tv_name.text = getString(R.string.received_personal)+":${bean.rece_name}"
                tv_phone.text = bean.rece_phone
                tv_address.text = getString(R.string.received_address)+":${bean.or_address}"
            }
            if (bean.orprod_data != null && bean.orprod_data.isNotEmpty()){
                mAdapter.setNewData(bean.orprod_data[0].prodinfo)
                tv_or_price.text = "¥${bean.orprod_data[0].reality_order_price}"
                imv_weight.setInputContent(bean.orprod_data[0].or_weight)
                imv_discount.setInputContent(bean.orprod_data[0].discounts_price)
                mProInfo = "${bean.orprod_data[0].prodinfo[0].pro_id},${bean.orprod_data[0].prodinfo[0].sp_name},${bean.orprod_data[0].prodinfo[0].mo_name}"
                for (i in bean.orprod_data[0].prodinfo.indices){
                    mNums.add(bean.orprod_data[0].prodinfo[i].pro_num)
                }
            }
        }
    }

    fun confirmBuy(type : Int = 0){
        val r = et_remark.text.toString()
        val remark = "{\"store_id0\":\"$r\"}"
        if (mCartId != null){
            val cart = StringBuilder()
            val num = StringBuilder()
            for (i in mCartId!!.indices){
                cart.append("${mCartId!![i]},")
                num.append("${mNums[i]},")
            }
            if (cart.isNotEmpty()){
                cart.delete(cart.length-1,cart.length)
                num.delete(num.length-1,num.length)
                if (type == 0)
                    getPresenter().confirmBuy(cart.toString(),num.toString(),mAddressId,"")
                else
                    getPresenter().buyOrder(cart.toString(),num.toString(),mAddressId,"",remark)
            }
        }else{
            if (type == 0)
                getPresenter().confirmBuy("",mNums[0],mAddressId,mProInfo)
            else
                getPresenter().buyOrder("",mNums[0],mAddressId,mProInfo,remark)
        }
    }

    override fun buyOrder() {
        showBuyDialog()
    }

    override fun addError() {
        setUIData(mBean)
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