package com.padc.ponnya.thelibraryapp.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.padc.ponnya.thelibraryapp.R

class CircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var path = Path()

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var firstArcColor = Color.BLUE
    private var secondArcColor = Color.BLACK
    private var thirdArcColor = Color.CYAN
    private var fourthArcColor = Color.GREEN
    private var innerCircleColor = Color.WHITE

    private var size = 0

    private lateinit var rectangle: RectF

    init {
        context.withStyledAttributes(attrs, R.styleable.CircleImageView) {
            firstArcColor = getColor(R.styleable.CircleImageView_firstArcColor, firstArcColor)
            secondArcColor = getColor(R.styleable.CircleImageView_secondArcColor, secondArcColor)
            thirdArcColor = getColor(R.styleable.CircleImageView_thirdArcColor, thirdArcColor)
            fourthArcColor = getColor(R.styleable.CircleImageView_fourthArcColor, fourthArcColor)
            innerCircleColor =
                getColor(R.styleable.CircleImageView_innerCircleColor, innerCircleColor)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        size = measuredWidth.coerceAtMost(measuredHeight)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    override fun onDraw(canvas: Canvas?) {

        drawOuterRectangle()
        drawOuterFirstArc(canvas)
        drawOuterSecondArc(canvas)
        drawOuterThirdArc(canvas)
        drawOuterFourthArc(canvas)
        drawInnerCircle(canvas)
        drawImageCircle(canvas)

        super.onDraw(canvas)
    }

    private fun drawOuterRectangle() {
        val outerCircleRadius = size / 2f
        rectangle = RectF(
            size / 2f - outerCircleRadius,
            size / 2f - outerCircleRadius,
            size / 2f + outerCircleRadius,
            size / 2f + outerCircleRadius
        )
    }

    private fun drawOuterFirstArc(canvas: Canvas?) {
        paint.color = firstArcColor
        canvas?.drawArc(rectangle, -45f, 100f, true, paint)
    }

    private fun drawOuterSecondArc(canvas: Canvas?) {
        paint.color = secondArcColor
        canvas?.drawArc(rectangle, 55f, 100f, true, paint)
    }

    private fun drawOuterThirdArc(canvas: Canvas?) {
        paint.color = thirdArcColor
        canvas?.drawArc(rectangle, 155f, 60f, true, paint)
    }

    private fun drawOuterFourthArc(canvas: Canvas?) {
        paint.color = fourthArcColor
        canvas?.drawArc(rectangle, 215f, 100f, true, paint)
    }

    private fun drawInnerCircle(canvas: Canvas?) {
        val radius = size * 0.45f
        paint.color = innerCircleColor
        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)
    }

    private fun drawImageCircle(canvas: Canvas?) {
        val radius = size * 0.40f
        path.addCircle(size / 2f, size / 2f, radius, Path.Direction.CCW)
        canvas?.clipPath(path)
    }
}