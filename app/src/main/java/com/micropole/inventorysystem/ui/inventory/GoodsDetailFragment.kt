package com.micropole.inventorysystem.ui.inventory

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.AddInputAdapter
import com.micropole.inventorysystem.adapter.inventorydetail.CustomerListAdapter
import com.micropole.inventorysystem.entity.ColorBean
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_goods_details.*

/**
 * @ClassName       GoodsDetailFragment
 * @Description     商品详情  商品/库存   销售明细   客户名单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 16:18
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GoodsDetailFragment : BaseMvpViewFragment() {

    companion object {
        const val INVENTORY_GOODS = "inventory_goods"
        const val SALE_DETAILS = "sale_details"
        const val CUSTOMER_LIST = "customer_list"
        fun newCreateFragmetn(title:String) : Fragment{
            val goodsDetailFragment = GoodsDetailFragment()
            val bundle = Bundle()
            bundle.putString("goods_detail_type",title)
            goodsDetailFragment.arguments = bundle
            return goodsDetailFragment
        }
    }

    var mType = ""
    var mAdapter : RecyclerView.Adapter<out BaseViewHolder>? = null

    override fun getFragmentLayoutId(): Int = R.layout.fragment_goods_details

    override fun initView(view: View?) {
        mType = arguments?.getString("goods_detail_type") ?: ""
        rv_goods_detail.layoutManager = LinearLayoutManager(mContext)
        when(mType){
            INVENTORY_GOODS -> {
                mAdapter = AddInputAdapter()
                (mAdapter as AddInputAdapter).addHeaderView(getHeadView())
                (mAdapter as AddInputAdapter).addFooterView(getFootView())
            }
            SALE_DETAILS -> {
                mAdapter = DataBindAdapter<ColorBean>(1,R.layout.item_sale_details)
            }
            CUSTOMER_LIST -> {
                mAdapter = CustomerListAdapter()
            }
        }
        rv_goods_detail.adapter = mAdapter
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
    }

    fun getHeadView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_goods_inventory_head, null, false)
        return view
    }

    fun getFootView() : View{
        val vi = LayoutInflater.from(mContext).inflate(R.layout.view_goods_inventory_foot, null, false)
        return vi
    }
}