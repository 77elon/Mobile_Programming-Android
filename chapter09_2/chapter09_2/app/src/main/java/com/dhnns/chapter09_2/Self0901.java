package com.dhnns.chapter09_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class Self0901 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            paint.setStrokeWidth(30);
            paint.setColor(Color.RED);
            canvas.drawLine(100, 30, 900, 900, paint);

            paint.setColor(Color.GREEN);
            canvas.drawLine(100, 900, 900, 30, paint);


            RectF rectF = new RectF();

            rectF.set(425, 120, 425 + 150, 120 + 150);
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectF, paint);

            rectF.set(100, 350, 100 + 200, 350 + 200);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(rectF, paint);

            rectF.set(725, 350, 725 + 200, 350 + 200);
            paint.setColor(Color.GRAY);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRoundRect(rectF, 20, 20, paint);

            rectF.set(425, 650, 425 + 150, 650 + 150);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectF, paint);


            paint.setColor(Color.BLACK);
            rectF.set(125, 900,  125 + 750, 900 + 200);
            canvas.drawOval(rectF, paint);


            rectF.set(500, 900, 500 + 100, 900 + 100);
            canvas.drawArc(rectF, 40, 110, true, paint);


        }
    }

}
