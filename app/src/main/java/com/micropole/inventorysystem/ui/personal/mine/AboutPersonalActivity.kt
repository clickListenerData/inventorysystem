package com.micropole.inventorysystem.ui.personal.mine

import android.text.Html
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.AboutAsBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.AboutAsContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.AboutAsPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_personal_about.*

/**
 * @ClassName       AboutPersonalActivity
 * @Description     关于我们
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:33
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AboutPersonalActivity : BaseMvpActivity<AboutAsPresent>(),AboutAsContract.View{
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter()= AboutAsPresent()

    override fun aboutAs(aboutAsBean: AboutAsBean) {

        tv_content.text= Html.fromHtml(aboutAsBean.content)

    }

    override fun getActivityLayoutId(): Int = R.layout.activity_personal_about

    override fun initData() {
        setTitleText(res = R.string.personal_mine_about)
        getPresenter().aboutas()
    }

    override fun initEvent() {
    }

}