# Custom Step View
This library is a set of simple wrapper that was created to help you easily make a customizable Step Indicator.

<img src="https://github.com/TalBar4444/CustomStepView/blob/master/screenshot.png" width="300">

## Setup
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```
## Usage

#### classic CustomStepView
Displays a classic Step Indicator. 

```java
        stepsView1.setIndicatorView(this,
                	5,
                        R.color.orange,
                        4,
                        R.color.darker_gray,
                        5,
                        3,
                        R.color.navy,
                        5,
                        new Callback_OnStepClickListener() {
            @Override
            public void onStepClick(int step) {
                Toast.makeText(MainActivity.this, step + " Clicked!!", Toast.LENGTH_SHORT).show();
            }
        });
```

#### CustomStepView with labels
Displays a Step Indicator with customizable labels

```java
     stepsView3.setIndicatorView(this,
                4,
                R.color.colorAccent,
                4,
                R.color.colorPrimary,
                5,
                3,
                R.drawable.ic_like,
                10,
                labels,
                40,
                R.color.black,
                new Callback_OnStepClickListener() {
                    @Override
                    public void onStepClick(int step) {
                        Toast.makeText(MainActivity.this, step + " Clicked!!", Toast.LENGTH_SHORT).show();
                    }
                });
```

# Existing Functionality
Below is a list of the main functionalities:

### `setIndicatorView(Context context,
                      int stepsCount,
                      int lineColor,
                      int lineStrokeWidth,
                      int circleColor,
                      int circleStrokeWidth,
                      int stepRadius,
                      int stepIconOrColor,
                      int padding,
                      Callback_OnStepClickListener listener)`

- **Description**: Initializes the `StepIndicatorView` with the specified number of steps, colors and strokes for lines and circles.
- **stepIconOrColor**: Determines whether to use an icon or a color for the steps
- **listener**: a click listener for handling step clicks

  ### `setIndicatorView(Context context,
                      int stepsCount,
                      int lineColor,
                      int lineStrokeWidth,
                      int circleColor,
                      int circleStrokeWidth,
                      int stepRadius,
                      int stepIconOrColor,
                      int padding,
                      List<String> stepLabels,
                      int textSize,
                      int textColor,
                      Callback_OnStepClickListener listener)`

  - **Description**: Initializes the `StepIndicatorView` with customizable options for the number of steps, colors, text appearance, and labels.
  - This function configures the step indicator's appearance and behavior based on the provided parameters, making it easy to create a fully customized step indicator

  - **stepLabels**: A list of strings that represent labels for each step. These labels are displayed above the circles in the step indicator. If the list is null or empty, no labels will be shown.
    - **Example**: If you have 5 steps and want labels like ["Step 1", "Step 2", "Step 3", "Step 4", "Step 5"], pass these as a `List<String>` to this parameter.


### `nextStep(int currentStep)`

- **Description**: Fills the next circle in the step indicator and updates the current step.
 This function is typically called when the user clicks a button to advance to the next step.


## License

    Copyright 2024 Tal Bar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
      
## Credits
Icon made by Flat Icons (www.flat-icons.com) from www.flaticon.com
