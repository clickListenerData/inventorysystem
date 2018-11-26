package com.micropole.inventorysystem.widght

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.widget.TextViewCompat.setCompoundDrawablesRelative
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.blankj.utilcode.util.ConvertUtils
import com.micropole.inventorysystem.R
import kotlinx.android.synthetic.main.view_custom_center.view.*

/**
 * @ClassName       CustomCenterView
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/20 16:58
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CustomCenterView@JvmOverloads constructor(context : Context, attrs : AttributeSet? = null, def : Int = 0) : LinearLayout(context, attrs,def) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_center,this,true)
        getAttrs(attrs, def)
    }

    fun getAttrs(attrs: AttributeSet?,def: Int){
        val a = context.obtainStyledAttributes(attrs,R.styleable.CustomCenterView,def,0)

        if (a.hasValue(R.styleable.CustomCenterView_top_txt_size)){
            val dimension = a.getDimension(R.styleable.CustomCenterView_top_txt_size,14f)
            setTopTxtSize(dimension)
        }

        if (a.hasValue(R.styleable.CustomCenterView_top_txt_color)){
            val color = a.getColor(R.styleable.CustomCenterView_top_txt_color, Color.parseColor("#666666"))
            setTopTxtColor(color)
        }

        if (a.hasValue(R.styleable.CustomCenterView_top_txt_content)){
            val string = a.getString(R.styleable.CustomCenterView_top_txt_content)
            setTopTxtContent(string)
        }

        if (a.hasValue(R.styleable.CustomCenterView_top_txt_drawable)){
            val drawable = a.getDrawable(R.styleable.CustomCenterView_top_txt_drawable)
            setTopTxtDrawable(drawable)
        }

        if (a.hasValue(R.styleable.CustomCenterView_bottom_txt_size)){
            val dimension = a.getDimension(R.styleable.CustomCenterView_bottom_txt_size,14f)
            setBottomTxtSize(dimension)
        }

        if (a.hasValue(R.styleable.CustomCenterView_bottom_txt_color)){
            val color = a.getColor(R.styleable.CustomCenterView_bottom_txt_color, Color.parseColor("#666666"))
            setBottomTxtColor(color)
        }

        if (a.hasValue(R.styleable.CustomCenterView_bottom_txt_content)){
            val string = a.getString(R.styleable.CustomCenterView_bottom_txt_content)
            setBottomTxtContent(string)
        }
    }

    fun setTopTxtSize(sp:Float){
        tv_custom_top.setTextSize(TypedValue.COMPLEX_UNIT_PX,sp)
    }

    fun setTopTxtColor(@ColorInt color : Int){
        tv_custom_top.setTextColor(color)
    }

    fun setTopTxtContent(content : String){
        tv_custom_top.text = content
    }

    fun setTopTxtDrawable(drawable : Drawable){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv_custom_top.setCompoundDrawablesRelativeWithIntrinsicBounds(null,drawable,null,null)
        }
    }

    fun setBottomTxtSize(sp : Float){
        tv_custom_bottom.setTextSize(TypedValue.COMPLEX_UNIT_PX,sp)
    }

    fun setBottomTxtColor(@ColorInt color : Int){
        tv_custom_bottom.setTextColor(color)
    }

    fun setBottomTxtContent(content: String){
        tv_custom_bottom.text = content
    }
}