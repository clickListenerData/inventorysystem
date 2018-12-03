package com.micropole.inventorysystem.ui.personal.shopmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.EvaluationAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_evaluation_order.*

/**
 * @ClassName       EvaluationOrderActivity
 * @Description     评价订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 14:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationOrderActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_evaluation_order

    override fun initData() {
        rv_evaluation.layoutManager = LinearLayoutManager(mContext)
        val evaluationAdapter = EvaluationAdapter()
        rv_evaluation.adapter = evaluationAdapter

        evaluationAdapter.setNewData(arrayListOf(Any(),Any()))
    }

    override fun initEvent() {
    }
}