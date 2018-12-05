package com.micropole.inventorysystem.ui.inventory

import android.content.Intent
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.inventory.CategoryActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_new_goods.*

/**
 * @ClassName       NewGoodsActivity
 * @Description     新建商品
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 11:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewGoodsActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_new_goods

    override fun initData() {
    }

    override fun initEvent() {
        nll_goods_category.setOnClickListener {
            CategoryActivity.startCategory(this,CategoryActivity.TYPE_SELECT)
        }
        nll_goods_material.setOnClickListener { SelectActivity.startSelect(this,SelectActivity.SELECT_MATERIAL) }
        nll_goods_size.setOnClickListener { SelectActivity.startSelect(this,SelectActivity.SELECT_SIZE) }
        ll_goods_color.setOnClickListener { SelectActivity.startSelect(this,SelectActivity.SELECT_COLOR) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SelectActivity.REQUEST_CODE && resultCode == SelectActivity.RESULT_CODE && data != null){
            val type = data.getIntExtra("select_type", SelectActivity.SELECT_COLOR)
            val content = data.getStringExtra("select_content")
            val id = data.getStringExtra("select_id")

        }
    }
}