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
 * Created by tiankui on 6/25/17.
 */

public class RectangleView extends View {

    Paint paint;

//    public RectangleView(Context context) {
//        super(context);
//    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRectangleView);
        int color = typedArray.getColor(R.styleable.CustomRectangleView_rectangle_color, Color.RED);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColor(color);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left=getLeft();
        int top=getTop();
        int right=left+getWidth();
        int bottom=top+getBottom();
        canvas.drawRect(left,top,right,bottom,paint);
    }
}
