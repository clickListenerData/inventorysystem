package com.micropole.inventorysystem.ui.personal.inventory

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.blankj.utilcode.util.EncodeUtils
import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.UserInfoBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CreateCompanyContract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.CreateCompanyPresent
import com.xx.baseutilslibrary.extensions.loadImag
import kotlinx.android.synthetic.main.activity_create_company.*
import org.devio.takephoto.model.TResult
import java.io.File

/**
 * @ClassName       CreateCompanyActivity
 * @Description     创建公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 9:33
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CreateCompanyActivity : BaseUpImgActivity<CreateCompanyContract.Present>(),CreateCompanyContract.View {

    companion object {
        fun startCreateCompany(context: Activity,bean:UserInfoBean.CompanyBean?){
            val intent = Intent(context, CreateCompanyActivity::class.java)
            intent.putExtra("company_type",bean)
            context.startActivityForResult(intent,0x30)
        }
    }

    var mImgs = ""
    var mCreate = true
    var bean : UserInfoBean.CompanyBean? = null

    override fun getActivityLayoutId(): Int = R.layout.activity_create_company

    override fun createPresenter(): CreateCompanyContract.Present {
        return CreateCompanyPresent()
    }

    override fun initData() {
        val bean = intent.getSerializableExtra("company_type")
        setTitleText(res = if (bean == null) R.string.new_create_company else R.string.edit_company_msg)
        if (bean != null){
            stv_create.setText(R.string.save_txt)
            mCreate = false
            setCompanyBean(bean as UserInfoBean.CompanyBean)
        }
    }

    override fun initEvent() {
        ll_company_img.setOnClickListener { showChooseDialog() }
        stv_create.setOnClickListener {
            if (mCreate) getPresenter().addCompany(imv_company_name.getInputContent(),imv_company_email.getInputContent(),imv_company_contact.getInputContent(),
                    mImgs,imv_company_address.getInputContent())
            else getPresenter().editCompany(imv_company_name.getInputContent(),imv_company_email.getInputContent(),imv_company_contact.getInputContent(),
                    mImgs,imv_company_address.getInputContent(),imv_company_industry.getInputContent(),/*nll_select_country.getCustomTxt()*/"11",
                    imv_company_notice.getInputContent())
        }
    }

    override fun imgResult(result: TResult) {
        iv_company_img.setImageURI(Uri.fromFile(File(result.images[0].compressPath)))
        mImgs = EncodeUtils.base64Encode2String(File(result.images[0].compressPath).readBytes())
    }

    fun setCompanyBean(bean : UserInfoBean.CompanyBean){
        this.bean = bean
        iv_company_img.loadImag(bean.company_img,plach = R.drawable.ic_cover_n,error = R.drawable.ic_cover_n,radio = 12)
        imv_company_name.setInputContent(bean.company_name)
        imv_company_email.setInputContent(bean.company_postbox)
        imv_company_contact.setInputContent(bean.company_contact)
        imv_company_address.setInputContent(bean.company_address)
        imv_company_industry.setInputContent(bean.company_industry)
        nll_select_country.setCustomTxt(bean.company_nationality)
        imv_company_notice.setInputContent(bean.company_notice)
    }

    override fun getImg(): String {
        return bean?.company_img ?: ""
    }

    override fun editSuccess(name:String,email:String,contact:String,img:String,address:String,industry:String,country:String,notice:String) {
        if (img.isNotEmpty()){
            bean?.company_img = img
        }
        bean?.company_name = name
        bean?.company_postbox = email
        bean?.company_contact = contact
        bean?.company_address = address
        bean?.company_industry = industry
        bean?.company_nationality = country
        bean?.company_notice = notice
        val intent = Intent()
        intent.putExtra("company_bean",bean)
        setResult(0x40,intent)
        finish()
    }
}