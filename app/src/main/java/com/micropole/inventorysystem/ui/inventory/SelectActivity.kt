package com.micropole.inventorysystem.ui.inventory

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.inventorydetail.SelectColorAdapter
import com.micropole.inventorysystem.adapter.inventorydetail.SelectMaterialAdapter
import com.micropole.inventorysystem.adapter.inventorydetail.SelectSizeAdapter
import com.micropole.inventorysystem.entity.ColorBean
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_refresh_recy.*

/**
 * @ClassName       SelectActivity
 * @Description     选择属性 颜色，规格，材质，销售成员
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 16:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectActivity  : BaseMvpViewActivity(){

    lateinit var mAdapter : BaseQuickAdapter<out Any,out BaseViewHolder>

    companion object {
        const val SELECT_COLOR = 0x11
        const val SELECT_SIZE = 0x12
        const val SELECT_MATERIAL = 0x13
        const val SELECT_MEMBER = 0X14

        fun startSelect(context: Activity,type : Int){
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("type_select",type)
            context.startActivityForResult(intent,0x15)
        }
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun initData() {
        val mtype = intent.getIntExtra("type_select", SELECT_COLOR)
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        when(mtype){
            SELECT_COLOR -> {
                mAdapter = SelectColorAdapter()
            }
            SELECT_SIZE -> {
                mAdapter = SelectSizeAdapter()
            }
            SELECT_MATERIAL -> {
                mAdapter = SelectMaterialAdapter()
            }
            SELECT_MEMBER -> {
                mAdapter = DataBindAdapter<ColorBean>(1,R.layout.item_select_member)
            }
        }

        recycler_view.adapter = mAdapter
    }

    override fun initEvent() {

        (mAdapter as BaseQuickAdapter<Any,BaseViewHolder>).setNewData(arrayListOf(Any(), Any(), Any()))
    }
}