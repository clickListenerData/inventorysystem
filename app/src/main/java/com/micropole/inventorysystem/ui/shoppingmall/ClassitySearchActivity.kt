package com.micropole.inventorysystem.ui.shoppingmall

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.inputmethod.EditorInfo
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.SearchShopAdapter
import com.micropole.inventorysystem.entity.SearchPotuct
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ClassitySearchContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.ClassitySearchPresenter
import com.micropole.inventorysystem.util.SpaceItemDecorationNoHander
import com.micropole.inventorysystem.util.initMagic
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_classity_search.*
import kotlinx.android.synthetic.main.fragment_personal.*

class ClassitySearchActivity : BaseMvpActivity<ClassitySearchPresenter>(),ClassitySearchContract.View {
    override fun searchProduct(searchPotuct: SearchPotuct) {
        adapter.setNewData(searchPotuct.product)
    }

    var titleList= arrayListOf("价格","热度","最新")
    var dsc="1"
    var select=""
    var adapter= SearchShopAdapter()

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): ClassitySearchPresenter =ClassitySearchPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId()=R.layout.activity_classity_search

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=resources.getString(R.string.cassity_sel)
        rv_search.layoutManager=GridLayoutManager(mContext,2,GridLayoutManager.VERTICAL,false)
        rv_search.addItemDecoration(SpaceItemDecorationNoHander())
        rv_search.adapter=adapter
        rv_search.isNestedScrollingEnabled=false
        Log.i("area_id",intent.getStringExtra("area_id"))
        Log.i("select",select)
        Log.i("dsc",dsc)
        getPresenter().searchProduct(select,dsc,intent.getStringExtra("area_id"))
        magic_search.initMagic(titleList){
            view, index ->
            magic_search.onPageSelected(index)
            when(index){
                0->{
                    dsc="1"
                    getPresenter().searchProduct(select,dsc,intent.getStringExtra("area_id"))
            }
                1->{
                    dsc="3"
                    getPresenter().searchProduct(select,dsc,intent.getStringExtra("area_id"))
                }
                2->{
                    dsc="5"
                    getPresenter().searchProduct(select,dsc,intent.getStringExtra("area_id"))
                }
            }
        }

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        adapter.setOnItemClickListener { adapter, view, position ->
            ProductDetailActivity.startProductDetail(mContext,(adapter as SearchShopAdapter).data[position].pro_id)

        }
        et_search.setOnEditorActionListener { v, actionId, event ->
            if (actionId==EditorInfo.IME_ACTION_SEARCH){
                select=et_search.text.toString()
                getPresenter().searchProduct(select,dsc,intent.getStringExtra("area_id"))
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }
    companion object {
        fun startClassitySearchActivity(context: Context,area_id:String){
            var intent=Intent(context,ClassitySearchActivity::class.java)
            intent.putExtra("area_id",area_id)
            context.startActivity(intent)
        }
    }

}
