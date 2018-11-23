package com.micropole.inventorysystem.ui.home

import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.blankj.utilcode.util.ConvertUtils
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.baseapplibrary.appconst.setTurnImage
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.util.SpaceItemDecoration
import com.micropole.inventorysystem.entity.GoodsBean
import com.micropole.inventorysystem.util.CustPagerTransformer
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_home_head.*
import kotlinx.android.synthetic.main.view_home_head.view.*

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
        rrv_home.mRecyclerView.addItemDecoration(SpaceItemDecoration())

        rrv_home.mAdapter?.setHeaderView(getHeaderView())

        (rrv_home.mAdapter as DataBindAdapter<GoodsBean>).setListData(arrayListOf(GoodsBean(), GoodsBean(),GoodsBean(), GoodsBean(),GoodsBean(), GoodsBean()))
    }

    fun getHeaderView() : View {
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_home_head, null, false)
        view.cb_home.viewPager.pageMargin=26
        view.cb_home.viewPager.clipToPadding=false
        view.cb_home.viewPager.setPadding(ConvertUtils.dp2px(24f),ConvertUtils.dp2px(10f), ConvertUtils.dp2px(24f),ConvertUtils.dp2px(10f))
        view.cb_home.viewPager.pageMargin = ConvertUtils.dp2px(14f)
        view.cb_home.setTurnImage(arrayListOf("12","12","12"),isConer = ConvertUtils.dp2px(6f)).setPageTransformer(CustPagerTransformer(mContext))
        view.tv_chuku.setOnClickListener {
                OutTreasuryActivity.startOutTreasuryActivity(mContext)
        }
        view.tv_ruku.setOnClickListener {
            InTreasuryActivity.startInTreasuryActivity(mContext)
        }
        return view
    }
}