package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.inventorysystem.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.view_title.*
/**
 * @ClassName       NewBuildOrderActivity
 * @Description     新建订单
 * @Author          肖光飞
 * @Sign            。。。
 * @Date            2018/11/19 17:47
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewBuildOrderActivity : BaseMvpViewActivity() {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_new_build_order

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.chuanjian)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }
    companion object {
        fun startNewBuildOrderActivity(context:Context){
            var intent=Intent(context,NewBuildOrderActivity::class.java)
            context.startActivity(intent)
        }
    }

}
