package com.micropole.inventorysystem.ui.personal.mine

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.FeedBackContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.FeedBackPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_feed_back.*

/**
 * @ClassName       FeedBackActivity
 * @Description     意见反馈
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FeedBackActivity : BaseMvpActivity<FeedBackPresent>(),FeedBackContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): FeedBackPresent = FeedBackPresent()


    override fun getActivityLayoutId(): Int = R.layout.activity_feed_back

    override fun initData() {
        setTitleText(res = R.string.personal_feed_back)
    }

    override fun initEvent() {
        st_sure.setOnClickListener {
            getPresenter().feedback(et_content.text.toString())
        }
    }
}