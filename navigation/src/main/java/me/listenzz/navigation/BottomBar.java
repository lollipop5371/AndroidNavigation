package me.listenzz.navigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by Listen on 2018/1/30.
 */

public class BottomBar extends BottomNavigationBar {

    private Drawable shadow = new ColorDrawable(Color.parseColor("#dddddd"));

    public BottomBar(Context context) {
        super(context);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (shadow != null && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            int height = (int) getContext().getResources().getDisplayMetrics().density;
            shadow.setBounds(0, 0, getWidth(), height);
            shadow.draw(canvas);
        }
    }

    public void setShadow(@Nullable Drawable drawable) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            shadow = drawable;
            postInvalidate();
        }
    }

    @Override
    public void initialise() {
        super.initialise();
        LinearLayout itemContainer = findViewById(R.id.bottom_navigation_bar_item_container);
        int count = itemContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            View itemLayout =  itemContainer.getChildAt(i);
            ImageView iconView = itemLayout.findViewById(R.id.fixed_bottom_navigation_icon);
            iconView.setScaleType(ImageView.ScaleType.CENTER);
        }
    }
}
