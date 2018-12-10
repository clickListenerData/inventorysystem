package com.micropole.inventorysystem.ui.shoppingmall.mvp.present

import com.micropole.inventorysystem.ui.shoppingmall.mvp.ProductDetailContract
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       ProductDetailPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/10 11:28
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ProductDetailPresent : ProductDetailContract.Prenset() {
    override fun productDetail(id: String) {
        getModel().productDetail(id).ui({
            getView()?.setData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ProductDetailContract.Model {
        return ProductDetailContract.Model()
    }
}