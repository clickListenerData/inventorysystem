package com.micropole.inventorysystem.ui.inventory.input

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.*
import com.micropole.inventorysystem.adapter.AddInputAdapter
import com.micropole.inventorysystem.entity.GoodsDetailBean
import com.micropole.inventorysystem.ui.inventory.mvp.AddInputContract
import com.micropole.inventorysystem.ui.inventory.mvp.present.AddInputPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_add_input.*
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       AddInputActivity
 * @Description     新增入库
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddInputActivity : BaseMvpActivity<AddInputContract.Present>(),AddInputContract.View {

    companion object {
        fun startAddInput(context: Context,id:String,isAdd:Boolean = false){
            val intent = Intent(context, AddInputActivity::class.java)
            intent.putExtra("goods_id",id)
            intent.putExtra("goods_is_add",isAdd)
            context.startActivity(intent)
        }
    }

    lateinit var addInputAdapter: AddInputAdapter

    override fun getActivityLayoutId(): Int = R.layout.activity_add_input

    override fun createPresenter(): AddInputContract.Present {
        return AddInputPresent()
    }

    override fun initData() {
        tv_title.setText(R.string.new_add_treasury)
        val isAdd = intent.getBooleanExtra("goods_is_add", false)
        val id = intent.getStringExtra("goods_id")
        addInputAdapter = AddInputAdapter()
        rv_add_input.layoutManager = LinearLayoutManager(mContext)
        rv_add_input.adapter = addInputAdapter
        addInputAdapter.addHeaderView(getHeadView())
        if (isAdd){
            tv_right.setText(R.string.save_txt)
            addInputAdapter.addFooterView(getFootView())
        }

        getPresenter().goodsDetail(id)
    }

    override fun initEvent() {
        tv_right.setOnClickListener {  }
    }

    fun getHeadView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_add_input_head, null, false)
        return view
    }

    fun getFootView() : View{
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_add_input_foot, null, false)
        return view
    }

    override fun goodsDetail(bean: GoodsDetailBean?) {
        addInputAdapter.setNewData(bean?.product?.prodinfo)
    }
}