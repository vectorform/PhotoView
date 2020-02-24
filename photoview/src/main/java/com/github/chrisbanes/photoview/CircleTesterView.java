package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CircleTesterView extends View {

    private Path path;
    private Paint paint;

    public RectF boundingRect = new RectF(165f, 627f, 915f, 1377f);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleTesterView(Context context) {
        this(context, null, 0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleTesterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleTesterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleTesterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        path = new Path();


        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1f * getResources().getDisplayMetrics().density);
        paint.setColor(0xFFFF0000);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        path.addCircle(getWidth() / 2f, getHeight() / 2f, 250 * getResources().getDisplayMetrics().density / 2f, Path.Direction.CW);
        path.computeBounds(boundingRect, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }
}
