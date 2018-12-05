package com.micropole.inventorysystem.ui.personal.inventory

import android.content.Intent
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.BR
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ColorBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.ColorConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.ColorPresent
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       ColorManagerActivity
 * @Description     颜色管理
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 14:38
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ColorManagerActivity : BaseRefreshActivity<ColorBean.ColorListBean,ColorConstract.Present>(),ColorConstract.View{

    var mPosition = 0

    override fun loadData(page: Int) {
        getPresenter().getColorList()
    }

    override fun initRv() {
        setTitleText(res = R.string.personal_color_manager)
        tv_right.text = mContext.getString(R.string.new_create_color)
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_color_view,2))
    }

    override fun initEvent() {
        super.initEvent()
        tv_right.setOnClickListener {
            startActivityForResult(Intent(this,AddColorActivity::class.java),0x10)
        }

        adapter?.setOnItemChildClickListener { adapter, view, position ->
            mPosition = position
            getPresenter().deleteColor((adapter as DataBindAdapter<ColorBean.ColorListBean>).data[position].c_id)
        }
    }

    override fun createPresenter(): ColorConstract.Present = ColorPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun deleteSuccess() {
        adapter?.remove(mPosition)
    }

    override fun getData(data: ColorBean) {
        setData(data.color_list)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        onRefresh()
    }
}