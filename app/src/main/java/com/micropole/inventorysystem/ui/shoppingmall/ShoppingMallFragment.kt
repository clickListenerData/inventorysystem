package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.micropole.baseapplibrary.appconst.Constants
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.ShopMallAdapter
import com.micropole.inventorysystem.entity.ShopMall
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ShoppingMallContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.ShoppingMallPresenter
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecFragment
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_mine_company.*
import kotlinx.android.synthetic.main.fragment_shop_mall.*
import kotlinx.android.synthetic.main.view_login_out.*
import okhttp3.OkHttpClient

/**
 * @ClassName       ShoppingMallFragment
 * @Description     商城
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:51
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ShoppingMallFragment : BaseMvpLcecFragment<View, List<ShopMall>, ShoppingMallContract.Model, ShoppingMallContract.View, ShoppingMallContract.Presenter>(), ShoppingMallContract.View {
    /**
     * 加载数据
     *
     * @param refresh 是否是刷新数据
     */
    override fun loadData(refresh: Boolean) {
       presenter.shopMall("1","1")
    }


    /**
     * 填充数据
     *
     * @param data 数据
     */
    override fun setData(data: List<ShopMall>?) {
        showContent()
        if (rrv_shop_mall.isRefreshing){
            shopMallAdapter.setNewData(data)
            rrv_shop_mall.isRefreshing=false
        }else if (shopMallAdapter.isLoading){
            shopMallAdapter.addData(data!!)
            shopMallAdapter.loadMoreComplete()
        }else{
            shopMallAdapter.setNewData(data)
        }
        if (data!!.size==0){
            shopMallAdapter.loadMoreEnd()
        }
        dismissLoadingDialog()
    }

    /**
     * 获取Presenter
     *
     * @return Presenter
     */
    override fun createPresenter()=ShoppingMallPresenter()



    val shopMallAdapter = ShopMallAdapter()

    override fun getFragmentLayoutId(): Int = R.layout.fragment_shop_mall
    override fun initData() {
        rrv_shop_mall.mLayoutManager = LinearLayoutManager(mContext)
        rrv_shop_mall.mAdapter = shopMallAdapter
        rrv_shop_mall.setRefreshLoadMoreListener {
            presenter.shopMall(""+it,"1")
        }
        loading()
    }

    override fun initEvent(view: View?) {
        iv_cart.setOnClickListener { activity?.startActivity<CartActivity>() }
        iv_search.setOnClickListener { activity?.startActivity<SearchShopActivity>() }
        sv_classity.setOnClickListener {
            activity?.startActivity<ClassityActivity>()
        }
        rg_des.setOnCheckedChangeListener { group, checkedId ->
            showLoadingDialog(getResString(R.string.loading))
            if (checkedId==rb_shop_price.id){

                presenter.shopMall("1","1")
            }else if (checkedId==rb_shop_hot.id){
                presenter.shopMall("1","4")
            }else{
                presenter.shopMall("1","5")
            }
        }
    }

    fun loading(){
        if (!Constants.isLogin()){
            showView(null)
        }else{
            fl_login_out.visibility = View.GONE
            showLoading()
            loadData(true)
        }

    }

}