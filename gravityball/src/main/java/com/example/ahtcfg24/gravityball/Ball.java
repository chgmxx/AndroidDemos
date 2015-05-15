package com.example.ahtcfg24.gravityball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * <p>Description: </p>
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/5/15
 */
public class Ball extends View
{
    private int x;
    private int y;
    private int radius;
    private double dx;
    private double dy;
    private Paint paint = new Paint();

    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public Ball(Context context)
    {
        super(context);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    public Ball(Context context, int radius)
    {
        this(context);
        this.radius = radius;
    }

   /* public Ball(Context context, int radius, int dx, int dy)
    {
        this(context, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public Ball(Context context, int radius, int step)
    {//TODO
        this(context, radius);
        this.dx = Math.abs(step) * Math.cos(Math.PI / 4) + 1;
        this.dy = Math.abs(step) * Math.sin(Math.PI / 4) + 1;
    }
*/

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, radius, paint);
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void move()
    {
        checkBorder();
        x += dx;
        y += dy;
        invalidate();
    }


    public void setDx(double dx)
    {
        this.dx = dx;
    }

    public void setDy(double dy)
    {
        this.dy = dy;
    }


    public boolean isBorderTop()
    {
        return y - radius <= 0;
    }

    public boolean isBorderBottom()
    {
        return y + radius >= getHeight();
    }

    public boolean isBorderLeft()
    {
        return x - radius <= 0;
    }

    public boolean isBorderRight()
    {
        return x + radius >= getWidth();
    }

    public void checkBorder()
    {
        if (isBorderTop())
            y = radius +1;
        else if (isBorderBottom())
            y = getHeight() - radius - 1;
        if (isBorderLeft())
            x = radius + 1;
        else if (isBorderRight())
            x = getWidth() - radius - 1;
    }
}
