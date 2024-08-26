package com.myapps.stepindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class StepIndicatorView extends View {

    private int mStepsCount; // Default number of steps
    private int mCurrentStep;
    private int mStepRadius;
    private int mLineStrokeWidth;
    private int mCircleStrokeWidth;

    private int mTextSize;
    private int mTextColor;
    private int mLineColor;
    private int mCircleColor;
    private int mFilledCircleColor;

    private Paint mLinePaint = new Paint();
    private Paint mCirclePaint = new Paint();
    private Paint mFilledCirclePaint = new Paint();
    private Paint mTextPaint = new Paint();

    private int mPadding;
    private int mTextPadding = 20;

    private Drawable stepIcon = null;
    private List<String> stepLabels = new ArrayList<>();

    private Callback_OnStepClickListener callback_onStepClickListener;
    private Context mContext;


    public StepIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs,R.styleable.StepIndicatorView);
        try {
            mStepsCount = array.getInt(R.styleable.StepIndicatorView_stepsCount, 3);
            mLineColor = array.getColor(R.styleable.StepIndicatorView_lineColor, Color.CYAN);
            mLineStrokeWidth = array.getInt(R.styleable.StepIndicatorView_lineStrokeWidth, 4);
            mCircleColor = array.getColor(R.styleable.StepIndicatorView_circleColor, Color.MAGENTA);
            mCircleStrokeWidth = array.getInt(R.styleable.StepIndicatorView_circleStrokeWidth, 4);
            mStepRadius = array.getInt(R.styleable.StepIndicatorView_stepRadius, 2);
            mFilledCircleColor = array.getColor(R.styleable.StepIndicatorView_filledCircleColor, Color.YELLOW);
            mPadding = array.getDimensionPixelSize(R.styleable.StepIndicatorView_padding, 5);
            mTextColor = array.getColor(R.styleable.StepIndicatorView_textColor, Color.BLACK);

        }
        finally {
            array.recycle();
        }
    }

    public void setStepCount(int stepsCount) {
        mStepsCount = stepsCount;
        invalidate();
    }

    public void setLineColor(int lineColor) {
        mLineColor = lineColor;
        mLinePaint.setColor(lineColor);
        invalidate();
    }

    public void setLineStrokeWidth(int lineStrokeWidth) {
        mLineStrokeWidth = lineStrokeWidth;
        mLinePaint.setStrokeWidth(mLineStrokeWidth);
        invalidate();
    }

    public void setCircleColor(int circleColor) {
        mCircleColor = circleColor;
        mCirclePaint.setColor(mCircleColor);
        invalidate();
    }

    public void setCircleStrokeWidth(int circleStrokeWidth) {
        mCircleStrokeWidth = circleStrokeWidth;
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(mCircleStrokeWidth);
        invalidate();
    }

    public void setStepRadius(int stepRadius) {
        mStepRadius = stepRadius;
        invalidate();
    }

    public void setCircleFill(int filledCircle) {
        try { // if filledCircle is a color
            mFilledCircleColor = ContextCompat.getColor(getContext(), filledCircle);
            mFilledCirclePaint.setColor(mFilledCircleColor);
            mFilledCirclePaint.setStyle(Paint.Style.FILL);
            this.stepIcon = null;
        } catch (Resources.NotFoundException e) {
            // If filledCircle is a drawable icon
            stepIcon = ContextCompat.getDrawable(getContext(), filledCircle);
            mFilledCircleColor = Color.TRANSPARENT;
        }

        invalidate();
    }

    public void setPadding(int padding) {
        mPadding = padding;
        invalidate();
    }

    public void setLabels(List<String> list) {
        stepLabels = list;
        invalidate();
    }


    public void setTextColor(int textColor) {
        mTextColor = textColor;
        mTextPaint.setColor(mTextColor);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        invalidate();
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        invalidate();
    }

    public void setCallback_onStepClick(Callback_OnStepClickListener callback_onStepClickListener) {
        this.callback_onStepClickListener = callback_onStepClickListener;
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback_onStepClickListener != null && !isEnabled()) {
                    callback_onStepClickListener.onStepClick(mCurrentStep);
                    Log.d("mylog","callbackClicked");
                }
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int stepRadius = (height / this.mStepRadius) - mPadding;  // Subtract padding from radius

        int stepSpacing = (width - (stepRadius * 2 * mStepsCount) - mPadding * 2 * (mStepsCount -1)) / (mStepsCount - 1);
        int iconSize = stepRadius;

        int circleY = height / 2 + mTextPadding / 2;

        for (int i = 0; i < mStepsCount; i++) {
            int x = mPadding + i * (stepRadius * 2 + stepSpacing) + stepRadius;

            // Draw the connecting line
            if (i > 0) {
                int previousX = mPadding  + (i - 1) * (stepRadius * 2 + stepSpacing) + stepRadius;
                canvas.drawLine(previousX + stepRadius, circleY, x - stepRadius, circleY, mLinePaint);
            }

            // Draw the step circles
            if (i < mCurrentStep) {
                if (stepIcon != null){
                    stepIcon.setBounds(x - iconSize, circleY - iconSize, x + iconSize, circleY + iconSize);
                    canvas.save();
                    // Clip the canvas to the circle's bounds
                    canvas.clipRect(x - stepRadius, circleY - stepRadius, x + stepRadius, circleY + stepRadius);
                    stepIcon.draw(canvas);
                    // Reset the canvas clip
                    canvas.restore();
                }
                else {
                    canvas.drawCircle(x, circleY, stepRadius, mFilledCirclePaint);
                }
            } else {
                canvas.drawCircle(x, circleY, stepRadius, mCirclePaint);
            }

            // Draw the label above the circle
            if(stepLabels != null ){
                if (i < stepLabels.size()) {
                    String label = stepLabels.get(i);
                    canvas.drawText(label, x,circleY - stepRadius - this.mTextPadding, mTextPaint);  // Adjust the offset as needed
                }
            }
        }
    }

    public void setCurrentStep(int currentStep) {
        mCurrentStep = currentStep;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width  = measureDimension(getWidth(), widthMeasureSpec);
        int height = measureDimension(200, heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    protected int measureDimension( int defaultSize, int measureSpec ) {

        int result = defaultSize;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(defaultSize, specSize);
        } else {
            result = defaultSize;
        }

        return result;
    }
}
