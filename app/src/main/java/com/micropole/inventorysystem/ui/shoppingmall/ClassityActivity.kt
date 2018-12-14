package com.micropole.inventorysystem.ui.shoppingmall

import android.support.v7.widget.LinearLayoutManager
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.ClassityAdapter
import com.micropole.inventorysystem.entity.ClassityBean
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ClassityContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.ClassityPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_classity.*
import kotlinx.android.synthetic.main.fragment_personal.*

class ClassityActivity : BaseMvpActivity<ClassityPresenter>(),ClassityContract.View {
    var adapter=ClassityAdapter()
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): ClassityPresenter =ClassityPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_classity

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=resources.getString(R.string.cassity)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(mContext)
        getPresenter().classity()
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        adapter.setOnItemClickListener { adapter, view, position ->
            ClassitySearchActivity.startClassitySearchActivity(this,(adapter as ClassityAdapter).data[position].area_id)
        }
    }

    override fun classity(classityBean: List<ClassityBean>) {
        adapter.setNewData(classityBean)
    }

}
