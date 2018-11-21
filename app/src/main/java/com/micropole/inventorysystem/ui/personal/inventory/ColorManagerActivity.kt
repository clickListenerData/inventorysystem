package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.ColorConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.ColorPresent
import kotlinx.android.synthetic.main.activity_news.*

/**
 * @ClassName       ColorManagerActivity
 * @Description     颜色管理
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:38
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ColorManagerActivity : BaseRefreshActivity<ColorBean,ColorConstract.Present>(),ColorConstract.View{
    override fun loadData(page: Int) {
        getPresenter().getColorList()
    }

    override fun initRv() {
        setTitleText(res = R.string.personal_color_manager)
        tv_right.text = mContext.getString(R.string.new_create_color)
        recyclerView?.addItemDecoration(DividerItemDecoration(mContext,LinearLayoutManager.VERTICAL))
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_color_view))
    }

    override fun createPresenter(): ColorConstract.Present = ColorPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_news

    override fun getData(data: List<ColorBean>) {
        setData(data)
    }
}