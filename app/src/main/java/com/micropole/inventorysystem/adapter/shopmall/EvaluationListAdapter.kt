package com.micropole.inventorysystem.adapter.shopmall

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.widght.ShowImgView
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.CommentsBean
import com.xx.baseutilslibrary.extensions.loadImag
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @ClassName       EvaluationListAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/14 11:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListAdapter : BaseQuickAdapter<CommentsBean,BaseViewHolder>(R.layout.item_list_evaluation) {
    override fun convert(helper: BaseViewHolder?, item: CommentsBean?) {
        helper?.apply {
            getView<CircleImageView>(R.id.civ_head_img).loadImag(item?.user_img)
            setText(R.id.tv_e_name,item?.nickname)
            setText(R.id.tv_e_num,item?.pro_score)
            setText(R.id.tv_e_des,item?.com_content)
            val view = getView<ShowImgView>(R.id.siv_imgs)
            view.removeAllViews()
            if (!item?.com_pic.isNullOrEmpty()){
                val s = item?.com_pic?.split(",")
                for (i in s!!){
                    view.addShowImgView(i)
                }
            }else{
                view.visibility = View.GONE
            }
        }
    }
}