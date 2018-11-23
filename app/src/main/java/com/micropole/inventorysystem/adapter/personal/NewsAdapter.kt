package com.micropole.inventorysystem.adapter.personal

import android.support.v4.widget.SlidingPaneLayout
import android.util.Log
import android.view.View
import com.micropole.baseapplibrary.adapter.DataBindAdapter
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.NewsBean

/**
 * @ClassName       NewsAdapter
 * @Description     侧滑菜单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/23 11:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewsAdapter : DataBindAdapter<NewsBean>(1, R.layout.item_news_view) {

    var open = false
    set(value) {
        field = value
        init = false
        notifyDataSetChanged()
    }

    var init = false

    override fun convert(helper: DataBindViewHolder?, item: NewsBean) {
        super.convert(helper, item)
        val view = helper?.getView<SlidingPaneLayout>(R.id.slid_layout)
        view?.setPanelSlideListener(listener)
        if (helper?.adapterPosition == data.size - 1){
            init = true
        }
        if (open){
            view?.openPane()
        }else{
            view?.closePane()
        }
    }

    var listener = object : SlidingPaneLayout.SimplePanelSlideListener() {
        override fun onPanelOpened(panel: View) {
            super.onPanelOpened(panel)
            if (!open && init)open = true
            Log.i("news_open","1::" + open.toString())
        }

        override fun onPanelClosed(panel: View) {
            super.onPanelClosed(panel)
            if (open && init)open = false
            Log.i("news_open","2::" + open.toString())
        }
    }
}