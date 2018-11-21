package com.micropole.inventorysystem.ui.personal

import android.view.View
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.CategoryActivity
import com.micropole.inventorysystem.ui.personal.inventory.ColorManagerActivity
import com.micropole.inventorysystem.ui.personal.inventory.MaterialManagerActivity
import com.micropole.inventorysystem.ui.personal.mine.NewsActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.fragment_personal.*

/**
 * @ClassName       PersonalFragment
 * @Description     个人中心
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/19 17:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalFragment : BaseMvpViewFragment() {
    override fun getFragmentLayoutId(): Int = R.layout.fragment_personal

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
        iv_news.setOnClickListener { activity?.startActivity<NewsActivity>() }
        nll_category.setOnClickListener { activity?.startActivity<CategoryActivity>() }
        nll_color.setOnClickListener { activity?.startActivity<ColorManagerActivity>() }
        nll_material.setOnClickListener { activity?.startActivity<MaterialManagerActivity>() }
    }

    override fun initData() {
    }
}