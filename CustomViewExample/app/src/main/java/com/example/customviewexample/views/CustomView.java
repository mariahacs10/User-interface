package com.example.customviewexample.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customviewexample.R;

/* Subclass a View

    All of the view classes defined in the Android framework
    extend View. Your custom view can also extend View directly,
    or you can save time by extending one of the existing view
    subclasses, such as Button.
*/
public class CustomView extends View {

    private static final int SQUARE_SIZE = 200;

    private Rect mRectSquare;
    private Paint mPaintSquare;

    private int mSquareColor;

    private Paint mPaintCircle;

    private float mCircleX, mCircleY;
    private  float mCircleRadius = 100f;

    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

    }

    private void init(@Nullable AttributeSet set)
    {
        mRectSquare = new Rect();

        /* Create Drawing Objects

           For instance, Canvas provides a method to draw a line,
           while Paint provides methods to define that line's
           color. Canvas has a method to draw a rectangle,
           while Paint defines whether to fill that rectangle
           with a color or leave it empty. Simply put, Canvas
           defines shapes that you can draw on the screen, while
           Paint defines the color, style, font, and so forth of
           each shape you draw.*/

        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintCircle = new Paint();
        mPaintSquare.setAntiAlias(true);
        mPaintCircle.setColor(Color.parseColor("#00ccff"));

        if(set == null)
            return;

        /*Apply Custom Attributes

           When a view is created from an XML layout,
           all of the attributes in the XML tag
           are read from the resource bundle and
           passed into the view's constructor as an
           AttributeSet. */
        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = ta.getColor(R.styleable.CustomView_square_color, Color.BLUE);

        mPaintSquare.setColor(mSquareColor);
           ta.recycle();
    }

    public void swapColor()
    {
        mPaintSquare.setColor(mPaintSquare.getColor() == Color.BLUE ? Color.GRAY : Color.BLUE);

        /*Add Properties and Events

            Attributes are a powerful way of controlling
            the behavior and appearance of views, but they can
            only be read when the view is initialized. To provide
            dynamic behavior, expose a property getter and
            setter pair for each custom attribute.
        */
        postInvalidate();
    }


    /* Override onDraw()

        The most important step in drawing a custom view
        is to override the onDraw() method. The parameter
        to onDraw() is a Canvas object that the view can use to
        draw itself. The Canvas class defines methods for drawing
        text, lines, bitmaps, and many other graphics primitives.
         You can use these methods in onDraw() to create your
        custom user interface (UI).*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectSquare.left = 50;
        mRectSquare.top= 50;
        mRectSquare.right = mRectSquare.left + SQUARE_SIZE;
        mRectSquare.bottom = mRectSquare.top + SQUARE_SIZE;

        canvas.drawRect(mRectSquare, mPaintSquare);

        if(mCircleX == 0f || mCircleY == 0f)
        {
            mCircleX = getWidth()/2;
            mCircleY = getHeight()/2;
        }

        canvas.drawCircle(mCircleX,mCircleY, mCircleRadius, mPaintCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        //Handle Layout Events
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:{
                float x =  event.getX();
                float y = event.getY();

                if(mRectSquare.left < x && mRectSquare.right > x)
                    if(mRectSquare.top < y && mRectSquare.bottom > y)
                    {
                        mCircleRadius += 10f;
                        postInvalidate();
                    }

                return true;
            }

            case MotionEvent.ACTION_MOVE:{

                float x =  event.getX();
                float y = event.getY();

                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                if(dx + dy < Math.pow(mCircleRadius, 2))
                {
                    mCircleX = x;
                    mCircleY = y;

                    postInvalidate();

                    return true;
                }

                return value;
            }
        }
        return  value;
    }
}
