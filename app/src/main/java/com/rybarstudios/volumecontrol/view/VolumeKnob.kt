package com.rybarstudios.volumecontrol.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.min

class VolumeKnob(context: Context?, attrs: AttributeSet?) : View(context, attrs){

    private val outerCircle = Paint(Paint.ANTI_ALIAS_FLAG)
    private val innerCircle = Paint(Paint.ANTI_ALIAS_FLAG)
    private val knob = Paint(Paint.ANTI_ALIAS_FLAG)

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var diffX: Float = 0f
    private var diffY: Float = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_UP -> {
                /*diffX = event.x - startX
                diffY = event.y - startY*/
            }
            MotionEvent.ACTION_MOVE -> {

            }
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        val cX: Float = (width / 2f)
        val cY: Float = (height / 2f)

        outerCircle.color = Color.BLACK

        innerCircle.color = Color.GREEN
        innerCircle.style = Paint.Style.STROKE
        innerCircle.strokeWidth = 4f

        knob.color = Color.RED

        canvas?.drawCircle(cX, cY, min(cX, cY) * 0.8f, outerCircle)
        canvas?.drawCircle(cX, cY, min(cX, cY) * 0.7f, innerCircle)
        canvas?.drawCircle(cX - 370, cY, min(cX, cY) * 0.09f, knob)
        super.onDraw(canvas)
    }
}