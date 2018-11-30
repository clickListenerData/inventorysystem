package com.micropole.inventorysystem.ui.home

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.output.SelectCustomerActivity
import com.micropole.inventorysystem.ui.personal.inventory.CategoryActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_new_build_order.*
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

        tv_add_goods.setOnClickListener { CategoryActivity.startCategory(this,CategoryActivity.TYPE_SELECT_GOODS) }
        tv_add_shop.setOnClickListener { CategoryActivity.startCategory(this,CategoryActivity.TYPE_SELECT_GOODS) }
        tv_add_kehu.setOnClickListener { startActivity<SelectCustomerActivity>() }
    }


    companion object {
        fun startNewBuildOrderActivity(context:Context){
            var intent=Intent(context,NewBuildOrderActivity::class.java)
            context.startActivity(intent)
        }
    }

}
