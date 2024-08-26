package com.myapps.stepindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class StepIndicatorLayout extends LinearLayout {

    private int stepsCount;
    private List<String> stepLabels = null;
    private int mTextColor;
    private int mTextSize;
    
    public StepIndicatorView stepIndicatorView;

    public StepIndicatorLayout(Context context) {
        this(context, null);
    }

    public StepIndicatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StepIndicatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        stepIndicatorView = new StepIndicatorView(context,null);
    }

    public void setIndicatorView(Context context, int stepsCount, int lineColor, int lineStrokeWidth, int circleColor, int circleStrokeWidth, int stepRadius, int filledCircle, int padding, List<String> list, int textSize, int textColor, Callback_OnStepClickListener callbackOnStepClickListener) {
        stepLabels = new ArrayList<>();
        mTextSize = textSize;
        mTextColor = ContextCompat.getColor(context, textColor);
        stepLabels = list;

        setIndicatorView(context, stepsCount, lineColor, lineStrokeWidth, circleColor, circleStrokeWidth, stepRadius, filledCircle, padding, callbackOnStepClickListener);
    }

    // set circle color, circle frame color, and line color
    public void setIndicatorView(Context context, int stepsCount, int lineColor, int lineStrokeWidth, int circleColor, int circleStrokeWidth, int stepRadius, int filledCircle, int padding, Callback_OnStepClickListener callbackOnStepClickListener) {
        this.stepsCount = stepsCount;
        int mLineColor = ContextCompat.getColor(context, lineColor);
        int mCircleColor = ContextCompat.getColor(context, circleColor);

        setAllViewsElements(context, stepsCount, mLineColor, lineStrokeWidth, mCircleColor, circleStrokeWidth, stepRadius, filledCircle, padding, callbackOnStepClickListener);
    }

    private void setAllViewsElements(Context context, int stepsCount, int lineColor, int lineStrokeWidth, int circleColor, int circleStrokeWidth, int stepRadius, int filledCircle, int padding, Callback_OnStepClickListener callbackOnStepClickListener) {
        addView(stepIndicatorView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        stepIndicatorView.setStepCount(stepsCount);
        stepIndicatorView.setLineColor(lineColor);
        stepIndicatorView.setLineStrokeWidth(lineStrokeWidth);
        stepIndicatorView.setCircleColor(circleColor);
        stepIndicatorView.setCircleStrokeWidth(circleStrokeWidth);
        stepIndicatorView.setStepRadius(stepRadius);
        stepIndicatorView.setCircleFill(filledCircle);
        stepIndicatorView.setPadding(padding);
         if(stepLabels != null){
             stepIndicatorView.setLabels(stepLabels);
             stepIndicatorView.setTextColor(mTextColor);
             stepIndicatorView.setTextSize(mTextSize);
         }

        stepIndicatorView.setCallback_onStepClick(callbackOnStepClickListener);
        stepIndicatorView.invalidate();

    }

    public void nextStep(int currentStep) {
        if (currentStep <= stepsCount) {
            stepIndicatorView.setCurrentStep(currentStep);
        }
    }

    public boolean isLastStep(int currentStep) {
        return currentStep > stepsCount;

    }
}
