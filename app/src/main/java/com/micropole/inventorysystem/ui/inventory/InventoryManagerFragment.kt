package com.micropole.inventorysystem.ui.inventory

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import com.micropole.inventorysystem.entity.InventoryGoodsBean
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.fragment_inventory_manager.*
import kotlinx.android.synthetic.main.view_inventory_head.view.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator

/**
 * @ClassName       InventoryManagerFragment
 * @Description     库存管理
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class InventoryManagerFragment : BaseMvpViewFragment() {
    override fun getFragmentLayoutId(): Int = R.layout.fragment_inventory_manager

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
        rrv_inventory.mLayoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        val dataBindAdapter = DataBindAdapter<InventoryGoodsBean>(1, R.layout.item_inventory_goods)
        rrv_inventory.mAdapter = dataBindAdapter
        rrv_inventory.mAdapter?.isUseEmpty(false)

        rrv_inventory.mAdapter?.setHeaderView(getHeaderView())

        dataBindAdapter.setListData(arrayListOf(InventoryGoodsBean(), InventoryGoodsBean(),InventoryGoodsBean()))

        dataBindAdapter.setOnItemClickListener { adapter, view, position ->
            activity?.startActivity<GoodsDetailActivity>()
        }
    }

    fun getHeaderView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_inventory_head, null,false)
        initMagic(view.magic_inventory)
        view.tv_new_goods.setOnClickListener { activity?.startActivity<NewGoodsActivity>() }
        return view
    }

    fun initMagic(magic : MagicIndicator){
        val fragmentContainerHelper = FragmentContainerHelper()
        val commonNavigator = CommonNavigator(mContext)
        commonNavigator.adapter = IndicatorAdapter(arrayListOf("大衣", "短袖", "裤子", "鞋子")) { view, index ->
            fragmentContainerHelper.handlePageSelected(index, false)
            //
        }
        magic.navigator = commonNavigator
        fragmentContainerHelper.attachMagicIndicator(magic)
    }
}