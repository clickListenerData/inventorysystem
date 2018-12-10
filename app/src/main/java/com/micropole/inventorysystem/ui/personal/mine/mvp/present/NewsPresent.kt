package com.micropole.inventorysystem.ui.personal.mine.mvp.present

import com.micropole.inventorysystem.entity.NewsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.NewsContract

/**
 * @ClassName       NewsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 11:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewsPresent : NewsContract.Presenter() {
    override fun createModel(): NewsContract.Model {
        return NewsContract.Model()
    }

    override fun getNewsList(){
        getView()?.getData(arrayListOf(NewsBean(), NewsBean(),NewsBean()))
    }
}