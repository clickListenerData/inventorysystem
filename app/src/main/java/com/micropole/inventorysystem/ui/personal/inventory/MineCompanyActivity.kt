package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.GridLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ColorBean
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_mine_company.*

/**
 * @ClassName       MineCompanyActivity
 * @Description     我的公司
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 16:29
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCompanyActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_mine_company

    override fun initData() {
        rv_company_btn.layoutManager = GridLayoutManager(mContext,3,GridLayoutManager.VERTICAL,false)
        val dataBindAdapter = DataBindAdapter<ColorBean>(1, R.layout.item_company_btn)
        rv_company_btn.adapter = dataBindAdapter

        dataBindAdapter.setNewData(arrayListOf(ColorBean(), ColorBean(), ColorBean(), ColorBean(),ColorBean()))
    }

    override fun initEvent() {
    }
}