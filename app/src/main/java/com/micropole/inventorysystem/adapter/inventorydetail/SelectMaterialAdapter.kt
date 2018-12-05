package com.micropole.inventorysystem.adapter.inventorydetail

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.MaterialBean

/**
 * @ClassName       SelectColorAdapter
 * @Description     选择颜色
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/28 16:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SelectMaterialAdapter : BaseQuickAdapter<MaterialBean.TextureListBean,BaseViewHolder>(R.layout.item_select_material) {

    val checkData = arrayListOf<Boolean>()
    val materails = arrayListOf<String>()

    override fun convert(helper: BaseViewHolder?, item: MaterialBean.TextureListBean?) {
        helper?.apply {
            setText(R.id.tv_material_t,item?.t_name)
            addOnClickListener(R.id.iv_check)
            if (checkData[adapterPosition]) setVisible(R.id.et_put_material,true)
            getView<EditText>(R.id.et_put_material).addTextChangedListener(watcher(adapterPosition))
        }
    }

    fun watcher(position:Int) : TextWatcher{
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                try {
                    val i = s.toString().toInt()
                    if (i > 100){
                        s?.replace(0,s.length,"100")
                    }
                    materails[position] = s.toString()
                }catch (e : Exception){
                    s?.delete(0,s.length)
                    ToastUtils.showShort(mContext.getString(R.string.material_sure_percent))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
    }
}