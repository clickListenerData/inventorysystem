package com.micropole.inventorysystem.ui.shoppingmall

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.EvaluationListAdapter
import com.micropole.inventorysystem.entity.CommentsBean
import com.micropole.inventorysystem.entity.EvaluationListBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.EvaluationOrderContract
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
class EvaluationListActivity : BaseRefreshActivity<CommentsBean,EvalationListContract.Present>(),EvalationListContract.View {

    companion object {
        fun startEvalutionList(context: Context,id:String){
            val intent = Intent(context, EvaluationListActivity::class.java)
            intent.putExtra("evaluation_id",id)
            context.startActivity(intent)
        }
    }

    lateinit var mid : String
    override fun loadData(page: Int) {
        getPresenter().evalutionList(mid,page)
    }

    override fun initRv() {
        mLoadMore = true
        mid = intent.getStringExtra("evaluation_id")
        setRvLa(LinearLayoutManager(mContext),EvaluationListAdapter())
    }

    override fun createPresenter(): EvalationListContract.Present = EvaluationListPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun evaluationList(bean: List<CommentsBean>) {
        setData(bean)
    }
}