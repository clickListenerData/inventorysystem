package com.micropole.inventorysystem.ui.shoppingmall

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.ApplyAfterAdapter
import com.micropole.inventorysystem.adapter.shopmall.CartAdapter
import com.micropole.inventorysystem.entity.OrderListBean
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ApplyAfterContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.ApplyAfterPresent
import com.micropole.inventorysystem.widght.AfterPopup
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_apply_after.*
import kotlinx.android.synthetic.main.activity_apply_after.view.*

/**
 * @ClassName       ApplyAfterActivity
 * @Description     申请售后
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 10:14
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ApplyAfterActivity : BaseMvpActivity<ApplyAfterContract.Present>(),BaseMvpView {

    companion object {
        fun startApplyAfter(context: Context,data : ArrayList<OrderListBean.OrProdBean>,id:String){
            val intent = Intent(context, ApplyAfterActivity::class.java)
            intent.putParcelableArrayListExtra("after_data",data)
            intent.putExtra("after_id",id)
            context.startActivity(intent)
        }
    }

    var mOid = ""
    val adapter = ApplyAfterAdapter()
    val mChecks = arrayListOf<Boolean>()
    var mType = 1
    var mReson = ""

    override fun getActivityLayoutId(): Int = R.layout.activity_apply_after

    override fun createPresenter(): ApplyAfterContract.Present {
        return ApplyAfterPresent()
    }

    override fun initData() {
        setTitleText("申请售后")
        rv_apply.layoutManager = LinearLayoutManager(mContext)
        rv_apply.adapter = adapter

        mOid = intent.getStringExtra("after_id")
        val data = intent.getParcelableArrayListExtra<OrderListBean.OrProdBean>("after_data")
        adapter.setNewData(data)
        for (i in data.indices){
            mChecks.add(false)
        }
    }

    override fun initEvent() {
        adapter.setOnItemChildClickListener { adapter, view, position ->
            view.isSelected = !mChecks[position]
            mChecks[position] = view.isSelected
            for (i in mChecks.indices){
                if (!mChecks[i]) {
                    tv_all_check.isSelected = false
                }else if (i == mChecks.size - 1){
                    tv_all_check.isSelected = true
                }
            }
        }

        tv_all_check.setOnClickListener {
            it.isSelected = !adapter.mIsAll
            adapter.mIsAll = it.isSelected
            for (i in mChecks.indices){
                mChecks[i] = adapter.mIsAll
            }
        }

        stv_after_reason.setOnClickListener { showSelectDialog(1) }

        stv_after_type.setOnClickListener { showSelectDialog(0) }

        stv_commit.setOnClickListener {
            applyAfter()
        }
    }

    fun showSelectDialog(type : Int){
        if (type == 0){
             AfterPopup(this, arrayListOf("申请退货", "申请退款")) { index, s ->
                 stv_after_type.text = s
                mType = index + 1
            }.anchorView(stv_after_type).gravity(Gravity.BOTTOM).alignCenter(true).show()
        }else{
            AfterPopup(this, arrayListOf("不想要了","你猜")){
                index, s ->
                stv_after_reason.text = s
                mReson = s
            }.anchorView(stv_after_reason).gravity(Gravity.BOTTOM).alignCenter(true).show()
        }
    }


    fun applyAfter(){
        val proIds = StringBuilder()
        for (i in mChecks.indices){
            if (mChecks[i]){
                proIds.append(adapter.data[i].pro_id + ",")
            }
        }
        if (proIds.isNotEmpty()) {
            proIds.delete(proIds.length - 1,proIds.length)
            getPresenter().applyAfter(mOid,mType.toString(),proIds.toString(),mReson,et_input_remark.text.toString())
        }else{
            showToast("未选中商品")
        }
    }
}