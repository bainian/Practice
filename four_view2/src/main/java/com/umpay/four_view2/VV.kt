package com.umpay.four_view2

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller

/**
 * Created by sage on 16-9-5.
 */
class VV : View {

    constructor(context: Context) : super(context) {
        log("constructor(context: Context)")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        log("constructor(context: Context, attrs: AttributeSet)")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        log("constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)")
    }

    var mLastX = 0f;
    var mLastY = 0f;

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.rawX
        val y = event.rawY
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                log("ontouchEvent action_move")
//                val deltaX = x - mLastX
//                val deltaY = y - mLastY
//                ObjectAnimator.ofFloat(this, "translationX", mLastX, x).start()
//                ObjectAnimator.ofFloat(this, "translationY", mLastY, y).start()
            }
            MotionEvent.ACTION_DOWN -> {
                log("ontouchEvent action_down")
                return true
            }
            MotionEvent.ACTION_UP -> log("ontouchEvent action_up")
        }
        mLastX = x
        mLastY = y

        return false
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        log("dispatchTouchEvent")

        return super.dispatchTouchEvent(event)
    }


    val scroller = Scroller(this.context)
    override fun computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.currX, scroller.currY)
            postInvalidate()
        }
    }
}

fun Any.log(msg: String) {
    Log.i(this.javaClass.simpleName, msg)
}