package com.micropole.inventorysystem.util

import android.graphics.Color
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.IntRange
import com.micropole.inventorysystem.R

/**
 * @ClassName       ColorUtils
 * @Description     颜色工具
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/30 9:25
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
object ColorUtils {

    fun color2String(color : Int) : String{
        val r = (color shr 16 and 0xff)
        val g = (color shr 8 and 0xff)
        val b = (color and 0xff)
        val a = (color shr 24 and 0xff)
        return rgb2String(r, g, b, a)
    }

    fun rgb2String(r : Int,g: Int,b : Int,a : Int) : String{
        var R = Integer.toHexString(r)
        R = if (R.length < 2) "0$R" else R
        var B = Integer.toHexString(b)
        B = if (B.length < 2) "0$B" else B
        var G = Integer.toHexString(g)
        G = if (G.length < 2) "0$G" else G
        var A = Integer.toHexString(a)
        A = if (A.length < 2) "0$A" else A
        return "#$A$R$G$B"
    }

    @ColorInt fun string2Color(s : String) : Int{
        if (s.length == 4){
            val r = s.elementAt(1)
            val g = s.elementAt(2)
            val b = s.elementAt(3)
            return Color.parseColor("#$r$r$g$g$b$b")
        }
        return Color.parseColor(s)
    }

    @ColorInt fun rgba2Color(r : Int,g: Int,b : Int,a : Int) : Int{
        return Color.argb(a,r,g,b)
    }
}