package example.com.zoompinch.widget

import android.content.Context
import android.view.MotionEvent
import android.view.GestureDetector
import android.text.method.Touch.onTouchEvent
import android.view.ScaleGestureDetector
import android.support.v4.view.GestureDetectorCompat
import android.util.AttributeSet
import android.widget.FrameLayout

class FrameTouch : FrameLayout, ScaleGestureDetector.OnScaleGestureListener {

    internal var detector: GestureDetectorCompat?
    internal var scaleDetector: ScaleGestureDetector? = null
    internal var frameOnTouch: FrameOnTouch? = null

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        return true
    }

    override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
        return true
    }

    override fun onScaleEnd(detector: ScaleGestureDetector) {

    }

    interface FrameOnTouch {
        fun onFrameTouchUp()
        fun onScrollMovie(x: Float, y: Float)
    }

    constructor(context: Context) : super(context) {
        detector = GestureDetectorCompat(context, MyGestureListener())
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        detector = GestureDetectorCompat(context, MyGestureListener())
        scaleDetector = ScaleGestureDetector(context, this)
    }

    fun setFrameOnTouch(frameOnTouch: FrameOnTouch) {
        this.frameOnTouch = frameOnTouch
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP)
            frameOnTouch?.onFrameTouchUp()

        super.dispatchTouchEvent(event)
        return detector!!.onTouchEvent(event)

    }

    private inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            frameOnTouch!!.onScrollMovie(distanceX, distanceY)

            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            return super.onSingleTapUp(e)
        }
    }
}