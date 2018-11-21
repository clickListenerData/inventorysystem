package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.personal.FinanceAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_finance.*

/**
 * @ClassName       FinanceActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 17:11
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FinanceActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_finance

    override fun initData() {
        rv_finance.layoutManager = LinearLayoutManager(mContext)
        rv_finance.adapter = FinanceAdapter()

        (rv_finance.adapter as FinanceAdapter).setNewData(arrayListOf(Any(),Any()))
    }

    override fun initEvent() {
    }
}