package com.micropole.inventorysystem.util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
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
class SpaceItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent?.getChildLayoutPosition(view) == 0){  //header
            outRect?.left = 0
            outRect?.right = 0
        }else{
            if (parent!!.getChildLayoutPosition(view) % 2 == 0){  //第二列
                outRect?.right = ConvertUtils.dp2px(14f)
                outRect?.left = ConvertUtils.dp2px(7f)
            }else{  //第一列
                outRect?.left = ConvertUtils.dp2px(14f)
                outRect?.right = ConvertUtils.dp2px(7f)
            }
        }
    }
}