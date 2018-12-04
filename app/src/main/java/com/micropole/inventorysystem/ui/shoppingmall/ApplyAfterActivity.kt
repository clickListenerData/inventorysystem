package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.ApplyAfterAdapter
import com.micropole.inventorysystem.adapter.shopmall.CartAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_apply_after.*

/**
 * @ClassName       ApplyAfterActivity
 * @Description     申请售后
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 10:14
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ApplyAfterActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_apply_after

    override fun initData() {
        rv_apply.layoutManager = LinearLayoutManager(mContext)
        val adapter = ApplyAfterAdapter()
        rv_apply.adapter = adapter
        adapter.setNewData(arrayListOf(Any(), Any(),Any()))
    }

    override fun initEvent() {
    }
}