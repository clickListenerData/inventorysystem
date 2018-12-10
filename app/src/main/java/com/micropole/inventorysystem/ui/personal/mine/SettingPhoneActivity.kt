package com.micropole.inventorysystem.ui.personal.mine

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.micropole.baseapplibrary.appconst.Constants
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.SettingPhoneContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.SettingPhonePresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_setting_phone.*
import kotlinx.android.synthetic.main.fragment_personal.*
/**
* @ClassName       SettingPhoneActivity
* @Description     设计手机号码
* @Author          xiaoguangfei
* @Sign            。。。
* @Date            2018/11/22 10:23
* @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
*/
class SettingPhoneActivity : BaseMvpActivity<SettingPhonePresent>(),SettingPhoneContract.View {
    private var time = 60//验证码时间
    private var times = 60//验证码时间
    var index=1
    private var mHandler : Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what==1){
                time--
                if (time > 0) {
                    tv_old_code.setText(time.toString() + " s")
                    tv_old_code.setEnabled(false)
                    sendEmptyMessageDelayed(1,1000)
                } else {
                    tv_old_code.setText("重新获取")
                    time = 10
                    tv_old_code.setEnabled(true)
                }
            }else{
                times--
                if (times > 0) {
                    tv_new_Code.setText(times.toString() + " s")
                    tv_new_Code.setEnabled(false)
                    sendEmptyMessageDelayed(2,1000)
                } else {
                    tv_new_Code.setText("重新获取")
                    times = 10
                    tv_new_Code.setEnabled(true)
                }
            }

        }
    }
    override fun getCode() {
        if (index==1){
            mHandler.sendEmptyMessage(1)
        }else{
            mHandler.sendEmptyMessage(2)
        }

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter()= SettingPhonePresent()

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
        Log.i("short",Constants.getShotToken())
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_old_code.setOnClickListener {
            index=1
            getPresenter().getCode(et_old_phone.text.toString())

        }
        tv_new_Code.setOnClickListener {
            index=2
            getPresenter().getCode(et_phone_new.text.toString())

        }
        tv_banding.setOnClickListener {
            getPresenter().settingPhone(et_old_phone.text.toString(),et_phone_new.text.toString(),et_code_new.text.toString(),et_old_code.text.toString())
        }

    }
    companion object {
        fun startSettingPhoneActivity(context:Context){
            var intent=Intent(context,SettingPhoneActivity::class.java)
            context.startActivity(intent)
        }
    }

}
