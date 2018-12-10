package com.micropole.inventorysystem.ui.personal.mine

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.SettingPWContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.SettingPhonePresent
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.SettingPwPresent
import com.micropole.inventorysystem.util.md5
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_setting_pw.*
import kotlinx.android.synthetic.main.fragment_personal.*
/**
 * @ClassName       SettingPWActivity
 * @Description     设置密码
 * @Author          xiaoguangfei
 * @Sign            。。。
 * @Date            2018/11/22 10:23
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SettingPWActivity : BaseMvpActivity<SettingPwPresent>(),SettingPWContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SettingPwPresent = SettingPwPresent()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_setting_pw

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.safety_pwd_setting)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_sure.setOnClickListener {
            Log.i("old_pw",et_pw.text.toString().md5() )
            Log.i("new_pw",et_new_pw.text.toString().md5())
            Log.i("sure_pw",et_sure_pw.text.toString().md5())
            getPresenter().settingPW(et_pw.text.toString(),et_new_pw.text.toString(),et_sure_pw.text.toString())
        }
    }

    companion object {
        fun startSettingPWActivity(context: Context){
            var intent= Intent(context,SettingPWActivity::class.java)
            context.startActivity(intent)
        }
    }

}
