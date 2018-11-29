package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.home.InTreasuryDetailAdapter
import com.micropole.inventorysystem.ui.inventory.input.EditGoodsActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
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
        val mtype = intent.getIntExtra("treasury_detail_type", TYPE_IN)
        tv_title.text="sfsfsfs"
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.isNestedScrollingEnabled=false
        recyclerView.adapter=adapter
        adapter.setNewData(arrayListOf("",""))

        when(mtype){
            TYPE_IN -> {
                ll_share_print.visibility = View.GONE
                stv_btn_one.visibility = View.VISIBLE
                stv_btn_two.visibility = View.VISIBLE
            }
            TYPE_OUT -> {
                ll_share_print.visibility = View.GONE
                stv_btn_one.visibility = View.VISIBLE
                stv_btn_two.visibility = View.VISIBLE
            }
            TYPE_DETAIL -> {

            }
        }
//        imv_remark_in.setInputColor(Color.parseColor("#"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity<EditGoodsActivity>()
        }
    }
    companion object {
        const val TYPE_IN = 0X11
        const val TYPE_OUT = 0X12
        const val TYPE_DETAIL = 0X13
        fun startInTreasuryDetailActivity(context: Context,type : Int){
            val intent= Intent(context,InTreasuryDetailActivity::class.java)
            intent.putExtra("treasury_detail_type",type)
            context.startActivity(intent)
        }
    }

}
