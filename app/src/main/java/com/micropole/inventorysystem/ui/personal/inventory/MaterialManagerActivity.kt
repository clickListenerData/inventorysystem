package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.MaterialBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MaterialConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.MaterialPresent
import kotlinx.android.synthetic.main.activity_news.*

/**
 * @ClassName       MaterialManagerActivity
 * @Description     材质库
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 15:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MaterialManagerActivity : BaseRefreshActivity<MaterialBean,MaterialConstract.Present>(),MaterialConstract.View{
    override fun loadData(page: Int) {
        getPresenter().getMaterialList()
    }

    override fun initRv() {
        setTitleText(res = R.string.personal_material_bank)
        tv_right.text = mContext.getText(R.string.new_create_material)
        recyclerView?.addItemDecoration(DividerItemDecoration(mContext,LinearLayoutManager.VERTICAL))
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_material_view))
    }

    override fun createPresenter(): MaterialConstract.Present = MaterialPresent()

    override fun getActivityLayoutId(): Int  = R.layout.activity_news

    override fun getData(data: List<MaterialBean>) {
        setData(data)
    }
}