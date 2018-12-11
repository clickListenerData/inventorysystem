package com.micropole.inventorysystem.ui.inventory.input

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.*
import com.micropole.inventorysystem.adapter.partnership.IndicatorAdapter
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.entity.InventoryGoodsBean
import com.micropole.inventorysystem.ui.inventory.NewGoodsActivity
import com.micropole.inventorysystem.ui.inventory.mvp.GoodsInputContract
import com.micropole.inventorysystem.ui.inventory.mvp.present.GoodsInputPresent
import com.micropole.inventorysystem.util.initMagic
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
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
class GoodsInputActivity : BaseMvpActivity<GoodsInputContract.Present>(),GoodsInputContract.View,View.OnClickListener{

    lateinit var dataBindAdapter : DataBindAdapter<InventoryGoodsBean.ProductListBean>
    lateinit var mOldView : TextView
    var mSort = 1
    var mId = "0"

    override fun getActivityLayoutId(): Int = R.layout.activity_goods_input

    override fun createPresenter(): GoodsInputContract.Present {
        return GoodsInputPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.inventory_by_hand)

        tv_inventory_zh.isSelected = true
        mOldView = tv_inventory_zh
        rv_input_inventory.layoutManager = LinearLayoutManager(mContext)
        dataBindAdapter = DataBindAdapter(1, R.layout.item_inventory_goods)
        rv_input_inventory.adapter = dataBindAdapter
    }

    fun loadData(){
        getPresenter().goodsList(mId,mSort)
    }

    override fun onResume() {
        super.onResume()
        getPresenter().categoryList()
    }

    override fun initEvent() {
        tv_create_goods.setOnClickListener { startActivity<NewGoodsActivity>() }

        dataBindAdapter.setOnItemClickListener { adapter, view, position ->
            AddInputActivity.startAddInput(mContext,dataBindAdapter.data[position].pro_id,true)
        }

        fl_zh.setOnClickListener(this)
        fl_ckl.setOnClickListener(this)
        fl_time.setOnClickListener(this)
        fl_xl.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        mOldView.isSelected = false
        when(v?.id){
            R.id.fl_zh -> {
                tv_inventory_zh.isSelected = true
                mSort = 1
                mOldView = tv_inventory_zh
            }
            R.id.fl_ckl -> {
                tv_inventory_ckl.isSelected = true
                mSort = if (mSort == 2) 3 else 2
                mOldView = tv_inventory_ckl
            }
            R.id.fl_time -> {
                tv_inventory_time.isSelected = true
                mSort = if (mSort == 6) 7 else 6
                mOldView = tv_inventory_time
            }
            R.id.fl_xl -> {
                tv_inventory_xl.isSelected = true
                mSort = if (mSort == 4) 5 else 4
                mOldView = tv_inventory_xl
            }
        }
        loadData()
    }

    override fun categoryList(bean: CategoryBean) {
        val list = arrayListOf<String>()
        list.add(getString(R.string.all_txt))
        for (i in bean.area_list.indices){
            list.add(bean.area_list[i].area_name)
        }
        magic_inventory.initMagic(list){
            view, index ->
            mId = if (index == 0){
                "0"
            }else{
                bean.area_list[index - 1].area_id
            }
            loadData()
        }
    }

    override fun goodsList(data: InventoryGoodsBean) {
        dataBindAdapter.setNewData(data.product_list)
    }
}