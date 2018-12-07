package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.rv_member_list
import com.micropole.inventorysystem.adapter.personal.MemberListAdapter
import com.micropole.inventorysystem.entity.InvitationBean
import com.micropole.inventorysystem.entity.MemberListBean
import com.micropole.inventorysystem.entity.SearchMemberBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.AddMemberContract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.AddMemberPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
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
class AddMemberActivity : BaseMvpActivity<AddMemberContract.Present>(),AddMemberContract.View {

    val memberListAdapter = MemberListAdapter()

    override fun getActivityLayoutId(): Int = R.layout.activity_add_member

    override fun createPresenter(): AddMemberContract.Present = AddMemberPresent()

    override fun initData() {
        setTitleText(res = R.string.add_new_member)
        rv_member_list.layoutManager = LinearLayoutManager(mContext)
        rv_member_list.adapter = memberListAdapter
        memberListAdapter.bindToRecyclerView(rv_member_list)
    }

    override fun onResume() {
        super.onResume()
        getPresenter().memberList()
    }

    override fun initEvent() {
        stv_sure.setOnClickListener {
            getPresenter().searchMember(et_input_phone.text.toString())
        }

        memberListAdapter.setOnItemClickListener { adapter, view, position ->
            MemberDetailActivity.startMemberDetail(this,id = memberListAdapter.data[position].user_id)
        }
    }

    override fun memberList(data: InvitationBean) {
        tv_member_size.text = getString(R.string.invitation_member) + (data.count)
        memberListAdapter.setEmptyView(R.layout.view_empty,rv_member_list)
        memberListAdapter.setListData(data.user_list)
    }

    override fun getMember(bean: SearchMemberBean) {
        if (bean.user_phone.isNullOrEmpty()){
            showToast(getString(R.string.no_search_result))
        }else{
            MemberDetailActivity.startMemberDetail(this,bean)
        }
    }
}