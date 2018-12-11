package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.tv_title
import com.micropole.inventorysystem.adapter.home.InTreasuryAdapter
import com.micropole.inventorysystem.entity.TreasuryBean
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.micropole.inventorysystem.ui.home.mvp.presenter.InTreasuryPresenter
import com.micropole.inventorysystem.ui.inventory.input.GoodsInputActivity
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_in_treasury.*
import kotlinx.android.synthetic.main.view_title.*
/**
* @ClassName       InTreasuryActivity
* @Description     入库
* @Author          xiaoguangfei
* @Sign            。。。
* @Date            2018/11/19 17:47
* @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
*/
class InTreasuryActivity : BaseMvpActivity<InTreasuryContract.Presenter>(),InTreasuryContract.View {

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int=R.layout.activity_in_treasury

    var mCurrentPage = 1

    override fun createPresenter(): InTreasuryContract.Presenter {
        return InTreasuryPresenter()
    }

    /**
     * 初始化数据状态
     */
    var adapter= InTreasuryAdapter()
    override fun initData() {
        tv_title.text=getString(R.string.shop_in)

        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        recyclerView.isNestedScrollingEnabled=false
        getPresenter().treasuryList(1,mCurrentPage)
        /*recyclerView.addOnItemTouchListener(object : OnItemClickListener(){
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                InTreasuryDetailActivity.startInTreasuryDetailActivity(mContext,InTreasuryDetailActivity.TYPE_IN)
            }
        })*/
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        //tv_chuangjian.setOnClickListener { startActivity<GoodsInputActivity>() }

        adapter.setOnLoadMoreListener({
            //getPresenter().treasuryList(1,++mCurrentPage)
        },recyclerView)

        swipe_refresh.setOnRefreshListener {
            //mCurrentPage = 1
            //getPresenter().treasuryList(1,mCurrentPage)
        }
    }

    override fun treasuryList(bean: TreasuryBean?) {
        if (bean != null){
            ccv_treasury.setBottomTxtContent(bean.order_num)
            ccv_treasury_count.setBottomTxtContent(bean.or_price)
            if (adapter.isLoading){

            }else{

            }
        }
    }

    companion object {
        fun startInTreasuryActivity(context:Context){
            var intent=Intent(context,InTreasuryActivity::class.java)
            context.startActivity(intent)
        }
    }

}
