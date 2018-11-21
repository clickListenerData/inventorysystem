package com.micropole.inventorysystem.ui.home

import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.GoodsBean
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @ClassName       HomeFragment
 * @Description     首页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomeFragment : BaseMvpViewFragment() {
    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
        rrv_home.mLayoutManager = GridLayoutManager(mContext,2,GridLayoutManager.VERTICAL,false)
        rrv_home.mAdapter = DataBindAdapter<GoodsBean>(1,R.layout.item_home_goods)
        rrv_home.mAdapter?.isUseEmpty(false)

        rrv_home.mAdapter?.setHeaderView(getHeaderView())

        (rrv_home.mAdapter as DataBindAdapter<GoodsBean>).setListData(arrayListOf(GoodsBean(), GoodsBean(),GoodsBean(), GoodsBean(),GoodsBean(), GoodsBean()))
    }

    fun getHeaderView() : View {
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_home_head, null, false)
        return view
    }
}