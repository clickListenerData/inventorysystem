package com.micropole.inventorysystem.ui.shoppingmall

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.micropole.baseapplibrary.appconst.Constants
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.SearchShopAdapter
import com.micropole.inventorysystem.entity.SearchBean
import com.micropole.inventorysystem.entity.SearchPotuct
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.SearchShopContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.SearchShopPresenter
import com.micropole.inventorysystem.util.SpaceItemDecoration
import com.micropole.inventorysystem.util.SpaceItemDecorationNoHander
import com.micropole.inventorysystem.util.initMagic
import com.micropole.inventorysystem.widght.FlowLayout
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_search_shop.*
import kotlinx.android.synthetic.main.view_title.*
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator


/**
 * @ClassName       SearchShopActivity
 * @Description     搜索
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 17:43
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SearchShopActivity : BaseMvpActivity<SearchShopPresenter>(),SearchShopContract.View {
    var titleList= arrayListOf("价格","热度","最新")
    var adapter=SearchShopAdapter()
    override fun searchProduct(searchPotuct: SearchPotuct) {
        adapter.setNewData(searchPotuct.product)
    }

    override fun hotSeacrh(hotSearchBean: SearchBean) {
        if (hotSearchBean.hot_keys.size!=0){
            for (i in 0..hotSearchBean.hot_keys.size-1){
                setTextView(fl_search_hot,hotSearchBean.hot_keys[i].key_name)
            }

        }
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter()=SearchShopPresenter()

    override fun getActivityLayoutId(): Int = R.layout.activity_search_shop
    override fun initData() {
        et_search.clearFocus()
        Log.i("ddddddd",Constants.getShotToken())
        rv_search.layoutManager=GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        rv_search.adapter=adapter
        rv_search.isNestedScrollingEnabled=false
        rv_search.addItemDecoration(SpaceItemDecorationNoHander())
        getPresenter().hotSearch()
        getPresenter().searchProduct("","1")
        tv_title.text=resources.getString(R.string.search)
        fl_search_history.removeAllViews()
        var str=Constants.getSearch_his().split(",")
        if (str.size>1){
            for (i in 0..str.size-2){
                setTextView(fl_search_history,str[str.size-2-i])
            }
        }
    }

    override fun initEvent() {
        et_search.setOnEditorActionListener { v, actionId, event ->
            if (actionId== EditorInfo.IME_ACTION_SEARCH){
                if (et_search.text.isNullOrEmpty()){
                    showToast("请输入内容")
                }else{
                fl_search_history.removeAllViews()
                Constants.putSearch_his(Constants.getSearch_his()+et_search.text.toString()+",")
                var str=Constants.getSearch_his().split(",")
                if (str.size>1){
                    for (i in 0..str.size-2){
                        setTextView(fl_search_history,str[str.size-2-i])
                    }
                }
                    getPresenter().searchProduct(et_search.text.toString(),dsc)
                return@setOnEditorActionListener true
                }


            }
            return@setOnEditorActionListener false
        }
        iv_search_del.setOnClickListener {
            fl_search_history.removeAllViews()
            Constants.putSearch_his("")
        }
        magic_search.initMagic(titleList){
            view, index ->
            magic_search.onPageSelected(index)
            when(index){
                0->{
                    dsc="1"
                    getPresenter().searchProduct(select,dsc)
                }
                1->{
                    dsc="3"
                    getPresenter().searchProduct(select,dsc)
                }
                2->{
                    dsc="5"
                    getPresenter().searchProduct(select,dsc)
                }
            }
        }
        adapter.setOnItemClickListener { adapter, view, position ->
            ProductDetailActivity.startProductDetail(mContext,(adapter as SearchShopAdapter).data[position].pro_id)
        }
    }
    var select=""//关键字选择的
    var dsc="1"//1为价格搞，3为热度,5为最新
    fun setTextView(flow: FlowLayout, text:String){
        var textView= TextView(this)
        textView.textSize=13f
        textView.text=text
        textView.setTextColor(resources.getColor(R.color.text_edit_hint))
        textView.setBackgroundDrawable(resources.getDrawable(R.drawable.select_drawable_txt))
        textView.setPadding(ConvertUtils.dp2px(10f), ConvertUtils.dp2px(4f), ConvertUtils.dp2px(10f), ConvertUtils.dp2px(4f))
        var param= LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        param.leftMargin= ConvertUtils.dp2px(16f)
        param.topMargin= ConvertUtils.dp2px(10f)
        textView.layoutParams=param
        flow.addView(textView)
//        if (flow == fl_search_hot){
//            fl_search_history.removeAllViews()
//        }else{
//            fl_search_hot.removeAllViews()
//        }
        textView.setOnClickListener {
            for (i in 0..flow.childCount-1){
                flow.getChildAt(i).isSelected=false
                (flow.getChildAt(i) as TextView).setTextColor(resources.getColor(R.color.text_edit_hint))
            }
            textView.isSelected=true
            select=text
            textView.setTextColor(resources.getColor(R.color.text_color_white))
            getPresenter().searchProduct(text,dsc)
        }
    }

}