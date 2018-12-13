package com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter

import com.blankj.utilcode.util.DeviceUtils.getModel
import com.blankj.utilcode.util.SnackbarUtils.getView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ProductDetailContract
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
    override fun confirmBuy(id: String, sp: String, mo: String, num: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().confirmBuy(id, sp, mo, num).ui({
            getView()?.dismissLoadingDialog()
            getView()?.confirmBuy(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun addCart(id: String, sp: String, mo: String, num: String) {
        when{
            sp.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.select_color))
            mo.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.select_spec))
            else -> {
                getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
                getModel().addCart(id, sp, mo,num).ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it.msg)
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it)
                })
            }
        }
    }

    override fun selectSpec(id: String, sp: String, mo: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().selectSpec(id, sp, mo).ui({
            getView()?.dismissLoadingDialog()
            getView()?.specResult(it.data)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun collectProduct(id: String) {
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().collectProduct(id).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

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