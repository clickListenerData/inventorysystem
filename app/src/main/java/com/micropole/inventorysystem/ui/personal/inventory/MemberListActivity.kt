package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.personal.MemberListAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_member_list.*

/**
 * @ClassName       MemberListActivity
 * @Description     成员列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/23 16:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberListActivity : BaseMvpViewActivity(){

    lateinit var adapter : MemberListAdapter

    override fun getActivityLayoutId(): Int = R.layout.activity_member_list

    override fun initData() {
        setTitleText(res = R.string.member_list_txt)

        rv_member_list.layoutManager = LinearLayoutManager(mContext)
        adapter = MemberListAdapter()
        rv_member_list.adapter = adapter
    }

    override fun initEvent() {

        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity<MemberDetailActivity>()
        }

        stv_add_member.setOnClickListener {
            startActivity<AddMemberActivity>()
        }
    }


}