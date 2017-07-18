package tinker.cn.customviewapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import tinker.cn.customviewapp.R;

/**
 * Created by tiankui on 7/14/17.
 */

public class CanvasView extends View {
    Paint paint;
    Picture picture;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        picture=new Picture();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, paint);
//
//        canvas.translate(200, 200);
//        paint.setColor(Color.GREEN);
//        canvas.drawCircle(0, 0, 100, paint);
//        Canvas pictureCanvas=picture.beginRecording(500,500);
//        RectF rectF=new RectF(0,0,200,200);
//        pictureCanvas.drawRect(rectF,paint);
//
////        canvas.scale(1,-1);
////        canvas.rotate(180);
//        pictureCanvas.skew(0,1);
////        canvas.skew(1,0);
//        paint.setColor(Color.BLUE);
//        pictureCanvas.drawRect(rectF,paint);
//
//        picture.endRecording();
//
//        canvas.drawPicture(picture);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,new Matrix(),new Paint());
        canvas.drawBitmap(bitmap,300,300,paint);
    }
}
