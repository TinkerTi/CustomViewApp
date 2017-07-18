package tinker.cn.customviewapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tiankui on 7/10/17.
 */

public class LineView extends View {
    Paint paint;

    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Path path = new Path();
//        path.lineTo(200, 200);
//        path.lineTo(400, 300);
//        path.close();
//        canvas.drawPath(path, paint);

        canvas.translate(300,300);
        canvas.scale(1,-1);
        Path path=new Path();
        path.addRect(-100,-100,100,100, Path.Direction.CW);
        path.setLastPoint(-200,200);
        path.addCircle(0,0,50, Path.Direction.CW);
        canvas.drawPath(path,paint);
    }
}
