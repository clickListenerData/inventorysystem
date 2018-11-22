package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.home.InTreasuryAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_in_treasury.*
import kotlinx.android.synthetic.main.view_title.*
/**
* @ClassName       InTreasuryActivity
* @Description     入库
* @Author          肖光飞
* @Sign            。。。
* @Date            2018/11/19 17:47
* @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
*/
class InTreasuryActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int=R.layout.activity_in_treasury

    /**
     * 初始化数据状态
     */
    var adapter= InTreasuryAdapter(this)
    override fun initData() {
        tv_title.text=getString(R.string.shop_in)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        recyclerView.isNestedScrollingEnabled=false
        adapter.setNewData(arrayListOf("",""))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }
    companion object {
        fun startInTreasuryActivity(context:Context){
            var intent=Intent(context,InTreasuryActivity::class.java)
            context.startActivity(intent)
        }
    }

}
