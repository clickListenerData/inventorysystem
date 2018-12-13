package com.micropole.inventorysystem.ui.personal.inventory

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.flyco.dialog.widget.ActionSheetDialog
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.personal.BottomListDialog
import com.micropole.inventorysystem.entity.CategoryBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.CategoryConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.CategoryPresent
import com.micropole.inventorysystem.widght.InputDialog
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       CategoryActivity
 * @Description     分类管理  选择分类  选择分类下商品
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CategoryActivity : BaseRefreshActivity<CategoryBean.AreaListBean,CategoryConstract.Present>(),CategoryConstract.View {

    companion object {
        const val TYPE_MANAGER = 0X10
        const val TYPE_SELECT = 0X11
        const val TYPE_SELECT_GOODS = 0X12
        fun startCategory(activity : Activity,type : Int){
            val intent = Intent(activity, CategoryActivity::class.java)
            intent.putExtra("category_type",type)
            if (type == TYPE_SELECT){
                activity.startActivityForResult(intent,0x11)
            }else{
                activity.startActivity(intent)
            }
        }
    }

    var mtype = TYPE_MANAGER

    var mPosition = 0
    var mId = ""

    override fun loadData(page: Int) {
        getPresenter().getCategoryList()
    }

    override fun initRv() {
        mtype = intent.getIntExtra("category_type",mtype)
        setTitleText(res = R.string.personal_category_manager)
        tv_right.text = mContext.getText(R.string.new_create_category)
        recyclerView?.addItemDecoration(DividerItemDecoration(mContext,LinearLayoutManager.VERTICAL))
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_category_view))
    }

    override fun initEvent() {
        super.initEvent()
        adapter?.setOnItemClickListener { adapter, view, position ->
            when(mtype){
                TYPE_MANAGER -> {
                    mPosition = position
                    mId = (adapter as DataBindAdapter<CategoryBean.AreaListBean>).data[position].area_id
                    showRenameDialog()
                }
                TYPE_SELECT -> {
                    val intent = Intent()
                    intent.putExtra("category_name",(adapter as DataBindAdapter<CategoryBean.AreaListBean>).data[position].area_name)
                    intent.putExtra("category_id",(adapter).data[position].area_id)
                    setResult(0x12,intent)
                    finish()
                }
                TYPE_SELECT_GOODS -> {

                }
            }
        }

        tv_right.setOnClickListener {
            InputDialog(this,getString(R.string.new_create_category),getString(R.string.new_create_category_hint),getString(R.string.input_category_hint)){
                getPresenter().addCategory(it)
            }.show()
        }
    }

    override fun createPresenter(): CategoryConstract.Present = CategoryPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun getData(data: CategoryBean) {
        setData(data.area_list)
    }

    override fun addSuccess(name: String) {
        onRefresh()
    }

    override fun editSuccess(id: String, name: String) {
        val areaListBean = (adapter as DataBindAdapter<CategoryBean.AreaListBean>).data[mPosition]
        areaListBean.area_name = name
        adapter?.notifyItemChanged(mPosition)
    }

    override fun deleteSuccess() {
        adapter?.remove(mPosition)
    }

    fun showRenameDialog(){
        val actionSheetDialog = ActionSheetDialog(this, BottomListDialog(resources.getStringArray(R.array.category_btn_list)), null)
        actionSheetDialog.isTitleShow(false)
        actionSheetDialog.cancelText(Color.parseColor("#007AFF"))
        actionSheetDialog.setOnOperItemClickL { parent, view, position, id ->
            if (position == 0){
                InputDialog(this,getString(R.string.edit__category),getString(R.string.input_category_hint),getString(R.string.input_category_hint)){
                    getPresenter().editCategory(mId,it)
                }.show()
            }else if (position == 1){
                getPresenter().deleteCategory(mId)
            }
            actionSheetDialog.dismiss()
        }
        actionSheetDialog.show()
    }
}