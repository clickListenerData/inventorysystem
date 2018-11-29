package com.micropole.inventorysystem.ui.inventory.input

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import com.micropole.inventorysystem.entity.InventoryGoodsBean
import com.micropole.inventorysystem.util.initMagic
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_goods_input.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator

/**
 * @ClassName       GoodsInputActivity
 * @Description     商品入库
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 13:32
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GoodsInputActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_goods_input

    override fun initData() {
        setTitleText(res = R.string.inventory_by_hand)
        magic_inventory.initMagic(arrayListOf("默认","大衣", "短袖", "裤子", "鞋子")){
            view, index ->

        }

        rv_input_inventory.layoutManager = LinearLayoutManager(mContext)
        val dataBindAdapter = DataBindAdapter<InventoryGoodsBean>(1, R.layout.item_inventory_goods)
        rv_input_inventory.adapter = dataBindAdapter

        dataBindAdapter.setNewData(arrayListOf(InventoryGoodsBean(), InventoryGoodsBean(),InventoryGoodsBean()))
    }

    override fun initEvent() {
    }
}