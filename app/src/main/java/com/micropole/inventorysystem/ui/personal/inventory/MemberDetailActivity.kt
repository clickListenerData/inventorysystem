package com.micropole.inventorysystem.ui.personal.inventory

import android.databinding.DataBindingUtil
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.databinding.ActivityMemberDetailBinding
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity

/**
 * @ClassName       MemberDetailActivity
 * @Description     成员详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberDetailActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId() : Int{
        DataBindingUtil.setContentView<ActivityMemberDetailBinding>(this,R.layout.activity_member_detail)
        return -1
    }

    override fun initData() {
        setTitleText(res = R.string.member_detail_txt)
    }

    override fun initEvent() {

    }
}