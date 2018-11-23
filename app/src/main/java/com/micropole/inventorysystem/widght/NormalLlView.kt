package com.micropole.inventorysystem.widght

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.ConvertUtils
import com.micropole.inventorysystem.R
import kotlinx.android.synthetic.main.view_normal_ll.view.*

/**
 * @ClassName       NormalLlView
 * @Description     个人中心 常用
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/20 11:53
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NormalLlView@JvmOverloads constructor(context : Context, attrs : AttributeSet? = null, def : Int = 0) : LinearLayout(context, attrs,def){

    init {
        LayoutInflater.from(context).inflate(R.layout.view_normal_ll,this,true)
        getAttrs(attrs, def)
    }

    fun getAttrs(attrs: AttributeSet?,def: Int){
        val a = context.obtainStyledAttributes(attrs,R.styleable.NormalLlView,def,0)

        if (a.hasValue(R.styleable.NormalLlView_main_txt_content)){
            val string = a.getString(R.styleable.NormalLlView_main_txt_content)
            setMainTitle(string)
        }

        if (a.hasValue(R.styleable.NormalLlView_main_txt_color)){
            val color = a.getColor(R.styleable.NormalLlView_main_txt_color, Color.parseColor("#666666"))
            setMainTitleColor(color)
        }

        if (a.hasValue(R.styleable.NormalLlView_main_txt_size)){
            val dimension = a.getDimension(R.styleable.NormalLlView_main_txt_size, 14f)
            setMainTitleSize(dimension)
        }

        if (a.hasValue(R.styleable.NormalLlView_custom_txt_content)){
            val string = a.getString(R.styleable.NormalLlView_custom_txt_content)
            setCustomTxt(string)
        }

        if (a.hasValue(R.styleable.NormalLlView_custom_txt_color)){
            val color = a.getColor(R.styleable.NormalLlView_custom_txt_color, Color.parseColor("#666666"))
            setCustomTxtColor(color)
        }

        if (a.hasValue(R.styleable.NormalLlView_custom_txt_size)){
            val dimension = a.getDimension(R.styleable.NormalLlView_custom_txt_size, 14f)
            setCustomTxtSize(dimension)
        }

        if (a.hasValue(R.styleable.NormalLlView_main_drawable)){
            val drawable = a.getDrawable(R.styleable.NormalLlView_main_drawable)
            if (drawable == null){
                iv_main_title.visibility = View.GONE
            }else{
                iv_main_title.setImageDrawable(drawable)
            }
        }

        if (a.hasValue(R.styleable.NormalLlView_custom_txt_drawable)){
            val drawable = a.getDrawable(R.styleable.NormalLlView_custom_txt_drawable)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                tv_custom.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
            }
        }
    }

    fun setMainTitleSize(sp : Float){
        tv_main_title.setTextSize(TypedValue.COMPLEX_UNIT_PX,sp)
    }

    fun setMainTitleSize(@DimenRes id : Int){
        val dimension = context.resources.getDimension(id)
        setMainTitleSize(dimension)
    }

    fun setMainTitleColor(@ColorInt color : Int){
        tv_main_title.setTextColor(color)
    }

    fun setMainTitle(@StringRes id : Int){
        setMainTitle(context.getText(id).toString())
    }

    fun setMainTitle(txt : String){
        tv_main_title.text = txt
    }

    fun setMainDrawable(@DrawableRes id : Int){
        if (id == 0){
            iv_main_title.visibility = View.GONE
        }else{
            iv_main_title.setImageResource(id)
        }
    }

    fun setCustomTxtSize(sp : Float){
        tv_custom.setTextSize(TypedValue.COMPLEX_UNIT_PX,sp)
    }

    fun setCustomTxtSize(@DimenRes id : Int){
        val dimension = context.resources.getDimension(id)
        setCustomTxtSize(dimension)
    }

    fun setCustomTxtColor(@ColorInt color : Int){
        tv_custom.setTextColor(color)
    }

    fun setCustomTxt(txt: String){
        tv_custom.text = txt
    }

    fun setCustomDrawable(@DrawableRes id : Int){
        val drawable = context.resources.getDrawable(id)
        tv_custom.setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null)
    }

    fun getCustomTxt() : String{
        return tv_custom.text.toString()
    }

}