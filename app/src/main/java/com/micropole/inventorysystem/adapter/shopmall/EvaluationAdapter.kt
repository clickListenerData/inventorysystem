package com.micropole.inventorysystem.adapter.shopmall

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import com.blankj.utilcode.util.EncodeUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.util.ImageChooseHelper
import com.micropole.baseapplibrary.widght.ShowImgView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.OrderListBean
import com.micropole.inventorysystem.widght.StarView
import com.xx.baseutilslibrary.extensions.loadImag
import java.io.File

/**
 * @ClassName       EvaluationAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 15:36
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationAdapter(val imageChooseHelper: ImageChooseHelper) : BaseQuickAdapter<OrderListBean.OrProdBean,BaseViewHolder>(R.layout.item_evaluation_view) {

    val scores = arrayListOf<String>()
    val contents = arrayListOf<String>()
    val views = arrayListOf<ShowImgView>()
    var s = ""
    var position = 0
    set(value) {
        field = value
        isRefresh = true
        notifyItemChanged(value)
    }
    var isRefresh = false


    override fun convert(helper: BaseViewHolder?, item: OrderListBean.OrProdBean?) {
        helper?.apply {
            if (isRefresh){
                views[adapterPosition].addImgView(s)
            }
            val view = getView<ShowImgView>(R.id.siv_add_photo)
            getView<ImageView>(R.id.iv_order_img).loadImag(item?.pro_img)
            setText(R.id.tv_product_title,item?.pro_name)
            setText(R.id.tv_product_size,item?.sp_name+"/${item?.mo_name}")
            setText(R.id.tv_product_price,"¥${item?.pro_money}")
            setText(R.id.tv_product_count,"X${item?.pro_num}")
            getView<StarView>(R.id.sv_star).setEvent(true){
                scores[adapterPosition] = it
            }
            getView<EditText>(R.id.et_put_content).addTextChangedListener(textWathcher(adapterPosition))
            view.imageChooseHelper = imageChooseHelper
            view.mListener = object : ShowImgView.CLICKListener {
                override fun clickListener() {
                    onItemChildClickListener?.onItemChildClick(this@EvaluationAdapter,view,adapterPosition)
                }
            }
            views.add(view)
        }
    }

    private fun textWathcher(position:Int) : TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                contents[position] = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
    }

    override fun setNewData(data: MutableList<OrderListBean.OrProdBean>?) {
        super.setNewData(data)
        if (data != null){
            for (i in data.indices){
                scores.add("")
                contents.add("")
            }
        }
    }
}