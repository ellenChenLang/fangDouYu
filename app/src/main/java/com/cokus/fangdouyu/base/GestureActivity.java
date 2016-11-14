package com.cokus.fangdouyu.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GestureActivity extends AppCompatActivity implements OnTouchListener ,OnGestureListener{
	private GestureDetector mGestureDetector;

	@Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGestureDetector = new GestureDetector((OnGestureListener) this);
    }
 
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }
 
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }
 
    @Override
    public void onShowPress(MotionEvent e) {
 
    }
 
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
 
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
 
    @Override
    public void onLongPress(MotionEvent e) {
 
    }
 
    private int verticalMinDistance = 20;
    private int minVelocity = 0;
 
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(e2.getY() - e1.getY()) > 200) {//这里是避免有scroolview的页面上划也关闭
            return false;
        }
        if (e1.getX() - e2.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {//左滑操作
        } else if (e2.getX() - e1.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {//右滑操作
            finish();
        }
 
        return false;
    }
}
