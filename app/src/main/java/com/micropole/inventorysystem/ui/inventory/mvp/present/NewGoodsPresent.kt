package com.micropole.inventorysystem.ui.inventory.mvp.present

import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.mvp.NewGoodsContract
import com.xx.baseutilslibrary.extensions.ui
import kotlin.math.cos

/**
 * @ClassName       NewGoodsPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/6 9:58
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewGoodsPresent : NewGoodsContract.Present(){
    override fun newGoods(name: String, categoryId: String, huohao: String, cost_price: String, retial_price: String, remark: String,
                          colorId: String, specId: String, material: String, img: String, pack: String) {
        when{
            name.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.new_goods_name_hint))
            categoryId.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.new_goods_category_hint))
            huohao.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.new_goods_id_hint))
            cost_price.isEmpty() ->
                getView()?.showToast(getView()?.getResString(R.string.input_txt) + getView()?.getResString(R.string.new_goods_cost_price))
            retial_price.isEmpty() ->
                getView()?.showToast(getView()?.getResString(R.string.input_txt) + getView()?.getResString(R.string.new_goods_retail_price))
            colorId.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.select_color))
            specId.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.select_spec))
            material.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.select_material))
            img.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.dialog_select_img))
            pack.isEmpty() -> getView()?.showToast(getView()?.getResString(R.string.input_pack_hint))
            else -> {
                imgUp(img){
                    getModel().newGoods(name, categoryId, huohao, cost_price, retial_price, remark, colorId, specId, material, it, pack).ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.showToast(it.msg)
                        getView()?.finishActivity()
                    },{
                        getView()?.dismissLoadingDialog()
                        getView()?.showToast(it)
                    })
                }
            }
        }
    }

    override fun createModel(): NewGoodsContract.Model {
        return NewGoodsContract.Model()
    }

    fun imgUp(img: String,action: (s :String) -> Unit){
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().imgUp(img).ui({
            action.invoke(it.data!!.imgUrl)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

}