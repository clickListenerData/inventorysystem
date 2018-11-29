package com.micropole.inventorysystem.ui.inventory.input

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.GoodsDetailActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.startActivity
import kotlinx.android.synthetic.main.activity_edit_goods.*

/**
 * @ClassName       EditGoodsActivity
 * @Description     入库 编辑商品
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 14:59
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EditGoodsActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_edit_goods

    override fun initData() {
    }

    override fun initEvent() {

        stv_look_detail.setOnClickListener {
            startActivity<GoodsDetailActivity>()
        }

        stv_save_goods.setOnClickListener {
            finish()
        }
    }

}