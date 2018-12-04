package com.micropole.inventorysystem.ui.login

import android.content.Context
import android.content.Intent
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.ib_back
import com.micropole.inventorysystem.R.id.tv_title
import com.micropole.inventorysystem.ui.login.mvp.contract.FotgetContract
import com.micropole.inventorysystem.ui.login.mvp.presenter.ForgetPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_forget.*
import kotlinx.android.synthetic.main.view_title.*
/**
* @ClassName       ForgetActivity
* @Description     忘记密码
* @Author          xiaoguangfei
* @Sign            。。。
* @Date            2018/11/22 11:10
* @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
*/
class ForgetActivity : BaseMvpActivity<FotgetContract.Presenter>(),FotgetContract.View {
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
        tv_get_code.setOnClickListener { getPresenter().sendSMS(et_phone.text.toString()) }

        tv_sure.setOnClickListener {
            if (et_pw.text.toString() == et_sure_pw.text.toString()){
                getPresenter().forgetPwd(et_phone.text.toString(),et_code.text.toString(),et_pw.text.toString())
            }else{
                showToast(getString(R.string.reg_tsure_pw))
            }
        }
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_forget

    override fun createPresenter(): FotgetContract.Presenter {
        return ForgetPresenter()
    }
    companion object {
        fun startForgetActivity(context: Context){
            var intent=Intent(context,ForgetActivity::class.java)
            context.startActivity(intent)
        }
    }

}
