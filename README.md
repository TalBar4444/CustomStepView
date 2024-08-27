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

#### classic CustomStepView - Displays a classic Step Indicator

```java
        stepsView.setIndicatorView(this, 5, R.color.orange, 4, R.color.darker_gray, 5, 3, R.color.navy, 5, new Callback_OnStepClickListener() {
            @Override
            public void onStepClick(int step) {
                Toast.makeText(MainActivity.this, step + " Clicked!!", Toast.LENGTH_SHORT).show();
            }
        });
```
Or
#### CustomStepView with labels - Displays a Step Indicator with customizable labels

```java
     stepsView3.setIndicatorView(this, 4, R.color.colorAccent, 4, R.color.colorPrimary, 5, 3, R.drawable.ic_like, 10, labels, 40, R.color.black, new Callback_OnStepClickListener() {
                    @Override
                    public void onStepClick(int step) {
                        Toast.makeText(MainActivity.this, step + " Clicked!!", Toast.LENGTH_SHORT).show();
                    }
                });
```
		      
## parameters
 
- Context `context`: The context in which the view is being used. This is usually the activity or fragment that contains the step indicator.

- int `stepsCount`: The total number of steps in the step indicator. This determines how many circles will be drawn in the indicator.

- int `lineColor`: The color of the lines that connect the circles. This can be a reference to a color resource (e.g. R.color.lineColor) or a direct color value.

- int `lineStrokeWidth`: The Width of the stroke line 

- int `circleColor`: The color of the empty circles that represent steps that have not yet been completed. This can also be a color resource or a direct color value.

- int `circleStrokeWidth`: The Width of the stroke circle 

- int `stepRadius`: The size circle radius

- int `stepIconOrColor`:  Determines whether to use an icon or a color for a specific step, and applies it accordingly.

- int `padding`: padding for the all step Indicator

- int `textColor`: The color of the text that appears as labels above the steps. This can be a color resource or a direct color value.

- int `textSize`: The size of the text used for the labels above the steps. This value is in pixels, and it determines how large the text will appear.

- List<String> `stepLabels`: A list of strings that represent labels for each step. These labels are displayed above the circles in the step indicator. If the list is null or empty, no labels will be shown.
   **Example**: If you have 5 steps and want labels like ["Step 1", "Step 2", "Step 3", "Step 4", "Step 5"], pass these as a `List<String>` to this parameter.

- `listener`: A callback interface that is triggered when a user clicks on a step. This allows you to handle step click events, such as showing a message or performing an action when a specific step is clicked.

### function `nextStep(int currentStep)`

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
