package com.micropole.baseapplibrary.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @ClassName       DataBindAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/8 10:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
open class DataBindAdapter<T>(val brId : Int, @LayoutRes val id:Int, var br:Int = -1) : BaseQuickAdapter<T,BaseViewHolder>(id) {
    override fun convert(helper: BaseViewHolder?, item: T) {
        val binding = DataBindingUtil.bind<ViewDataBinding?>(helper!!.itemView)
        binding?.setVariable(brId,item)
        if (br >= 0) binding?.setVariable(br, View.OnClickListener { v -> onItemChildClickListener?.onItemChildClick(this@DataBindAdapter,v,helper.adapterPosition) })
        binding?.executePendingBindings()
    }
}