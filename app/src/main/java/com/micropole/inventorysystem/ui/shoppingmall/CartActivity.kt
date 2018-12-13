package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.CartAdapter
import com.micropole.inventorysystem.entity.CarBean
import com.micropole.inventorysystem.entity.ConfirmOrderBean
import com.micropole.inventorysystem.entity.PositionBean
import com.micropole.inventorysystem.entity.UpdateCar
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.CarContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.CarPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.view_title.*
import java.lang.StringBuilder

/**
 * @ClassName       CartActivity
 * @Description     购物车
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 15:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CartActivity : BaseMvpActivity<CarPresent>(), CarContract.View {
    var allPrice = 0.00//计算合计金额
    override fun updateCar(updateCar: UpdateCar, position: Int, isAdd: Boolean) {
        cartAdapter.data[position].pro_num = updateCar.shopp_count
        var any = cartAdapter.data[position]
        if (cartAdapter.data[position].isChacked) {
            if (isAdd) {
                allPrice = any.pro_num.toInt() * any.pro_price.toDouble()
                sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ ${allPrice}"
            } else {
                allPrice = allPrice - any.pro_num.toInt() * any.pro_price.toDouble()
                sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ ${allPrice}"
            }
        }

        cartAdapter.notifyDataSetChanged()
    }

    override fun deleteSucceeful(msg: String, position: Int) {
        if (position == -1) {//多选删除
            if (isAll == 1) {//是否全选
                cartAdapter.setNewData(arrayListOf())
                sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ 0.00"
            } else {

                    for (i in 0..position_list.size - 1) {
                        allPrice = allPrice - cartAdapter.data[position_list[i]].pro_num.toInt() * cartAdapter.data[position_list[i]].pro_price.toDouble()
                        cartAdapter.remove(position_list[i])
                    }
                    position_list= arrayListOf()
                    sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥${allPrice}"
            }
        } else {//单选
            if (cartAdapter.data[position].isChacked) {
                allPrice = allPrice - cartAdapter.data[position].pro_num.toInt() * cartAdapter.data[position].pro_price.toDouble()
                sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ ${allPrice}"
            }
            cartAdapter.remove(position)
        }
    }

    override fun carSucceeful(cars: CarBean) {
        if (rrv_cart.isRefreshing) {
            rrv_cart.isRefreshing = false
        }
        cartAdapter.setNewData(cars.shopp)
        sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ ${allPrice}"
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter() = CarPresent()

    private val cartAdapter = CartAdapter()

    override fun getActivityLayoutId(): Int = R.layout.activity_cart

    override fun initData() {
        tv_title.text = "购物车"
        rrv_cart.mLayoutManager = LinearLayoutManager(mContext)
        rrv_cart.mAdapter = cartAdapter
        getPresenter().car()
    }

    var isAll = 0//标记是否全选
    var position_list = arrayListOf<Int>()

    override fun initEvent() {
        rrv_cart.setOnRefreshListener {
            getPresenter().car()
        }
        cb_choice.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isAllNotCheck) {
                isAllNotCheck = false
            } else {
                allPrice = 0.00
                if (isChecked) {
                    isAll = 1
                    for (i in 0..cartAdapter.data.size - 1) {
                        cartAdapter.data[i].setIsChacked(true)
                        allPrice = allPrice + cartAdapter.data[i].pro_num.toInt() * cartAdapter.data[i].pro_price.toDouble()
                    }
                } else {

                    isAll = 0
                    for (i in 0..cartAdapter.data.size - 1) {
                        cartAdapter.data[i].setIsChacked(false)
                    }
                }
                cartAdapter.notifyDataSetChanged()
                sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ ${allPrice}"
            }

        }
        tv_delete.setOnClickListener {
            var str = ""
            if (isAll == 1) {
                for (i in 0..cartAdapter.data.size - 1) {
                    if (i == 0) {
                        str = str + cartAdapter.data[i].sh_id
                    } else {
                        str = str + ",${cartAdapter.data[i].sh_id}"
                    }
                }
            } else {
                for (i in 0..cartAdapter.data.size - 1) {
                    if (cartAdapter.data[i].isChacked) {
                        if (str.isNullOrEmpty()) {
                            str = str + cartAdapter.data[i].sh_id
                        } else {
                            str = str + ",${cartAdapter.data[i].sh_id}"
                        }
                        position_list.add(i)
                    }
                }

            }
            if (str.isNullOrEmpty()) {
                showToast(resources.getString(R.string.product_tishi))
            } else {
                getPresenter().deleteCar(str, -1)
            }
        }
        cartAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.stv_delete -> deleteProduct(position)
                R.id.stv_quantity_add -> addRemoveProduct(true, position)
                R.id.stv_quantity_remove -> addRemoveProduct(false, position)
                R.id.cb_product_checked -> checkProduct(view, position)
            }
        }
        sv_sure.setOnClickListener {
            val cartId = StringBuilder()
            val nums = StringBuilder()
            for (i in cartAdapter.data.indices){
                if (cartAdapter.data[i].isChacked){
                    cartId.append("${cartAdapter.data[i].sh_id},")
                    nums.append("${cartAdapter.data[i].pro_num},")
                }
            }
            if (cartId.isNotEmpty()){
                cartId.delete(cartId.length-1,cartId.length)
                nums.delete(nums.length-1,nums.length)
                getPresenter().confirmOrder(cartId.toString(),nums.toString())
            }
        }
    }

    /**
     * 购物车下单
     */
    override fun confirmOrder(bean: ConfirmOrderBean?,cartid:String) {
        if (bean != null){
            ConfirmOrderActivity.startConfirmOrder(this,bean,cartid)
        }
    }

    /**
     * 删除商品
     */
    private fun deleteProduct(position: Int) {
        val any = cartAdapter.data[position]
        getPresenter().deleteCar(any.sh_id, position)
    }

    /**
     * 选中商品
     */
    var isAllNotCheck = false

    private fun checkProduct(view: View, position: Int) {
        view.isSelected = !view.isSelected
        if (!view.isSelected && cb_choice.isChecked == true) {
            isAllNotCheck = true
            cb_choice.isChecked = false
        }
        var any = cartAdapter.data[position]
        cartAdapter.data[position].setIsChacked(view.isSelected)
        if (cartAdapter.data[position].isChacked) {
            allPrice = allPrice + any.pro_num.toInt() * any.pro_price.toDouble()
        } else {
            allPrice = allPrice - any.pro_num.toInt() * any.pro_price.toDouble()
        }
        sv_sure.text = "${resources.getString(R.string.settlement_txt)}:¥ ${allPrice}"
    }

    /**
     * 商品数量 + -
     */
    private fun addRemoveProduct(isAdd: Boolean, position: Int) {
        val any = cartAdapter.data[position]
        var num = any.pro_num.toInt()
        if (isAdd) {
            getPresenter().updateCar(any.sh_id, "${num + 1}", position, isAdd)
        } else {
            if (num > 1) {
                getPresenter().updateCar(any.sh_id, "${num - 1}", position, isAdd)
            }
        }
    }
}