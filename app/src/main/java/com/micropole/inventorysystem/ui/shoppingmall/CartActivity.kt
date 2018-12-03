package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.CartAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_cart.*

/**
 * @ClassName       CartActivity
 * @Description     购物车
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 15:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CartActivity : BaseMvpViewActivity(){

    private var mChecksData = arrayListOf<Boolean>()
    private val cartAdapter = CartAdapter()

    override fun getActivityLayoutId(): Int  = R.layout.activity_cart

    override fun initData() {
        rrv_cart.mLayoutManager = LinearLayoutManager(mContext)
        rrv_cart.mAdapter = cartAdapter

        cartAdapter.setNewData(arrayListOf(Any(), Any(),Any()))
    }

    override fun initEvent() {

        cartAdapter.setOnItemChildClickListener { adapter, view, position ->
            when(view.id){
                R.id.stv_delete -> deleteProduct(position)
                R.id.stv_quantity_add -> addRemoveProduct(true,position)
                R.id.stv_quantity_remove -> addRemoveProduct(false,position)
                R.id.iv_product_checked -> checkProduct(view, position)
            }
        }
    }

    /**
     * 已选中的商品
     */
    private fun getCheckedProduct() : List<Any>{
        val data = arrayListOf<Any>()
        for (i in mChecksData.indices){
            if (mChecksData[i]){
                data.add(cartAdapter.data[i])
            }
        }
        return data
    }

    /**
     * 删除商品
     */
    private fun deleteProduct(position : Int){
        val any = cartAdapter.data[position]
    }

    /**
     * 选中商品
     */
    private fun checkProduct(view : View,position : Int){
        view.isSelected = !view.isSelected
        mChecksData[position] = view.isSelected
    }

    /**
     * 商品数量 + -
     */
    private fun addRemoveProduct(isAdd : Boolean,position: Int){

    }
}