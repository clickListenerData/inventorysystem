package com.micropole.inventorysystem.ui.personal.mine

import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_safety_setting.*
import kotlinx.android.synthetic.main.fragment_personal.*

/**
 * @ClassName       SafetySetActivity
 * @Description     安全性设置
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:23
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SafetySetActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_safety_setting

    override fun initData() {
        tv_title.text=getString(R.string.personal_safety_setting)
    }

    override fun initEvent() {
        nll_safety_pwd.setOnClickListener {
            SettingPWActivity.startSettingPWActivity(this)


        }
        nll_safety_phone.setOnClickListener {
            SettingPhoneActivity.startSettingPhoneActivity(this)

        }

        iv_select_auto.setOnClickListener {
            iv_select_auto.isSelected = !iv_select_auto.isSelected
        }
    }
}