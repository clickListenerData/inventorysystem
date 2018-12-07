package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.rv_member_list
import com.micropole.inventorysystem.R.id.stv_add_member
import com.micropole.inventorysystem.adapter.personal.MemberListAdapter
import com.micropole.inventorysystem.entity.MemberListBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MemberListContract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.MemberListPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
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
class MemberListActivity : BaseMvpActivity<MemberListContract.Present>(),MemberListContract.View{

    lateinit var adapter : MemberListAdapter

    override fun getActivityLayoutId(): Int = R.layout.activity_member_list

    override fun createPresenter(): MemberListContract.Present {
        return MemberListPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.member_list_txt)

        rv_member_list.layoutManager = LinearLayoutManager(mContext)
        adapter = MemberListAdapter()
        rv_member_list.adapter = adapter
        adapter.bindToRecyclerView(rv_member_list)
        getPresenter().memberList()
    }

    override fun initEvent() {

        adapter.setOnItemClickListener { adapter, view, position ->
            MemberDetailActivity.startMemberDetail(this,id = this@MemberListActivity.adapter.data[position].user_id)
        }

        stv_add_member.setOnClickListener {
            startActivity<AddMemberActivity>()
        }
    }

    override fun memberList(data: List<MemberListBean>) {
        adapter.setEmptyView(R.layout.view_empty,rv_member_list)
        adapter.setListData(data)
    }


}