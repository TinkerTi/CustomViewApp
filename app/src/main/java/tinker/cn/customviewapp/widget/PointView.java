package tinker.cn.customviewapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tiankui on 7/7/17.
 */

public class PointView extends View {
    Paint paint;
    public PointView(Context context) {
        super(context);
        init();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

        canvas.drawPoint(200,200,paint);

        canvas.drawPoint(400,500,paint);
        canvas.drawPoint(400,600,paint);
        canvas.drawPoint(400,700,paint);

        canvas.drawLine(300,300,600,600,paint);

        canvas.drawRect(100,100,400,300,paint);
    }
}
