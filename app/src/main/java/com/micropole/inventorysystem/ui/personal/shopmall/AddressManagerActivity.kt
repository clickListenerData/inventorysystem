package com.micropole.inventorysystem.ui.personal.shopmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.AddressBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.AddressManagerContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.AddressManagerPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_refresh_recy.*

/**
 * @ClassName       AddressManagerActivity
 * @Description     管理收货地址
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 17:46
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddressManagerActivity : BaseMvpActivity<AddressManagerContract.Present>(),AddressManagerContract.View{
    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun createPresenter(): AddressManagerContract.Present {
        return AddressManagerPresent()
    }

    override fun initData() {
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        recycler_view.adapter = DataBindAdapter<AddressBean>(1,R.layout.item_address_view)
    }

    override fun initEvent() {
    }

    override fun addressList(data: List<AddressBean>) {

    }
}