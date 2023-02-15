package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable diceAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.diceImage);
        iv.setBackgroundResource(R.drawable.animation_list);
        diceAnimation = (AnimationDrawable) iv.getBackground();

        myButtonListener();
        myButtonListener2();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        diceAnimation.start();
    }

    public void myButtonListener2(){
        Button button = (Button) findViewById(R.id.resetButton);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                TextView rollResult = (TextView) findViewById(R.id.rollResult);
                rollResult.setText("Roll Again!");
                ImageView img = (ImageView) findViewById(R.id.diceImage);
                img.setImageResource(0);
//                img.setImageResource(R.drawable.dicegeneral);
                img.setBackgroundResource(R.drawable.animation_list);
                diceAnimation = (AnimationDrawable) img.getBackground();
                diceAnimation.start();
            }
        });
    }
    public void myButtonListener(){
        Button button = (Button) findViewById(R.id.rollButton);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                diceAnimation.stop();
                Random random = new Random();
                int rollResult = random.nextInt(6)+1;

                TextView diceResult = (TextView) findViewById(R.id.rollResult);
                diceResult.setTextSize(25);
                diceResult.setText("Rolled! Lucky Number "+Integer.toString(rollResult));

                ImageView img = (ImageView) findViewById(R.id.diceImage);

                switch (rollResult) {
                    case 1:
                        img.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        img.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        img.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        img.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        img.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        img.setImageResource(R.drawable.dice_6);
                        break;
                }

            }
        });
    }
}