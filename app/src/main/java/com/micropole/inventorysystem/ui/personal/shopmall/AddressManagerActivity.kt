package com.micropole.inventorysystem.ui.personal.shopmall

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.AddressBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.AddressManagerContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.AddressManagerPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
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

    companion object {
        fun startAddressManager(context: Activity,type:Int){
            val intent = Intent(context, AddressManagerActivity::class.java)
            intent.putExtra("address_type",type)
            context.startActivityForResult(intent,0x11)
        }
    }

    lateinit var adapter : DataBindAdapter<AddressBean>
    var mType = 0

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun createPresenter(): AddressManagerContract.Present {
        return AddressManagerPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.personal_address_manager)
        tv_right.setText(R.string.add_address)
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        adapter = DataBindAdapter(1,R.layout.item_address_view, 2)
        recycler_view.adapter = adapter
        mType = intent.getIntExtra("address_type",mType)
    }

    override fun onResume() {
        super.onResume()
        getPresenter().addressList()
    }

    override fun initEvent() {
        tv_right.setOnClickListener {
            EditAddressActivity.startEdit(this,null)
        }

        adapter.setOnItemChildClickListener { adapter, view, position ->
            EditAddressActivity.startEdit(this,(adapter as DataBindAdapter<AddressBean>).data[position])
        }

        adapter.setOnItemClickListener { adapter, view, position ->
            if (mType != 0){
                setResult((adapter as DataBindAdapter<AddressBean>).data[position])
            }
        }
    }

    fun setResult(bean : AddressBean){
        val intent = Intent()
        intent.putExtra("address_bean",bean)
        setResult(0x12,intent)
        finish()
    }

    override fun addressList(data: List<AddressBean>) {
        adapter.setNewData(data)
    }
}