package com.micropole.inventorysystem.ui.personal.shopmall

import android.content.Context
import android.content.Intent
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.tv_right
import com.micropole.inventorysystem.entity.AddressBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.EditAddressContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.EditAddressPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_edit_address.*
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       EditAddressActivity
 * @Description     编辑地址
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/4 8:58
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EditAddressActivity : BaseMvpActivity<EditAddressContract.Present>(),EditAddressContract.View{

    companion object {
        fun startEdit(context: Context,bean:AddressBean?){
            val intent = Intent(context, EditAddressActivity::class.java)
            intent.putExtra("is_edit",bean)
            context.startActivity(intent)
        }
    }

    var bean : AddressBean? = null
    var mDefault = 0

    override fun getActivityLayoutId(): Int = R.layout.activity_edit_address

    override fun createPresenter(): EditAddressContract.Present {
        return EditAddressPresent()
    }

    override fun initData() {
        bean= intent.getParcelableExtra<AddressBean>("is_edit")
        if (bean == null){
            setTitleText(res = R.string.add_address)
            tv_delete_address.visibility = View.GONE
        }else{
            setTitleText(res = R.string.edit_address)
            imv_input_name.setInputContent(bean!!.consignee)
            imv_input_phone.setInputContent(bean!!.phone)
            et_input_address.setText(bean!!.address)
            iv_check_default.isSelected = bean!!.is_default == "1"
        }
        tv_right.setText(R.string.save_txt)
    }

    override fun initEvent() {
        tv_delete_address.setOnClickListener {
            getPresenter().deleteAddress(bean!!.ua_id)
        }
        tv_right.setOnClickListener {
            if (bean != null){
                getPresenter().editAddress(imv_input_name.getInputContent(),imv_input_phone.getInputContent(),et_input_address.text.toString(),mDefault,bean!!.ua_id)
            }else{
                getPresenter().addAddress(imv_input_name.getInputContent(),imv_input_phone.getInputContent(),et_input_address.text.toString(),mDefault)
            }
        }
        iv_check_default.setOnClickListener {
            it.isSelected = !it.isSelected
            mDefault = if (it.isSelected) 1 else 0
        }
    }
}