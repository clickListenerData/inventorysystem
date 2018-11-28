package com.micropole.inventorysystem.widght

import android.content.Context
import android.view.View
import com.blankj.utilcode.util.SnackbarUtils.dismiss
import com.flyco.dialog.widget.base.BaseDialog
import com.micropole.inventorysystem.R
import kotlinx.android.synthetic.main.dialog_input_msg.view.*

/**
 * @ClassName       InputDialog
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 9:29
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class InputDialog(context: Context,val title : String,val f : String,val hint : String,val action : (s : String) -> Unit) : BaseDialog<InputDialog>(context) {
    override fun setUiBeforShow() {
        dimEnabled(true)
        setCanceledOnTouchOutside(false)
        setOnclickListener()

        mOnCreateView.tv_input_title.text = title
        mOnCreateView.tv_input_f.text = f
        mOnCreateView.et_input_msg.hint = hint
    }

    override fun onCreateView(): View {
        return View.inflate(mContext, R.layout.dialog_input_msg,null)
    }

    fun setOnclickListener(){
        mOnCreateView.tv_btn_cancel.setOnClickListener { dismiss() }
        mOnCreateView.tv_btn_confirm.setOnClickListener {
            dismiss()
            action.invoke(mOnCreateView.et_input_msg.text.toString())
        }
    }
}