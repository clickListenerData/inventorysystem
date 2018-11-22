package com.micropole.inventorysystem.ui.login

import android.content.Context
import android.content.Intent
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.view_title.*

class ForgetActivity : BaseMvpViewActivity() {
    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.reg_forget)

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        ib_back.setOnClickListener { finish() }
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_forget
    companion object {
        fun startForgetActivity(context: Context){
            var intent=Intent(context,ForgetActivity::class.java)
            context.startActivity(intent)
        }
    }

}
