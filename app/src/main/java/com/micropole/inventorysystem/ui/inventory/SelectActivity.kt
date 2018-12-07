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
import com.micropole.inventorysystem.adapter.inventorydetail.SelectPositionAdapter
import com.micropole.inventorysystem.adapter.inventorydetail.SelectSizeAdapter
import com.micropole.inventorysystem.entity.*
import com.micropole.inventorysystem.ui.inventory.mvp.SelectContract
import com.micropole.inventorysystem.ui.inventory.mvp.present.SelectPresent
import com.micropole.inventorysystem.ui.personal.inventory.AddColorActivity
import com.micropole.inventorysystem.widght.InputDialog
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
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

    lateinit var mAdapter : BaseQuickAdapter<*,out BaseViewHolder>

    var mType = SELECT_COLOR
    val mChecks = arrayListOf<Boolean>()

    companion object {
        const val SELECT_COLOR = 0x11
        const val SELECT_SIZE = 0x12
        const val SELECT_MATERIAL = 0x13
        const val SELECT_MEMBER = 0X14
        const val SELECT_GOODS = 0X15
        const val SELECT_POSITION = 0X16    //选择职位
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
                setTitleText(res = R.string.select_color)
                tv_right.setText(R.string.new_create_color)
                mAdapter = SelectColorAdapter()
                getPresenter().colorList()
            }
            SELECT_SIZE -> {
                setTitleText(res = R.string.select_spec)
                tv_right.setText(R.string.new_create_spec)
                mAdapter = SelectSizeAdapter()
                getPresenter().specList()
            }
            SELECT_MATERIAL -> {
                setTitleText(res = R.string.select_material)
                tv_right.setText(R.string.new_create_material)
                mAdapter = SelectMaterialAdapter()
                getPresenter().materialList()
            }
            SELECT_POSITION -> {
                setTitleText(res = R.string.select_position)
                mAdapter = SelectPositionAdapter()
                getPresenter().positionList()
            }
            SELECT_MEMBER -> {
                mAdapter = DataBindAdapter<ColorBean>(1,R.layout.item_select_member)
            }
            SELECT_GOODS -> {
                mAdapter = DataBindAdapter<InventoryGoodsBean>(1, R.layout.item_inventory_goods)
            }
        }
        mAdapter.bindToRecyclerView(recycler_view)

        recycler_view.adapter = mAdapter
    }

    override fun initEvent() {

        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            view.isSelected = !view.isSelected
            checkItem(position)
        }

        tv_right.setOnClickListener {
            if (mType == SELECT_COLOR){
                startActivityForResult(Intent(this,AddColorActivity::class.java),0x10)
            }else{
                InputDialog(this,getHintS(0),getHintS(1),getHintS(2)){
                    addNewS(it)
                }.show()
            }
        }

        mAdapter.setOnItemClickListener { adapter, view, position ->
            if (mType == SELECT_POSITION){
                val intent = Intent()
                intent.putExtra("role_name",(adapter as SelectPositionAdapter).data[position].r_role)
                intent.putExtra("role_id",(adapter as SelectPositionAdapter).data[position].r_id)
                setResult(RESULT_CODE,intent)
                finish()
            }
        }
    }

    override fun afterSetContentView() {
        super.afterSetContentView()
        ib_back.setOnClickListener {
            setResult()
        }
    }

    fun addNewS(s : String){
        if(mType == SELECT_SIZE) getPresenter().addSpec(s) else if (mType == SELECT_MATERIAL) getPresenter().addMaterial(s)
    }

    fun getHintS(type:Int) : String{
        var s = ""
        when(mType){
            SELECT_SIZE -> {
                s = if (type == 0) getString(R.string.new_create_spec) else getString(R.string.new_create_spec_hint)
            }
            SELECT_MATERIAL -> s = if (type == 0) getString(R.string.new_create_material) else getString(R.string.new_create_material_hint)
        }
        return s
    }

    fun checkItem(position: Int){
        mChecks[position] = !mChecks[position]
        if (mType == SELECT_MATERIAL) {
            val selectMaterialAdapter = mAdapter as SelectMaterialAdapter
            selectMaterialAdapter.checkData[position] = !selectMaterialAdapter.checkData[position]
            mAdapter.notifyItemChanged(position)
        }
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

    override fun positionList(data: List<PositionBean>) {
        (mAdapter as SelectPositionAdapter).setNewData(data)
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
        if (data.length > 1) data.delete(data.length - 1,data.length)
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
                s = if (isId){
                    a.data[position].t_id
                }else{
                    val m = if (a.materails[position].isEmpty()) "0" else a.materails[position]
                    m + "%" + a.data[position].t_name
                }
            }
        }
        return s
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        getPresenter().colorList()
    }
}