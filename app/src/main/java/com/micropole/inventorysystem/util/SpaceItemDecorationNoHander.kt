package com.micropole.inventorysystem.util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.blankj.utilcode.util.ConvertUtils

/**
 * @ClassName       SpaceItemDecoration
 * @Description     首页 item 间隔
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 10:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SpaceItemDecorationNoHander : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        Log.i("outRect",""+parent?.getChildLayoutPosition(view))
        if (parent!!.getChildLayoutPosition(view) % 2 == 0) {
            outRect?.left = ConvertUtils.dp2px(14f)
            outRect?.right = ConvertUtils.dp2px(7f)
        }else{

                outRect?.right = ConvertUtils.dp2px(14f)
                outRect?.left = ConvertUtils.dp2px(7f)

            }
        }

}