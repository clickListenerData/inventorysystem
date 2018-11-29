package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.personal.MemberListAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_add_member.*

/**
 * @ClassName       AddMemberActivity
 * @Description     邀请成员
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 9:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddMemberActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_add_member

    override fun initData() {
        setTitleText(res = R.string.add_new_member)
        rv_member_list.layoutManager = LinearLayoutManager(mContext)
        val memberListAdapter = MemberListAdapter()
        rv_member_list.adapter = memberListAdapter
        memberListAdapter.setNewData(arrayListOf(Any()))
    }

    override fun initEvent() {
    }
}