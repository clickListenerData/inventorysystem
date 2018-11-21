package com.micropole.inventorysystem.ui.personal.mine

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.baseapplibrary.appconst.setListData
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.NewsContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.NewsPresent

/**
 * @ClassName       NewsActivity
 * @Description     消息
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:39
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewsActivity : BaseRefreshActivity<NewsBean,NewsContract.Presenter>(),NewsContract.View{
    override fun loadData(page: Int) {
        getPresenter().getNewsList()
    }

    override fun createPresenter(): NewsContract.Presenter = NewsPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_news

    override fun initRv() {
        setRvLa(LinearLayoutManager(mContext),DataBindAdapter(1, R.layout.item_news_view))
    }

    override fun getData(data: List<NewsBean>) {
        setData(data)
    }
}