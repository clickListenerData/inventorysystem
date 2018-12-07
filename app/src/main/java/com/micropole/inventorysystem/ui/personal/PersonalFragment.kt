package com.micropole.inventorysystem.ui.personal

import android.content.Intent
import android.view.View
import com.micropole.baseapplibrary.appconst.Constants
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.UserInfoBean
import com.micropole.inventorysystem.ui.personal.inventory.*
import com.xx.baseutilslibrary.extensions.startActivity
import com.micropole.inventorysystem.ui.login.LoginActivity
import com.micropole.inventorysystem.ui.personal.mine.*
import com.micropole.inventorysystem.ui.personal.mvp.PersonalContract
import com.micropole.inventorysystem.ui.personal.mvp.PersonalPresenter
import com.micropole.inventorysystem.ui.personal.shopmall.OrderListActivity
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecFragment
import com.xx.baseutilslibrary.extensions.loadImag
import kotlinx.android.synthetic.main.fragment_personal.*
import kotlinx.android.synthetic.main.view_login_out.*

/**
 * @ClassName       PersonalFragment
 * @Description     个人中心
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalFragment : BaseMvpLcecFragment<View, UserInfoBean,PersonalContract.Model,PersonalContract.View,PersonalContract.Presenter>(),PersonalContract.View {

    override fun getFragmentLayoutId(): Int = R.layout.fragment_personal

    override fun createPresenter(): PersonalContract.Presenter {
        return PersonalPresenter()
    }

    override fun loadData(refresh: Boolean) {
        presenter.userInfo()
    }

    override fun initEvent(view: View?) {
        iv_news.setOnClickListener { activity?.startActivity<NewsActivity>() }
        nll_category.setOnClickListener { activity?.startActivity<CategoryActivity>() }
        nll_color.setOnClickListener { activity?.startActivity<ColorManagerActivity>() }
        nll_material.setOnClickListener { activity?.startActivity<MaterialManagerActivity>() }
        nll_finance.setOnClickListener { activity?.startActivity<FinanceActivity>() }
        nll_about_personal.setOnClickListener { activity?.startActivity<AboutPersonalActivity>() }
        nll_personal_msg.setOnClickListener {
            PersonalMsgActivity.startPersonalMsgActivity(mContext,userInfo.user.nickname,userInfo.user.user_sex,userInfo.user.user_birthday,userInfo.user.user_img)
        }
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

        stv_login.setOnClickListener {  LoginActivity.startLoginActivity(mContext) }
        tv_login_out.setOnClickListener {
            Constants.loginOut()
            LoginActivity.startLoginActivity(mContext)
        }
    }

    override fun initData() {

    }

    override fun onResume() {
        super.onResume()
        if (!Constants.isLogin()){
            showView(null)
        }else{
            fl_login_out.visibility = View.GONE
            showLoading()
            loadData(true)
        }
    }
     lateinit var userInfo:UserInfoBean
    override fun setData(data: UserInfoBean?) {
        userInfo=data!!
        showContent()
        iv_personal_img.loadImag(data?.user?.user_img,plach = R.drawable.ic_nothing_n,error = R.drawable.ic_nothing_n,radio = 12)
        tv_personal_name.text = data?.user?.nickname
        tv_personal_phone.text = data?.user?.user_phone
        if (data?.company?.company_name.isNullOrEmpty()){
            tv_personal_company.setText(R.string.not_company)
        }else{
            iv_personal_company.loadImag(data?.company?.company_img,plach = R.drawable.ic_nothing_n,error = R.drawable.ic_nothing_n,radio = 12)
            tv_personal_company.text = data?.company?.company_name
        }
        nll_company.setOnClickListener { MineCompanyActivity.startMineCompany(mContext,data!!) }
    }
}