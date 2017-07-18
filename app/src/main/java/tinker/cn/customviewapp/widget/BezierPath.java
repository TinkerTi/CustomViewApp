package tinker.cn.customviewapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by tiankui on 7/18/17.
 */

public class BezierPath extends View {
    private PointF start;
    private PointF end;
    private PointF control;
    private Paint paint;

    private int centerX;
    private int centerY;


    public BezierPath(Context context) {
        this(context, null);
    }

    public BezierPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        control.x = event.getX();
        control.y = event.getY();
        invalidate();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        start.x = centerX - 200;
        start.y = centerY;

        end.x = centerX + 200;
        end.y = centerY;

        control.x = centerX;
        control.y = centerY - 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(20);

        canvas.drawPoint(start.x, end.y, paint);
        canvas.drawPoint(end.x, end.y, paint);
        canvas.drawPoint(control.x, control.y, paint);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        canvas.drawLine(start.x, start.y, control.x, control.y, paint);
        canvas.drawLine(end.x, end.y, control.x, control.y, paint);

        paint.setColor(Color.RED);
        Path path = new Path();
        path.moveTo(start.x, start.y);
        path.quadTo(control.x, control.y, end.x, end.y);
        canvas.drawPath(path, paint);
    }
}
