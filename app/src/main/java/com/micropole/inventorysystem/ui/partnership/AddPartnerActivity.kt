package com.micropole.inventorysystem.ui.partnership

import android.content.Context
import android.content.Intent
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_add_partner.*
import kotlinx.android.synthetic.main.view_title.*
/**
 * @ClassName       AddPartnerActivity
 * @Description     添加合作关系
 * @Author          xiaoguangfei
 * @Sign            。。。
 * @Date            2018/11/19 17:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddPartnerActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_add_partner

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.partner_add)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        ib_back.setOnClickListener { finish() }
        tv_sure.setOnClickListener {
            AddPartnerDetailActivity.startPartnerDetailActivity(this)
        }

    }
    companion object {
        fun startAddPartnerActivity(context:Context){
            var intent=Intent(context,AddPartnerActivity::class.java)
            context.startActivity(intent)
        }
    }

}
