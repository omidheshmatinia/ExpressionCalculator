package com.github.omidheshmatinia.expressioncalculator.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class RippleView extends View{
    private int duration = 800 ;
    private int radius = 0 ;
    private Paint paint = new Paint();
    private int color=Color.parseColor("#4CAF50");
    public RippleView(Context context) {
        super(context);
    }

    public RippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void beginRipple(){
        paint.setColor(color);
        int maxRadius = Math.max(getWidth(),getHeight());
        animateCircle(radius,maxRadius);
    }

    public void reverseRipple(){
        paint.setColor(color);
        int maxRadius = radius;
        animateCircle(maxRadius,0);
    }

    private void animateCircle(int... items){
        ValueAnimator anim=ValueAnimator.ofInt(items);
        anim.addUpdateListener(valueAnimator ->{
                radius = (int) valueAnimator.getAnimatedValue();
                invalidate();
        });
        anim.setDuration(duration);
        anim.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        if(radius > 0) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius,paint);
        }
    }
}
