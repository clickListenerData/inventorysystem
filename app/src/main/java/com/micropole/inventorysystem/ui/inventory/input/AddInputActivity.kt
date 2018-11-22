package com.micropole.inventorysystem.ui.inventory.input

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.AddInputAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_add_input.*

/**
 * @ClassName       AddInputActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddInputActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_add_input

    override fun initData() {
        val addInputAdapter = AddInputAdapter()
        rv_add_input.layoutManager = LinearLayoutManager(mContext)
        rv_add_input.adapter = addInputAdapter
        addInputAdapter.addHeaderView(getHeadView())
        addInputAdapter.addFooterView(getFootView())

        addInputAdapter.setNewData(arrayListOf(Any(),Any()))
    }

    override fun initEvent() {
    }

    fun getHeadView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_add_input_head, null, false)
        return view
    }

    fun getFootView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_add_input_foot, null, false)
        return view
    }
}