package com.micropole.inventorysystem.ui.personal.shopmall.mvp.present

import android.util.Log
import com.blankj.utilcode.util.DeviceUtils.getModel
import com.blankj.utilcode.util.SnackbarUtils.getView
import com.google.gson.Gson
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CommentsBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.EvaluationOrderContract
import com.xx.baseutilslibrary.extensions.ui
import java.lang.StringBuilder
import kotlin.system.measureTimeMillis

/**
 * @ClassName       EvaluationOrderPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/13 17:23
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationOrderPresent : EvaluationOrderContract.Present() {
    override fun evaluationOrder(id: String, list: ArrayList<CommentsBean>) {
        val evaBean = EvaBean(list)
        Log.i("evaluation_order",Gson().toJson(evaBean))
        getModel().evaluationOrder(id, Gson().toJson(evaBean)).ui({
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.msg)
            getView()?.finishActivity()
        }, {
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun imgSup(img:String){
        getView()?.showLoadingDialog(getView()?.getResString(R.string.loading))
        getModel().imgUp(img).ui({
            getView()?.imgUP(it.data!!.imgUrl)
        }, {
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    data class EvaBean(val product: ArrayList<CommentsBean>)
}