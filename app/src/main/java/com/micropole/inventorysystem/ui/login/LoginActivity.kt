package com.micropole.inventorysystem.ui.login

import android.content.Context
import android.content.Intent
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       LoginActivity
 * @Description     登录
 * @Author          xiaoguangfei
 * @Sign            。。。
 * @Date            2018/11/19 17:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class LoginActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_login

    override fun initData() {
    }

    override fun initEvent() {
        ib_back.setOnClickListener { finish() }
        tv_register.setOnClickListener {
            RegisterActivity.startRegisterActivity(this)
        }
        tv_forget.setOnClickListener {
            ForgetActivity.startForgetActivity(this)
        }

    }
    companion object {
        fun startLoginActivity(context:Context){
            var intent=Intent(context,LoginActivity::class.java)
            context.startActivity(intent)

        }
    }

}