package com.micropole.inventorysystem.util;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.micropole.inventorysystem.widght.InputMsgView;
import com.micropole.inventorysystem.widght.NormalLlView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @ClassName BindingUtils
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/5 10:40
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class BindingUtils {

    @BindingAdapter(value = "android:main_content", requireAll = false)
    public static void setMainContent(NormalLlView view, String content) {
        view.setMainTitle(content);
    }

    @BindingAdapter(value = "android:custom_content", requireAll = false)
    public static void setCustomContent(NormalLlView view, String content) {
        if (content == null) view.setCustomTxt("");
        else  view.setCustomTxt(content);
    }

    @BindingAdapter(value = "android:input_content",requireAll = false)
    public static void setInputContent(InputMsgView view,String content){
        view.setInputContent(content);
    }

    @BindingAdapter(value = "android:img_color", requireAll = false)
    public static void setImgColor(CircleImageView view, String content) {
        ColorDrawable colorDrawable = new ColorDrawable(ColorUtils.INSTANCE.string2Color(content));
        view.setImageDrawable(colorDrawable);
    }
}
