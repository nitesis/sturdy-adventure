package ch.fhnw.android_labyrinth.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ClickView extends View {

    private static final String TAG = "ClickView";

    private Paint paint;

    private float x_factor = 1;
    private float y_factor = 1;

    private boolean lineTo = false;
    private float lineToX = 0;
    private float lineToY = 0;

    private DisplayMetrics displayMetrics;


    public ClickView(final Context context, DisplayMetrics displayMetrics) {
        super(context);

        this.displayMetrics = displayMetrics;
        calculateDisplaySize();

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.YELLOW);

        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                float x = motionEvent.getX();
                float y = motionEvent.getY();
                setXYParams(x, y);

                Log.d(TAG, "x clicked " + x);
                Log.d(TAG, "y clicked " + y);

                // Show a message with the coordinates in 180/180
                Toast toast = Toast.makeText(context, "x:" + (int)(x/x_factor) + " y: " + (int)(y/y_factor), Toast.LENGTH_SHORT);
                toast.show();

                // Invalidate the paint area and redraw
                invalidate();

                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Set background color
        canvas.drawColor(Color.DKGRAY);

        // Draw a small circle in the middle
        paint.setColor(Color.WHITE);
        canvas.drawCircle(displayMetrics.widthPixels/2f, displayMetrics.heightPixels/2f, 10, paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawCircle(displayMetrics.widthPixels/2f, displayMetrics.heightPixels/2f, 9, paint);
        paint.setColor(Color.YELLOW);

        // Draw a line to the selected point
        if (lineTo) {
            Log.d(TAG, "Drawing line");
            canvas.drawLine(displayMetrics.widthPixels/2f, displayMetrics.heightPixels/2f, lineToX, lineToY, paint);
            canvas.drawCircle(lineToX, lineToY, 8, paint);
        }
    }

    private void calculateDisplaySize() {
        this.x_factor = displayMetrics.widthPixels / 180f;
        this.y_factor = displayMetrics.heightPixels / 180f;

        Log.d(TAG, "Display width in px is " + displayMetrics.widthPixels);
        Log.d(TAG, "Display height in px is " + displayMetrics.heightPixels);
    }

    private void setXYParams(float x, float y) {
        lineTo = true;

        this.lineToX = x;
        this.lineToY = y;
    }
}
