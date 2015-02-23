package com.zaoqibu.customviewbyextendsexistingview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by vwarship on 2015/2/23.
 */
public class CustomTextView extends TextView {
    private float margin;
    private float radius;
    private float rectWidth;

    private int paperColor;
    private Paint linesPaint;
    private Paint marginPaint;

    public CustomTextView(Context context) {
        super(context);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Resources resources = getResources();

        margin = resources.getDimension(R.dimen.margin);
        radius = resources.getDimension(R.dimen.radius);
        rectWidth = resources.getDimension(R.dimen.rect_width);

        paperColor = resources.getColor(R.color.paper);

        linesPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linesPaint.setColor(resources.getColor(R.color.lines));

        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(resources.getColor(R.color.margin));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 画背景
        canvas.drawColor(paperColor);

        // 画简单的阴影
        canvas.drawLine(getMeasuredWidth(), 0, getMeasuredWidth(), getMeasuredHeight(), linesPaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linesPaint);

        // 画矩形
        canvas.drawRect(margin, 0, margin+rectWidth, getMeasuredHeight(), marginPaint);

        // 画圆
        canvas.drawCircle(margin/2, getMeasuredHeight()/2, radius, marginPaint);

        canvas.save();

        // 设置新的坐标原点
        canvas.translate(margin, 0);
        // 使用新的坐标原点绘制文本
        super.onDraw(canvas);

        canvas.restore();
    }
}
