package com.micropole.inventorysystem.ui.personal.shopmall

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CollectBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.MineCollectContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.MineCollectPresent
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity

/**
 * @ClassName       MineCollectActivity
 * @Description     收藏 足迹
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 16:00
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineCollectActivity : BaseRefreshActivity<CollectBean,MineCollectContract.Present>(),MineCollectContract.View {

    companion object {
        fun startMineCollect(context: Context,type:Int){
            val intent = Intent(context,MineCollectActivity::class.java)
            intent.putExtra("collect_type",type)
            context.startActivity(intent)
        }
    }

    var mType = 0

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_recy

    override fun createPresenter(): MineCollectContract.Present {
        return MineCollectPresent()
    }

    override fun loadData(page: Int) {
        if (mType == 0)
        getPresenter().collectList()
        else
            getPresenter().footList()
    }

    override fun initRv() {
        mType = intent.getIntExtra("collect_type",mType)
        if (mType == 0) setTitleText(res = R.string.personal_mine_collect) else setTitleText(res = R.string.personal_mine_foot)
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1,R.layout.item_collect_view))
    }
}