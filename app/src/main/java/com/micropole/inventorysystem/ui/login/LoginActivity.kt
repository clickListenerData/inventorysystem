package com.micropole.inventorysystem.ui.login

import android.content.Context
import android.content.Intent
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.login.mvp.contract.LoginContract
import com.micropole.inventorysystem.ui.login.mvp.presenter.LoginPresenter
import com.micropole.inventorysystem.util.addFocusListener
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @ClassName       LoginActivity
 * @Description     登录
 * @Author          xiaoguangfei
 * @Sign            。。。
 * @Date            2018/11/19 17:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class LoginActivity : BaseMvpActivity<LoginContract.Presenter>(),LoginContract.View {
    override fun getActivityLayoutId(): Int = R.layout.activity_login

    override fun initData() {
//        setTitleText(res = R.string.)
    }

    override fun createPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }

    override fun initEvent() {
        et_phone.addFocusListener(view_phone_line)
        et_pw.addFocusListener(view_pwd_line)
        tv_register.setOnClickListener {
            RegisterActivity.startRegisterActivity(this)
        }
        tv_forget.setOnClickListener {
            ForgetActivity.startForgetActivity(this)
        }

        tv_login.setOnClickListener {
            getPresenter().login(et_phone.text.toString(),et_pw.text.toString())
        }
    }
    companion object {
        fun startLoginActivity(context:Context){
            var intent=Intent(context,LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

}