package com.micropole.inventorysystem.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       RegisterActivity
 * @Description     注册
 * @Author          xiaoguagnfei
 * @Sign            。。。
 * @Date            2018/11/19 17:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class RegisterActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_register

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.reg_register)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        ib_back.setOnClickListener { finish() }
    }
    companion object {
        fun startRegisterActivity(context:Context){
            var intent=Intent(context,RegisterActivity::class.java)
            context.startActivity(intent)
        }
    }

}
