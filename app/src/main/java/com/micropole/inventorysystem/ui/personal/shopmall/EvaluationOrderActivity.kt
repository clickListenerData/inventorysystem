package com.micropole.inventorysystem.ui.personal.shopmall

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.baseapplibrary.widght.ShowImgView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.rv_evaluation
import com.micropole.inventorysystem.adapter.shopmall.EvaluationAdapter
import com.micropole.inventorysystem.entity.CommentsBean
import com.micropole.inventorysystem.entity.OrderListBean
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.EvaluationOrderContract
import com.micropole.inventorysystem.ui.personal.shopmall.mvp.present.EvaluationOrderPresent
import com.micropole.inventorysystem.ui.shoppingmall.ApplyAfterActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_evaluation_order.*
import org.devio.takephoto.model.TResult

/**
 * @ClassName       EvaluationOrderActivity
 * @Description     评价订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 14:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationOrderActivity : BaseUpImgActivity<EvaluationOrderContract.Present>(),EvaluationOrderContract.View {

    companion object {
        fun startEvaluationOrder(context: Context,data : ArrayList<OrderListBean.OrProdBean>,id:String){
            val intent = Intent(context, EvaluationOrderActivity::class.java)
            intent.putParcelableArrayListExtra("evaluation_data",data)
            intent.putExtra("evaluation_id",id)
            context.startActivity(intent)
        }
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_evaluation_order

    override fun createPresenter(): EvaluationOrderContract.Present = EvaluationOrderPresent()

    var evaluationAdapter : EvaluationAdapter? = null
    lateinit var mOid : String
    var mPosition = 0

    override fun initData() {
        evaluationAdapter = EvaluationAdapter(imageChooseHelper!!)
        rv_evaluation.layoutManager = LinearLayoutManager(mContext)
        rv_evaluation.adapter = evaluationAdapter

        val data = intent.getParcelableArrayListExtra<OrderListBean.OrProdBean>("evaluation_data")
        evaluationAdapter?.setNewData(data)
        tv_product_count.text = "${data.size}件"

        mOid = intent.getStringExtra("evaluation_id")
    }

    override fun initEvent() {
        evaluationAdapter?.setOnItemChildClickListener { adapter, view, position ->
            if (view is ShowImgView){
                mPosition = position
            }
        }

        stv_commit_evalua.setOnClickListener {
            evalutionOrder()
        }
    }

    val list = arrayListOf<CommentsBean>()
    val buffer =  StringBuffer()
    var mP = 0
    var mI = 0
    fun evalutionOrder(){
        for (i in evaluationAdapter?.contents!!.indices){
            val bean = CommentsBean()
            bean.com_content = evaluationAdapter?.contents!![i]
            bean.pro_id = evaluationAdapter?.data!![i].pro_id
            bean.pro_score = evaluationAdapter?.scores!![i]
            bean.custom_orginalpics = evaluationAdapter?.views!![i].mImgList
            list.add(bean)
            Log.i("evaluation_img",list[mP].custom_orginalpics[mI])
            if (i == 0) getPresenter().imgSup(bean.custom_orginalpics[mI])
        }
    }

    override fun imgUP(s: String) {
        buffer.append("$s,")
        if (mI == list[mP].custom_orginalpics.size - 1){
            if (mP == list.size - 1){
                list[mP].custom_orginalpics = null
                buffer.delete(buffer.length -1,buffer.length)
                list[mP].com_pic = buffer.toString()
                getPresenter().evaluationOrder(mOid,list)
            }else{
                buffer.delete(buffer.length -1,buffer.length)
                list[mP].com_pic = buffer.toString()
                buffer.delete(0,buffer.length)
                list[mP].custom_orginalpics = null
                ++mP
                mI = 0
                getPresenter().imgSup(list[mP].custom_orginalpics[mI])
            }
        }else{
            getPresenter().imgSup(list[mP].custom_orginalpics[++mI])
        }
    }

    override fun imgResult(result: TResult) {
        evaluationAdapter?.s = result.images[0].compressPath
        evaluationAdapter?.position = mPosition
    }
}