package com.micropole.inventorysystem.widght;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.micropole.inventorysystem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author: HuaiXianZhong
 * date: 2018/7/9
 * describe:
 */
public class StarView extends LinearLayout implements View.OnClickListener {
    private static final int SCORE_NORMAL = 20;
    private LinearLayout layout;

    public StarView(Context context) {
        this(context, null);
    }

    public StarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_select_star, this, true);
        layout = findViewById(R.id.ll_star_view);
        init();
    }

    List<ImageView> views = new ArrayList<>();
    List<Boolean> stars = new ArrayList<>();

    private void init() {
        for (int i = 0; i < layout.getChildCount(); i++) {
            views.add((ImageView) layout.getChildAt(i));
            stars.add(false);
        }
    }

    public void setType(int type){
        /*if (type == 0){
            for (int i = 0; i < views.size(); i++) {
                views.get(i).setImageResource(R.drawable.ic_praise_n);
            }
        }else {
            for (int i = 0; i < views.size(); i++) {
                views.get(i).setImageResource(R.drawable.ic_praise_n);
            }
        }*/
    }

    private void setShowView(int star){
        if (star > layout.getChildCount()){
            return;
        }
        for (int i = 0; i < layout.getChildCount(); i++) {
            if (i < star) {
                stars.set(i, true);
                //views.get(i).setImageResource(R.drawable.ic_comment_star_selected);
            } else {
                stars.set(i, false);
                //views.get(i).setImageResource(R.drawable.ic_comment_star_normal);
            }
            views.get(i).setSelected(stars.get(i));
        }
    }

    public void setStarNum(int star) {
        setShowView(star / SCORE_NORMAL);
    }

    public void setEvent(boolean event) {
        if (event) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                views.get(i).setTag(i);
                views.get(i).setOnClickListener(this);
            }
        }
    }

    public int getStarNum() {
        int star = 0;
        for (int i = 0; i < layout.getChildCount(); i++) {
            if (stars.get(i)) {
                star++;
            }
        }
        return star * SCORE_NORMAL;
    }

    @Override
    public void onClick(View v) {
        int i = (int) v.getTag();
        setShowView(++i);
    }
}
