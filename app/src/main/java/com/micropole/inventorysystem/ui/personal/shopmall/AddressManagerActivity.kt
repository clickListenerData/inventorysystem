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
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       AddressManagerActivity
 * @Description     管理收货地址
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 17:46
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddressManagerActivity : BaseMvpActivity<AddressManagerContract.Present>(),AddressManagerContract.View{

    lateinit var adapter : DataBindAdapter<AddressBean>

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun createPresenter(): AddressManagerContract.Present {
        return AddressManagerPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.personal_address_manager)
        tv_right.setText(R.string.add_address)
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        adapter = DataBindAdapter(1,R.layout.item_address_view)
        recycler_view.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        getPresenter().addressList()
    }

    override fun initEvent() {
        tv_right.setOnClickListener {
            EditAddressActivity.startEdit(this,null)
        }

        adapter.setOnItemClickListener { adapter, view, position ->
            EditAddressActivity.startEdit(this,(adapter as DataBindAdapter<AddressBean>).data[position])
        }
    }

    override fun addressList(data: List<AddressBean>) {
        adapter.setNewData(data)
    }
}