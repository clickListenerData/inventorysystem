package com.micropole.inventorysystem.ui.partnership

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_add_partner.*
import kotlinx.android.synthetic.main.view_title.*

class AddPartnerActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_add_partner

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.partner_add)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        ib_back.setOnClickListener { finish() }
        tv_sure.setOnClickListener {
            PartnerDetailActivity.startPartnerDetailActivity(this)
        }

    }
    companion object {
        fun startAddPartnerActivity(context:Context){
            var intent=Intent(context,AddPartnerActivity::class.java)
            context.startActivity(intent)
        }
    }

}
