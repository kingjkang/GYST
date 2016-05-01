package com.example.caitrifeddeler.GYST;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GYSTflower extends Activity {

    Globals variables = Globals.getInstance();
    int updatedStreak = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_gystflower);

//        Button attendedButton = (Button) findViewById(R.id.attendedEvent);
//        attendedButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                attendedEvent();
//            }
//        });
//
//
//        //This is what happens when an event is missed
//        Button missedButton = (Button) findViewById(R.id.missedEvent);
//        missedButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                missedEvent();
//            }
//        });

        Random qq = new Random();
        int  quoteNum = qq.nextInt(10) + 1;
        TextView quote = (TextView) findViewById(R.id.motivationalQuote);
        quote.setText(chooseQuote(quoteNum));
        TextView author = (TextView) findViewById(R.id.motivationalAuthor);
        author.setText(chooseAuthor(quoteNum));

        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        // TODO Auto-generated method stub
        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());

        Random qq = new Random();
        int  quoteNum = qq.nextInt(10) + 1;
        TextView quote = (TextView) findViewById(R.id.motivationalQuote);
        quote.setText(chooseQuote(quoteNum));
        TextView author = (TextView) findViewById(R.id.motivationalAuthor);
        author.setText(chooseAuthor(quoteNum));
    }


    @Override
    protected void onResume()
    {
        // TODO Auto-generated method stub
        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
        super.onResume();
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

    public int chooseQuote(int quoteNum){
        if (quoteNum == 1){
            return R.string.q1;
        }
        else if(quoteNum == 2){
            return R.string.q2;
        }
        else if(quoteNum == 3){
            return R.string.q3;
        }
        else if(quoteNum == 4){
            return R.string.q4;
        }
        else if(quoteNum == 5){
            return R.string.q5;
        }
        else if(quoteNum == 6){
            return R.string.q6;
        }
        else if(quoteNum == 7){
            return R.string.q7;
        }
        else if(quoteNum == 8){
            return R.string.q8;
        }
        else if(quoteNum == 9){
            return R.string.q9;
        }
        else{
            return R.string.q10;
        }
    }

    public int chooseAuthor(int quoteNum){
        if (quoteNum == 1){
            return R.string.a1;
        }
        else if(quoteNum == 2){
            return R.string.a2;
        }
        else if(quoteNum == 3){
            return R.string.a3;
        }
        else if(quoteNum == 4){
            return R.string.a4;
        }
        else if(quoteNum == 5){
            return R.string.a5;
        }
        else if(quoteNum == 6){
            return R.string.a6;
        }
        else if(quoteNum == 7){
            return R.string.a7;
        }
        else if(quoteNum == 8){
            return R.string.a8;
        }
        else if(quoteNum == 9){
            return R.string.a9;
        }
        else{
            return R.string.a10;
        }
    }

}

