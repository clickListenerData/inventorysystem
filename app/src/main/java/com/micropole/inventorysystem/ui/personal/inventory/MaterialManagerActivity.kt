package com.micropole.inventorysystem.ui.personal.inventory

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.MaterialBean
import com.micropole.inventorysystem.ui.personal.inventory.mvp.MaterialConstract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.MaterialPresent
import com.micropole.inventorysystem.widght.InputDialog
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       MaterialManagerActivity
 * @Description     材质库
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 15:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MaterialManagerActivity : BaseRefreshActivity<MaterialBean.TextureListBean,MaterialConstract.Present>(),MaterialConstract.View{

    var mPosition = 0
    override fun loadData(page: Int) {
        getPresenter().getMaterialList()
    }

    override fun initRv() {
        setTitleText(res = R.string.personal_material_bank)
        tv_right.text = mContext.getText(R.string.new_create_material)
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_material_view,2))
    }

    override fun initEvent() {
        super.initEvent()
        adapter?.setOnItemChildClickListener { adapter, view, position ->
            mPosition = position
            getPresenter().deleteMaterial((adapter as DataBindAdapter<MaterialBean.TextureListBean>).data[position].t_id)
        }
        tv_right.setOnClickListener {
            InputDialog(this,getString(R.string.new_create_material),getString(R.string.new_create_material_hint),getString(R.string.new_create_material_hint)){
                getPresenter().addMaterial(it)
            }.show()
        }
    }

    override fun createPresenter(): MaterialConstract.Present = MaterialPresent()

    override fun getActivityLayoutId(): Int  = R.layout.activity_refresh_recy

    override fun getData(data: MaterialBean) {
        setData(data.texture_list)
    }

    override fun deleteSuccess() {
        adapter?.remove(mPosition)
    }
}