package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.CartAdapter
import com.micropole.inventorysystem.entity.CarBean
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.CarContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.present.CarPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
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
class CartActivity : BaseMvpActivity<CarPresent>(),CarContract.View{
    override fun carSucceeful(cars: CarBean) {
        if (rrv_cart.isRefreshing){
            rrv_cart.isRefreshing=false
        }
        cartAdapter.setNewData(cars.shopp)
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter()= CarPresent()

    private var mChecksData = arrayListOf<Boolean>()
    private val cartAdapter = CartAdapter()

    override fun getActivityLayoutId(): Int  = R.layout.activity_cart

    override fun initData() {
        rrv_cart.mLayoutManager = LinearLayoutManager(mContext)
        rrv_cart.mAdapter = cartAdapter
        getPresenter().car()
    }

    override fun initEvent() {
        rrv_cart.setOnRefreshListener {
            getPresenter().car()
        }
        cartAdapter.setOnItemChildClickListener { adapter, view, position ->
            when(view.id){
                R.id.stv_delete -> deleteProduct(position)
                R.id.stv_quantity_add -> addRemoveProduct(true,position)
                R.id.stv_quantity_remove -> addRemoveProduct(false,position)
                R.id.cb_product_checked -> checkProduct(view, position)
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