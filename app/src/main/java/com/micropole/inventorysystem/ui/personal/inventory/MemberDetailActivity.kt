package com.micropole.inventorysystem.ui.personal.inventory

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.databinding.ActivityMemberDetailBinding
import com.micropole.inventorysystem.entity.SearchMemberBean
import com.micropole.inventorysystem.ui.inventory.SelectActivity
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MemberDetailContract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.MemberDetailPresent
import com.micropole.inventorysystem.widght.InputDialog
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity

/**
 * @ClassName       MemberDetailActivity
 * @Description     成员详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:09
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MemberDetailActivity : BaseMvpLcecActivity<View,SearchMemberBean?,MemberDetailContract.Model,MemberDetailContract.View,MemberDetailContract.Present>(),MemberDetailContract.View {

    companion object {
        fun startMemberDetail(context: Context,bean : SearchMemberBean? = null,id: String = ""){
            val intent = Intent(context, MemberDetailActivity::class.java)
            intent.putExtra("detail_bean",bean)
            intent.putExtra("detail_id",id)
            context.startActivity(intent)
        }
    }

    var bean : SearchMemberBean? = null
    var mIsAdd = true

    override fun loadData(refresh: Boolean) {

    }

    lateinit var databind : ActivityMemberDetailBinding

    override fun getActivityLayoutId() : Int{
        databind = DataBindingUtil.setContentView(this, R.layout.activity_member_detail)
        return -1
    }

    override fun createPresenter(): MemberDetailContract.Present = MemberDetailPresent()

    override fun initData() {
        super.initData()
        setTitleText(res = R.string.member_detail_txt)
        val bean = intent.getParcelableExtra<SearchMemberBean>("detail_bean")
        if (bean == null){
            mIsAdd = false
            val id = intent.getStringExtra("detail_id")
            presenter.getMember(id)
        }else{
            showContent()
            setData(bean)
            setBtn()
        }
    }

    fun setBtn(){
        databind.stvBtn.solid = resources.getColor(R.color.txt_out)
        databind.stvBtn.setText(R.string.add_member)
    }

    override fun initEvent() {
        databind.setListener {
            when(it.id){
                R.id.nll_remark_name -> {
                    InputDialog(mContext,getString(R.string.input_remark_hint),getString(R.string.input_remark_hint),getString(R.string.input_remark_hint)){
                        databind.nllRemarkName.setCustomTxt(it)
                    }.show()
                }
                R.id.nll_company_position -> {
                    SelectActivity.startSelect(this,SelectActivity.SELECT_POSITION)
                }
                R.id.stv_btn -> {
                    if (mIsAdd)
                    presenter.addMember(bean?.user_phone,bean?.user_nationality,bean?.user_birthday,databind.nllRemarkName.getCustomTxt()
                            ,databind.nllCompanyPosition.getCustomTxt(),bean?.user_id,bean?.user_email)
                    else
                        presenter.removeMember(bean!!.user_id)
                }
            }
        }
    }

    override fun setData(data: SearchMemberBean?) {
        showContent()
        bean = data
        databind.data = data
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SelectActivity.REQUEST_CODE && resultCode == SelectActivity.RESULT_CODE){
            val s = data?.getStringExtra("role_name") ?: ""
            databind.nllCompanyPosition.setCustomTxt(s)
        }
    }
}