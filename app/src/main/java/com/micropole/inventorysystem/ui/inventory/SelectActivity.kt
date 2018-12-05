package com.micropole.inventorysystem.ui.inventory

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.recycler_view
import com.micropole.inventorysystem.adapter.inventorydetail.SelectColorAdapter
import com.micropole.inventorysystem.adapter.inventorydetail.SelectMaterialAdapter
import com.micropole.inventorysystem.adapter.inventorydetail.SelectSizeAdapter
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.entity.InventoryGoodsBean
import com.micropole.inventorysystem.entity.MaterialBean
import com.micropole.inventorysystem.entity.SpecBean
import com.micropole.inventorysystem.ui.inventory.mvp.SelectContract
import com.micropole.inventorysystem.ui.inventory.mvp.present.SelectPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_refresh_recy.*
import kotlinx.android.synthetic.main.view_title.*
import java.text.FieldPosition

/**
 * @ClassName       SelectActivity
 * @Description     选择属性 颜色，规格，材质，销售成员,商品
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 16:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectActivity  : BaseMvpActivity<SelectContract.Present>(),SelectContract.View{

    lateinit var mAdapter : BaseQuickAdapter<out Any,out BaseViewHolder>

    var mType = SELECT_COLOR
    val mChecks = arrayListOf<Boolean>()

    companion object {
        const val SELECT_COLOR = 0x11
        const val SELECT_SIZE = 0x12
        const val SELECT_MATERIAL = 0x13
        const val SELECT_MEMBER = 0X14
        const val SELECT_GOODS = 0X15
        const val REQUEST_CODE = 0X20
        const val RESULT_CODE = 0X21

        fun startSelect(context: Activity,type : Int){
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("type_select",type)
            context.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun createPresenter(): SelectContract.Present {
        return SelectPresent()
    }

    override fun initData() {
        mType = intent.getIntExtra("type_select", mType)
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        when(mType){
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
            SELECT_GOODS -> {
                mAdapter = DataBindAdapter<InventoryGoodsBean>(1, R.layout.item_inventory_goods)
            }
        }

        recycler_view.adapter = mAdapter
    }

    override fun initEvent() {

        ib_back.setOnClickListener {
            setResult()
        }

        (mAdapter as BaseQuickAdapter<Any,BaseViewHolder>).setNewData(arrayListOf(Any(), Any(), Any()))

        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            view.isSelected = !view.isSelected
            checkItem(position)
        }
    }

    fun checkItem(position: Int){
        mChecks[position] = !mChecks[position]
        if (mType == SELECT_MATERIAL) {
            val selectMaterialAdapter = mAdapter as SelectMaterialAdapter
            selectMaterialAdapter.checkData[position] = !selectMaterialAdapter.checkData[position]
        }
        mAdapter.notifyItemChanged(position)
    }

    override fun colorList(bean: ColorBean) {
        for (i in bean.color_list.indices){
            mChecks.add(false)
        }
        (mAdapter as SelectColorAdapter).setListData(bean.color_list)
    }

    override fun materialList(bean: MaterialBean) {
        val selectMaterialAdapter = mAdapter as SelectMaterialAdapter
        for (i in bean.texture_list.indices){
            selectMaterialAdapter.checkData.add(false)
            mChecks.add(false)
            selectMaterialAdapter.materails.add("")
        }
        selectMaterialAdapter.setListData(bean.texture_list)
    }

    override fun specList(bean: SpecBean) {
        for (i in bean.spec_list.indices){
            mChecks.add(false)
        }
        (mAdapter as SelectSizeAdapter).setListData(bean.spec_list)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            setResult()
        }
        return super.onKeyDown(keyCode, event)
    }

    fun setResult(){
        val intent = Intent()
        intent.putExtra("select_type",mType)
        intent.putExtra("select_content", getData(false))
        intent.putExtra("select_id", getData(true))
        setResult(RESULT_CODE,intent)
        finish()
    }

    fun getData(isId : Boolean) : String{
        val data = StringBuffer()
        for (i in mChecks.indices){
            if (mChecks[i]){
                val s = if (isId) "," else "/"
                data.append(getContent(isId,i)+s)
            }
        }
        data.delete(data.length - 1,data.length)
        return data.toString()
    }

    fun getContent(isId : Boolean,position: Int) : String{
        var s = ""
        when(mType){
            SELECT_COLOR -> {
               s =  if(isId)(mAdapter as SelectColorAdapter).data[position].c_id else (mAdapter as SelectColorAdapter).data[position].c_color
            }
            SELECT_SIZE -> {
                s = if (isId) (mAdapter as SelectSizeAdapter).data[position].spec_id else (mAdapter as SelectSizeAdapter).data[position].spec_name
            }
            SELECT_MATERIAL -> {
                val a = mAdapter as SelectMaterialAdapter
                if (isId){
                    s = a.data[position].t_id
                }else{
                    s = a.materails[position] + "%" + a.data[position].t_name
                }
            }
        }
        return s
    }
}