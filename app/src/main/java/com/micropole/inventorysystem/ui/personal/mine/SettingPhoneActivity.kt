package com.micropole.inventorysystem.ui.personal.mine

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.fragment_personal.*

class SettingPhoneActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_setting_phone

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.safety_phone_setting)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }
    companion object {
        fun startSettingPhoneActivity(context:Context){
            var intent=Intent(context,SettingPhoneActivity::class.java)
            context.startActivity(intent)
        }
    }

}
