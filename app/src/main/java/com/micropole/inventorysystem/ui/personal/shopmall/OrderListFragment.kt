package com.micropole.inventorysystem.ui.personal.shopmall

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.micropole.baseapplibrary.widght.RefreshRecyclerView
import com.micropole.inventorysystem.adapter.shopmall.OrderAdapter
import com.micropole.inventorysystem.entity.OrderListBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.OrderListContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.OrderListPresent
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseutilslibrary.extensions.startActivity

/**
 * @ClassName       OrderListFragment
 * @Description     订单列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/23 17:18
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListFragment : BaseMvpFragment<OrderListContract.Model,OrderListContract.View,OrderListContract.Present>(),OrderListContract.View{

    companion object {
        fun newFragment(type : Int) : OrderListFragment{
            val orderListFragment = OrderListFragment()
            val bundle = Bundle()
            bundle.putInt("order_type",type)
            orderListFragment.arguments = bundle
            return orderListFragment
        }
    }

    lateinit var refreshRecyclerView : RefreshRecyclerView
    var mType = 0
    val mAdapter = OrderAdapter()

    override fun getFragmentLayoutId(): Int = -1

    override fun createPresenter(): OrderListContract.Present {
        return OrderListPresent()
    }

    override fun initView(view: View?) {
        mType = arguments?.getInt("order_type") ?: mType
        refreshRecyclerView.mLayoutManager = LinearLayoutManager(mContext)
        refreshRecyclerView.mAdapter = mAdapter
    }

    override fun initEvent(view: View?) {
        refreshRecyclerView.mAdapter?.setOnItemClickListener { adapter, view, position ->
            OrderDetailActivity.startOrderDetail(mContext,mAdapter.data[position].or_id)
        }
    }

    override fun initData() {
    }

    override fun onResume() {
        super.onResume()
        if (!isHidden && userVisibleHint){
            loadData()
        }
    }

    fun loadData(){
        getPresenter().orderList(mType.toString())
    }

    override fun getFragmentView(): View? {
        refreshRecyclerView = RefreshRecyclerView(mContext)
        refreshRecyclerView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return refreshRecyclerView
    }

    override fun orderList(data: List<OrderListBean>?) {
        mAdapter.setNewData(data)
    }
}