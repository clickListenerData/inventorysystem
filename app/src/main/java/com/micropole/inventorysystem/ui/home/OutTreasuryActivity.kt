package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.home.OutTreasuryAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_out_treasury.*
import kotlinx.android.synthetic.main.view_title.*
/**
 * @ClassName       OutTreasuryActivity
 * @Description     出库
 * @Author          肖光飞
 * @Sign            。。。
 * @Date            2018/11/19 17:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OutTreasuryActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_out_treasury

    /**
     * 初始化数据状态
     */
    var adapter=OutTreasuryAdapter(this)
    override fun initData() {
        tv_title.text=getString(R.string.shop_out)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter
        recyclerView.isNestedScrollingEnabled=false
        adapter.setNewData(arrayListOf("",""))
        recyclerView.addOnItemTouchListener(object : OnItemClickListener(){
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                OutTreasuryDetailActivity.startOutTreasuryDetailActivity(mContext)
            }

        })

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_chuangjian.setOnClickListener {
            NewBuildOrderActivity.startNewBuildOrderActivity(this)
        }
    }
    companion object {
        fun startOutTreasuryActivity(context:Context){
            var intent= Intent(context,OutTreasuryActivity::class.java)
            context.startActivity(intent)
        }
    }

}
