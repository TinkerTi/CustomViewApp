package tinker.cn.customviewapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import tinker.cn.customviewapp.R;

/**
 * Created by tiankui on 6/14/17.
 */

public class CircleView extends View {

    Paint mPaint;
    private int mWidth = 100;
    private int mHeight = 100;

    public CircleView(Context context) {
        super(context);
        init(Color.RED);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int count=attrs.getAttributeCount();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCircleView);
        int color = typedArray.getColor(R.styleable.CustomCircleView_circle_color, Color.RED);
        typedArray.recycle();
        init(color);
    }

    private void init(int color) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, 200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int leftPadding = getPaddingLeft();
        int topPadding = getPaddingTop();
        int rightPadding = getPaddingRight();
        int bottomPadding = getPaddingBottom();

        int width = getWidth() - leftPadding - rightPadding;
        int height = getHeight() - topPadding - bottomPadding;
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(leftPadding + width / 2, topPadding + height / 2, radius, mPaint);
    }
}
