package com.micropole.inventorysystem.ui.shoppingmall

import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.EvalationListContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.EvaluationListPresent

/**
 * @ClassName       EvaluationListActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/13 17:16
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListActivity : BaseRefreshActivity<Any,EvalationListContract.Present>() {
    override fun loadData(page: Int) {

    }

    override fun initRv() {
    }

    override fun createPresenter(): EvalationListContract.Present = EvaluationListPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy
}