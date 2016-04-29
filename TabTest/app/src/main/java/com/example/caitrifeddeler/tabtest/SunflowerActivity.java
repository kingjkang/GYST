package com.example.caitrifeddeler.tabtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CaitriFeddeler on 4/29/16.
 */
public class SunflowerActivity  extends Activity
{

    Globals variables = Globals.getInstance();
    int updatedStreak = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        TextView  tv=new TextView(this);
        tv.setTextSize(25);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setText("This is Sunflower Activity");

        setContentView(tv);

        //This is what happens when an event is attended
        Button attendedButton = (Button) findViewById(R.id.attendedEvent);
        attendedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendedEvent();
            }
        });


        //This is what happens when an event is missed
        Button missedButton = (Button) findViewById(R.id.missedEvent);
        missedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                missedEvent();
            }
        });

        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }
    public void attendedEvent(){
        updatedStreak = variables.getStreak() + 1;
        variables.setStreak(updatedStreak);
        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));

        int updatedPetals = variables.getPetals() + 1;
        //This takes into account that the user has more than 20 petals
        if(updatedPetals>20){
            updatedPetals=20;
        }
        variables.setPetals(updatedPetals);
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }
    public void missedEvent(){
        variables.setStreak(0);
        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));

        int updatedPetals = variables.getPetals() -1;
        //this takes into account the user has less than 0 petals
        if(updatedPetals<0){
            updatedPetals=0;
        }
        variables.setPetals(updatedPetals);
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }
    public int chooseFlower(){
//        String temp = "sunflower" + variables.getPetals();
//        System.out.println(temp);
//        return R.mipmap.temp;
        if (variables.getPetals() == 0){
            return R.mipmap.sunflower0;
        }
        else if (variables.getPetals() == 1){
            return R.mipmap.sunflower1;
        }
        else if (variables.getPetals() == 2){
            return R.mipmap.sunflower2;
        }
        else if (variables.getPetals() == 3){
            return R.mipmap.sunflower3;
        }
        else if (variables.getPetals() == 4){
            return R.mipmap.sunflower4;
        }
        else if (variables.getPetals() == 5){
            return R.mipmap.sunflower5;
        }
        else if (variables.getPetals() == 6){
            return R.mipmap.sunflower6;
        }
        else if (variables.getPetals() == 7){
            return R.mipmap.sunflower7;
        }
        else if (variables.getPetals() == 8){
            return R.mipmap.sunflower8;
        }
        else if (variables.getPetals() == 9){
            return R.mipmap.sunflower9;
        }
        else if (variables.getPetals() == 10){
            return R.mipmap.sunflower10;
        }
        else if (variables.getPetals() == 11){
            return R.mipmap.sunflower11;
        }
        else if (variables.getPetals() == 12){
            return R.mipmap.sunflower12;
        }
        else if (variables.getPetals() == 13){
            return R.mipmap.sunflower13;
        }
        else if (variables.getPetals() == 14){
            return R.mipmap.sunflower14;
        }
        else if (variables.getPetals() == 15){
            return R.mipmap.sunflower15;
        }
        else if (variables.getPetals() == 16){
            return R.mipmap.sunflower16;
        }
        else if (variables.getPetals() == 17){
            return R.mipmap.sunflower17;
        }
        else if (variables.getPetals() == 18){
            return R.mipmap.sunflower18;
        }
        else if (variables.getPetals() == 19){
            return R.mipmap.sunflower19;
        }
        else if (variables.getPetals() == 20){
            return R.mipmap.sunflower20;
        }
        else {
            return R.mipmap.sunflower20;
        }
    }
}

