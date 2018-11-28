package com.micropole.inventorysystem.ui.personal.mine

import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity

/**
 * @ClassName       FeedBackActivity
 * @Description     意见反馈
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FeedBackActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_feed_back

    override fun initData() {
        setTitleText(res = R.string.personal_feed_back)
    }

    override fun initEvent() {
    }
}