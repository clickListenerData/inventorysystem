package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.home.InTreasuryDetailAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_in_treasury_detail.*
import kotlinx.android.synthetic.main.view_title.*
/**
 * @ClassName       InTreasuryDetailActivity
 * @Description     入库详情
 * @Author          xiaoguangfei
 * @Sign            。。。
 * @Date            2018/11/19 17:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class InTreasuryDetailActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_in_treasury_detail

    /**
     * 初始化数据状态
     */
    var adapter=InTreasuryDetailAdapter()
    override fun initData() {
        tv_title.text="sfsfsfs"
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.isNestedScrollingEnabled=false
        recyclerView.adapter=adapter
        adapter.setNewData(arrayListOf("",""))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }
    companion object {
        fun startInTreasuryDetailActivity(context: Context){
            var intent= Intent(context,InTreasuryDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

}
