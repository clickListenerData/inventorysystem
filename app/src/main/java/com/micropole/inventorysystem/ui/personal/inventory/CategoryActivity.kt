package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.CategoryPresent
import kotlinx.android.synthetic.main.activity_news.*

/**
 * @ClassName       CategoryActivity
 * @Description     分类管理
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CategoryActivity : BaseRefreshActivity<CategoryBean,CategoryConstract.Present>(),CategoryConstract.View {
    override fun loadData(page: Int) {
        getPresenter().getCategoryList()
    }

    override fun initRv() {
        refresh?.isEnabled = false
        setTitleText(res = R.string.personal_category_manager)
        tv_right.text = mContext.getText(R.string.new_create_category)
        recyclerView?.addItemDecoration(DividerItemDecoration(mContext,LinearLayoutManager.VERTICAL))
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_category_view))
    }

    override fun createPresenter(): CategoryConstract.Present = CategoryPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_news

    override fun getData(data: List<CategoryBean>) {
        setData(data)
    }
}