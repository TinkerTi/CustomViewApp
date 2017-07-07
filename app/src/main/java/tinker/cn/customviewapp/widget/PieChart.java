package tinker.cn.customviewapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import tinker.cn.customviewapp.model.PieData;

/**
 * Created by tiankui on 7/7/17.
 */

public class PieChart extends View {
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private float startAngle = 0;
    private ArrayList<PieData> dataList;
    private int width, height;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public PieChart(Context context) {
        this(context, null);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        dataList = new ArrayList<>();
        initData();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float currentStartAngle = startAngle;
        canvas.translate(width / 2, height / 2);
        float rad = (float) (Math.min(width, height) / 2 * 0.8);
        RectF rectF = new RectF(-rad, -rad, rad, rad);
        for (int i = 0; i < dataList.size(); i++) {
            PieData pieData = dataList.get(i);
            paint.setColor(pieData.getColor());
            canvas.drawArc(rectF, currentStartAngle, pieData.getAngle(), true, paint);
            currentStartAngle += pieData.getAngle();
        }
    }

    private void initData() {
        PieData pieData = new PieData();
        pieData.setColor(mColors[0]);
        pieData.setAngle(90);
        pieData.setPercentage(0.25f);

        PieData pieData1 = new PieData();
        pieData1.setColor(mColors[1]);
        pieData1.setAngle(30);

        PieData pieData2 = new PieData();
        pieData2.setColor(mColors[2]);
        pieData2.setAngle(60);

        PieData pieData3 = new PieData();
        pieData3.setColor(mColors[3]);
        pieData3.setAngle(100);

        PieData pieData4 = new PieData();
        pieData4.setColor(mColors[4]);
        pieData4.setAngle(80);

        dataList.add(pieData);
        dataList.add(pieData1);
        dataList.add(pieData2);
        dataList.add(pieData3);
        dataList.add(pieData4);
    }
}
