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

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

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

        paint.color = Color.CYAN

        canvas?.drawCircle((width / 2f), (height / 2f), min((width / 2f), (height / 2f)), paint)
        super.onDraw(canvas)
    }
}