package com.umpay.four_view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller
import org.jetbrains.anko.bottomPadding
import org.jetbrains.anko.leftPadding
import org.jetbrains.anko.rightPadding
import org.jetbrains.anko.topPadding

/**
 * Created by sage on 16-9-5.
 */
class VV : View {

    constructor(context: Context) : super(context) {
        log("constructor(context: Context)")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        log("constructor(context: Context, attrs: AttributeSet)")
        paint = Paint()
        paint.isAntiAlias = true
        val type = context.obtainStyledAttributes(attrs, R.styleable.ViewStyle)
        val c = type.getColor(R.styleable.ViewStyle_view_color, Color.BLUE)
        paint.color = c
        type.recycle()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        log("constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)")
    }

    lateinit var paint: Paint


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

        return true
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        log("dispatchTouchEvent")

        return super.dispatchTouchEvent(event)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        log("setOnClickListener")
    }


    val scroller = Scroller(this.context)
    override fun computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.currX, scroller.currY)
            postInvalidate()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, 300)
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, 300)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val lastWidth = width - leftPadding - rightPadding
        val lastHeight = height - topPadding - bottomPadding
        val radius = Math.min(lastHeight, lastWidth) / 2

        canvas.drawCircle(leftPadding + lastWidth / 2f, topPadding + lastHeight / 2f, radius.toFloat(), paint)
    }
}

fun Any.log(msg: String) {
    Log.i(this.javaClass.simpleName, msg)
}