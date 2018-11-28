package com.micropole.inventorysystem.widght

import android.content.Context
import android.graphics.Color
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.micropole.inventorysystem.R
import kotlinx.android.synthetic.main.view_input_message.view.*

/**
 * @ClassName       InputMsgView
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 15:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class InputMsgView@JvmOverloads constructor(context : Context, attrs : AttributeSet? = null, def : Int = 0) : LinearLayout(context, attrs,def) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_input_message,this,true)
        getAttrs(attrs, def)
    }

    fun getAttrs(attrs: AttributeSet?,def: Int) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.InputMsgView, def, 0)

        if (a.hasValue(R.styleable.InputMsgView_title_color)){
            setTitleColor(a.getColor(R.styleable.InputMsgView_title_color,Color.parseColor("#666666")))
        }

        if (a.hasValue(R.styleable.InputMsgView_title_size)){
            setTitleSize(a.getFloat(R.styleable.InputMsgView_title_size,14f))
        }

        if (a.hasValue(R.styleable.InputMsgView_title_content)){
            setTitleContent(a.getString(R.styleable.InputMsgView_title_content))
        }

        if (a.hasValue(R.styleable.InputMsgView_input_color)){
            setInputColor(a.getColor(R.styleable.InputMsgView_input_color,Color.parseColor("#666666")))
        }

        if (a.hasValue(R.styleable.InputMsgView_input_size)){
            setInputSize(a.getFloat(R.styleable.InputMsgView_input_size,14f))
        }

        if (a.hasValue(R.styleable.InputMsgView_input_hint_color)){
            et_input_msg.setHintTextColor(a.getColor(R.styleable.InputMsgView_input_hint_color,Color.parseColor("#666666")))
        }

        if (a.hasValue(R.styleable.InputMsgView_input_hint_content)){
            setInputHint(a.getString(R.styleable.InputMsgView_input_hint_content))
        }

        if (a.hasValue(R.styleable.InputMsgView_input_content)){
            setInputContent(a.getString(R.styleable.InputMsgView_input_content))
        }

        if (a.hasValue(R.styleable.InputMsgView_input_enable)){
            isInput(a.getBoolean(R.styleable.InputMsgView_input_enable,false))
        }
    }

    fun setTitleSize(size : Float){
        tv_input_title.textSize = size
    }

    fun setTitleColor(color:Int){
        tv_input_title.setTextColor(color)
    }

    fun setTitleContent(content: String) {
        tv_input_title.text = content
    }

    fun isInput(isEnable : Boolean){
        et_input_msg.isEnabled = isEnabled
        et_input_msg.inputType = if (isEnable) InputType.TYPE_CLASS_TEXT else InputType.TYPE_NULL
    }

    fun setInputHint(content : String){
        et_input_msg.hint = content
    }

    fun setInputContent(content: String){
        et_input_msg.setText(content)
    }

    fun setInputColor(color:Int){
        et_input_msg.setTextColor(color)
    }

    fun setInputSize(size : Float){
        et_input_msg.textSize = size
    }

}