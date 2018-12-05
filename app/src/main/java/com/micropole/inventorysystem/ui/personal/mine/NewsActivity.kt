package com.micropole.inventorysystem.ui.personal.mine

import android.support.v7.widget.LinearLayoutManager
import com.micropole.baseapplibrary.recyclerview.BaseRefreshActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.personal.NewsAdapter
import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.NewsContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.NewsPresent
import kotlinx.android.synthetic.main.activity_news.*

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
        setTitleText(res = R.string.personal_notice_txt)
        setRvLa(LinearLayoutManager(mContext),NewsAdapter(rv_delete))
    }

    override fun getData(data: List<NewsBean>) {
        setData(data)
    }
}