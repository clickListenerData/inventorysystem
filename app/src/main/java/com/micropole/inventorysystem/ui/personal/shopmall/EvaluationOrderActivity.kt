package com.micropole.inventorysystem.ui.personal.shopmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.rv_evaluation
import com.micropole.inventorysystem.adapter.shopmall.EvaluationAdapter
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.EvaluationOrderContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.EvaluationOrderPresent
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_evaluation_order.*
import org.devio.takephoto.model.TResult

/**
 * @ClassName       EvaluationOrderActivity
 * @Description     评价订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 14:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationOrderActivity : BaseUpImgActivity<EvaluationOrderContract.Present>(),EvaluationOrderContract.View {
    override fun getActivityLayoutId(): Int = R.layout.activity_evaluation_order

    override fun createPresenter(): EvaluationOrderContract.Present = EvaluationOrderPresent()

    override fun initData() {
        rv_evaluation.layoutManager = LinearLayoutManager(mContext)
        val evaluationAdapter = EvaluationAdapter()
        rv_evaluation.adapter = evaluationAdapter

        evaluationAdapter.setNewData(arrayListOf(Any(),Any()))
    }

    override fun initEvent() {
    }

    override fun imgResult(result: TResult) {

    }
}