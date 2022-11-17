package com.padc.ponnya.thelibraryapp.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.padc.ponnya.thelibraryapp.R

class StraightProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val path = Path()

    private val paint = Paint().apply {
        style = Paint.Style.FILL

    }

    private var progress: Int = 0
    private var mBackgroundColor = Color.GRAY
    private var progressBarColor = Color.BLACK

    init {
        context.withStyledAttributes(attrs, R.styleable.StraightProgressBar){
            progress = getInt(R.styleable.StraightProgressBar_progressNumber,progress)
            mBackgroundColor = getColor(R.styleable.StraightProgressBar_backgroundLineColor,mBackgroundColor)
            progressBarColor = getColor(R.styleable.StraightProgressBar_progressBarColor,progressBarColor)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        paint.strokeWidth = height.toFloat()

        drawInnerLine(canvas)
        drawOuterLine(canvas)
        super.onDraw(canvas)

    }

    private fun drawInnerLine(canvas: Canvas?) {
        paint.color = mBackgroundColor
        canvas?.drawLine(0f, height/2f, width.toFloat(), height/2f, paint)
    }

    private fun drawOuterLine(canvas: Canvas?) {
        paint.color = progressBarColor
        canvas?.drawLine(0f, height/2f, width * progress/100f, height/2f, paint)

    }
}