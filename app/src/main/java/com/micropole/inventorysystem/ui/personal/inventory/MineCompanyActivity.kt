package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.GridLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.BtnBean
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_mine_company.*

/**
 * @ClassName       MineCompanyActivity
 * @Description     我的公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 16:29
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCompanyActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_mine_company

    override fun initData() {
        setTitleText(res = R.string.personal_mine_company)
        initBtn()
    }

    private fun initBtn() {
        rv_company_btn.layoutManager = GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false)
        val dataBindAdapter = DataBindAdapter<BtnBean>(1, R.layout.item_company_btn)
        rv_company_btn.adapter = dataBindAdapter

        dataBindAdapter.setNewData(arrayListOf(BtnBean(R.drawable.ic_viewmembers_n, getString(R.string.company_btn_look)),
                BtnBean(R.drawable.ic_moreinformation_n, getString(R.string.company_btn_update)),
                BtnBean(R.drawable.ic_leave_n, getString(R.string.company_btn_leave)),
                BtnBean(R.drawable.ic_jointhecompany_n, getString(R.string.company_btn_add)),
                BtnBean(R.drawable.ic_transferthepossessionof_n, getString(R.string.company_btn_transfer))
        ))

        dataBindAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> {startActivity<MemberListActivity>()}   //查看成员列表
                1 -> {}
                2 -> {}
                3 -> {}
                4 -> {}
            }
        }
    }

    override fun initEvent() {
    }
}