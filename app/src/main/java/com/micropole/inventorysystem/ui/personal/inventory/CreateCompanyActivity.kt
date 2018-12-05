package com.micropole.inventorysystem.ui.personal.inventory

import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CreateCompanyContract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.CreateCompanyPresent
import org.devio.takephoto.model.TResult

/**
 * @ClassName       CreateCompanyActivity
 * @Description     创建公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 9:33
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CreateCompanyActivity : BaseUpImgActivity<CreateCompanyContract.Present>(),CreateCompanyContract.View {
    override fun getActivityLayoutId(): Int = R.layout.activity_create_company

    override fun createPresenter(): CreateCompanyContract.Present {
        return CreateCompanyPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.new_create_company)
    }

    override fun initEvent() {
    }

    override fun imgResult(result: TResult) {

    }
}