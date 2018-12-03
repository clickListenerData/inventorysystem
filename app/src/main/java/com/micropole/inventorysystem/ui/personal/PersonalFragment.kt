package com.micropole.inventorysystem.ui.personal

import android.content.Intent
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.*
import com.xx.baseutilslibrary.extensions.startActivity
import com.micropole.inventorysystem.ui.login.LoginActivity
import com.micropole.inventorysystem.ui.personal.mine.*
import com.micropole.inventorysystem.ui.personal.shopmall.OrderListActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_personal.*

/**
 * @ClassName       PersonalFragment
 * @Description     个人中心
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalFragment : BaseMvpViewFragment() {
    override fun getFragmentLayoutId(): Int = R.layout.fragment_personal

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
        iv_news.setOnClickListener { activity?.startActivity<NewsActivity>() }
        nll_category.setOnClickListener { activity?.startActivity<CategoryActivity>() }
        nll_color.setOnClickListener { activity?.startActivity<ColorManagerActivity>() }
        nll_material.setOnClickListener { activity?.startActivity<MaterialManagerActivity>() }
        nll_company.setOnClickListener { activity?.startActivity<MineCompanyActivity>() }
        nll_finance.setOnClickListener { activity?.startActivity<FinanceActivity>() }
        nll_about_personal.setOnClickListener { activity?.startActivity<AboutPersonalActivity>() }
        nll_personal_msg.setOnClickListener { activity?.startActivity<PersonalMsgActivity>() }
        nll_feed_back.setOnClickListener { activity?.startActivity<FeedBackActivity>() }
        nll_safety.setOnClickListener { activity?.startActivity<SafetySetActivity>() }
        nll_order.setOnClickListener { activity?.startActivity<OrderListActivity>() }

        iv_share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT,"分享")
            intent.putExtra(Intent.EXTRA_TEXT,"分享")
            startActivity(Intent.createChooser(intent,"分享"))
        }

        tv_title.setOnClickListener {  LoginActivity.startLoginActivity(mContext) }
    }

    override fun initData() {
    }
}