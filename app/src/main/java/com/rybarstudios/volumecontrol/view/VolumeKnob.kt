package com.rybarstudios.volumecontrol.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.lang.Math.min



private const val MIN_ROTATION = 0f
private const val MAX_ROTATION = 270f
private const val ROTATION_FACTOR = 95

class VolumeKnob(context: Context?, attrs: AttributeSet?) : View(context, attrs){

    private val outerCircle = Paint(Paint.ANTI_ALIAS_FLAG)
    private val innerCircle = Paint(Paint.ANTI_ALIAS_FLAG)
    private val knob = Paint(Paint.ANTI_ALIAS_FLAG)

    private var startX: Float = 0f
    private var diffX: Float = 0f
    private var circleRotation: Float = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
            }
            MotionEvent.ACTION_MOVE -> {
                diffX = (event.x - startX) / ROTATION_FACTOR
                circleRotation += diffX

                if (circleRotation < MIN_ROTATION) {
                    circleRotation = MIN_ROTATION
                }
                if (circleRotation > MAX_ROTATION) {
                    circleRotation = MAX_ROTATION
                }
                invalidate()
                }
            MotionEvent.ACTION_UP -> {

            }
        }
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

        canvas?.rotate(circleRotation, cX, cY)

        canvas?.rotate(rotation, cX, cY)
        canvas?.drawCircle(cX, cY, min(cX, cY) * 0.8f, outerCircle)
        canvas?.drawCircle(cX, cY, min(cX, cY) * 0.7f, innerCircle)
        canvas?.drawCircle(cX - 260, cY + 270, min(cX, cY) * 0.08f, knob)

        super.onDraw(canvas)
    }
}