package com.myapps.customstepview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.myapps.stepindicator.Callback_OnStepClickListener;
import com.myapps.stepindicator.StepIndicatorLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StepIndicatorLayout stepsView1, stepsView2, stepsView3, stepsView4;
    private Button main_BTN_button1, main_BTN_button2, main_BTN_button3, main_BTN_button4;
    List<String> labels = Arrays.asList("Step 1", "Step 2", "Step 3", "Step 4");
    List<String> labels4 = Arrays.asList("Register", "Verify", "Finish");
    //private int counter = 1;
    private int counter1 = 1;
    private int counter2 = 1;
    private int counter3 = 1;
    private int counter4 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();


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

       stepsView2.setIndicatorView(this,
               3,
               R.color.colorPrimary,
               4,
               R.color.colorPrimaryDark,
               5,
               2,
               R.drawable.ic_check,
               15,
               new Callback_OnStepClickListener() {
           @Override
           public void onStepClick(int step) {
               Toast.makeText(MainActivity.this, step + " Clicked!!", Toast.LENGTH_SHORT).show();
           }
       });

       // Amount of labels must be == amount of circles
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


        // Amount of labels must be == amount of circles
        stepsView4.setIndicatorView(this,
                3,
                R.color.green,
                4,
                R.color.gray,
                5,
                2,
                R.drawable.ic_arrow,
                40,
                labels4,
                40,
                R.color.black,
                new Callback_OnStepClickListener() {
                    @Override
                    public void onStepClick(int step) {
                        Toast.makeText(MainActivity.this, step + " Clicked!!", Toast.LENGTH_SHORT).show();
                    }
                });



        main_BTN_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView1.nextStep(counter1);
                counter1++;

                if (stepsView1.isLastStep(counter1)) {
                    main_BTN_button1.setEnabled(false);
                }
            }
        });

        main_BTN_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView2.nextStep(counter2);
                counter2++;

                if (stepsView2.isLastStep(counter2)) {
                    main_BTN_button2.setEnabled(false);
                }
            }
        });

        main_BTN_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView3.nextStep(counter3);
                counter3++;

                if (stepsView3.isLastStep(counter3)) {
                    main_BTN_button3.setEnabled(false);
                }
            }
        });

        main_BTN_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView4.nextStep(counter4);
                counter4++;

                if (stepsView4.isLastStep(counter4)) {
                    main_BTN_button4.setEnabled(false);
                }
            }
        });
    }

    private void setViews() {
        stepsView1 = findViewById(R.id.stepsView1);
        main_BTN_button1 = findViewById(R.id.main_BTN_button1);

        stepsView2 = findViewById(R.id.stepsView2);
        main_BTN_button2 = findViewById(R.id.main_BTN_button2);

        stepsView3 = findViewById(R.id.stepsView3);
        main_BTN_button3 = findViewById(R.id.main_BTN_button3);

        stepsView4 = findViewById(R.id.stepsView4);
        main_BTN_button4 = findViewById(R.id.main_BTN_button4);
    }
}