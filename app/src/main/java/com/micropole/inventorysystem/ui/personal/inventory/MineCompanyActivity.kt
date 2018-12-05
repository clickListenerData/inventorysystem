package com.micropole.inventorysystem.ui.personal.inventory

import android.content.Context
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.BtnBean
import com.micropole.inventorysystem.entity.UserInfoBean
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.loadImag
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_mine_company.*
import kotlinx.android.synthetic.main.view_not_company.*

/**
 * @ClassName       MineCompanyActivity
 * @Description     我的公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 16:29
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCompanyActivity : BaseMvpViewActivity() {

    companion object {
        fun startMineCompany(context: Context,bean : UserInfoBean){
            val intent = Intent(context, MineCompanyActivity::class.java)
            intent.putExtra("have_company",bean)
            context.startActivity(intent)
        }
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_mine_company

    override fun initData() {
        setTitleText(res = R.string.personal_mine_company)
        val bean = intent.getSerializableExtra("have_company") as UserInfoBean
        if (bean.company == null){
            view_mine_company.visibility = View.GONE
            view_not_company.visibility = View.VISIBLE
        }else{
            setInfo(bean)
            initBtn()
        }
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
        stv_create_company.setOnClickListener {
            startActivity<CreateCompanyActivity>()
        }
    }

    fun setInfo(userInfoBean: UserInfoBean){
        val companyBean = userInfoBean.company
        iv_company_img.loadImag(companyBean.company_img,plach = R.drawable.ic_nothing_n,error = R.drawable.ic_nothing_n,radio = 12)
        tv_company_fzr.text = userInfoBean.user.nickname
        tv_company_id.text = "ID:${companyBean.company_id}"
        tv_company_name.text = getString(R.string.company_name_txt,companyBean.company_name)
        imv_fzr.setInputContent(companyBean.company_name)
        imv_phone.setInputContent(companyBean.company_contact)
        imv_email.setInputContent(companyBean.company_postbox)
        imv_industry.setInputContent(companyBean.company_industry)
        imv_country.setInputContent(companyBean.company_nationality)
        imv_address.setInputContent(companyBean.company_address)
        tv_announcement.text = companyBean.company_notice
    }
}