package com.umpay.four_view2

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout

/**
 * Created by sage on 16-9-6.
 */
class LL : LinearLayout {

    constructor(context: Context) : super(context) {
        log("ll constructor(context: Context)")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        log("ll constructor(context: Context, attrs: AttributeSet)")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        log("ll constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)")
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        log("ll oninterceptTouchEvent")
//        return super.onInterceptTouchEvent(ev)
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                log("ll ontouchEvent action_move")
            }
            MotionEvent.ACTION_DOWN -> log("ll ontouchEvent action_down")
            MotionEvent.ACTION_UP -> log("ll ontouchEvent action_up")
        }
        return super.onTouchEvent(event)
//        return true
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        log("ll dispatchTouchEvent ")
        return super.dispatchTouchEvent(ev)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        log("ll setOnClickListener")
    }
}