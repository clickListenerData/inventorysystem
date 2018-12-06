package com.micropole.inventorysystem.ui.personal.inventory.mvp.present

import com.blankj.utilcode.util.RegexUtils
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CreateCompanyContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       CreateCompanyPresent
 * @Description     创建公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/5 14:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CreateCompanyPresent : CreateCompanyContract.Present(){
    override fun editCompany(name: String, email: String, contact: String, img: String, address: String, industry: String, country: String, notice: String) {
        when{
            name.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_name_hint))
            email.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_email_hint))
            !RegexUtils.isEmail(email) -> getView()?.showToast(getView()?.getResString(R.string.company_sure_email_hint))
            contact.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_contact_hint))
            !RegexUtils.isMobileSimple(contact) -> getView()?.showToast(getView()?.getResString(R.string.company_contact_hint))
            address.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_address_hint))
            industry.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_industry_hint))
            country.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_country_hint))
            notice.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_notice_hint))
            else -> {
                if (!img.isEmpty())
                imgUp(img){s ->
                    edit(name, email, contact, s, address, industry, country, notice)
                }
                else edit(name,email,contact,getView()?.getImg() ?: "",address,industry,country,notice)
            }
        }
    }

    private fun edit(name: String, email: String, contact: String, s: String, address: String, industry: String, country: String, notice: String) {
        getModel().editCompany(name, email, contact, s, address, industry, country, notice).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.editSuccess(name, email, contact, s, address, industry, country, notice)
        }, {
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun addCompany(name: String, email: String, contact: String, img: String, address: String) {
        when{
            name.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_name_hint))
            email.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_email_hint))
            !RegexUtils.isEmail(email) -> getView()?.showToast(getView()?.getResString(R.string.company_sure_email_hint))
            contact.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_contact_hint))
            !RegexUtils.isMobileSimple(contact) -> getView()?.showToast(getView()?.getResString(R.string.company_contact_hint))
            img.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_select_img))
            address.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.company_address_hint))
            else -> {
                imgUp(img){
                    getModel().addCompany(name, email, contact, it, address).ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.showToast(it.msg)
                        getView()?.finishActivity()
                    },{
                        getView()?.dismissLoadingDialog()
                        getView()?.showToast(it)
                    })
                }
            }
        }
    }

    override fun createModel(): CreateCompanyContract.Model {
        return CreateCompanyContract.Model()
    }

    fun imgUp(img: String,action: (s :String) -> Unit){
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().imgUp(img).ui({
            action.invoke(it.data!!.imgUrl)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }
}