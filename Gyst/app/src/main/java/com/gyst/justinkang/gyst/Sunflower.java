package com.gyst.justinkang.gyst;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Sunflower.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Sunflower#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sunflower extends android.app.Fragment{

    Globals variables = Globals.getInstance();
    int updatedStreak = 0;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunflower,
                container, false);

        Button updateButton = (Button) view.findViewById(R.id.testButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedStreak = variables.getStreak() + 1;
                variables.setStreak(updatedStreak);
                TextView streak = (TextView)getActivity().findViewById(R.id.streak);
                streak.setText(Integer.toString(variables.getStreak()));
            }
        });//this block of code works and changes the text so to change the image its the same thing
        //just need a different kind of listener such as a propertylistener so we can update the imageview
        //but bug** when i leave the page and come back it just make it back to the default again
        //what if i want it to change permanenelty

        Button resetStreak = (Button) view.findViewById(R.id.resetStreak);
        resetStreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variables.setStreak(0);
                TextView streak = (TextView)getActivity().findViewById(R.id.streak);
                streak.setText(Integer.toString(variables.getStreak()));
            }
        });

        Button increasePetals = (Button) view.findViewById(R.id.increasePetals);
        increasePetals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedPetals = variables.getPetals() + 1;
                variables.setPetals(updatedPetals);
                ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
                flower.setImageResource(chooseFlower());
            }
        });

        Button resetPetals = (Button) view.findViewById(R.id.resetPetals);
        resetPetals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variables.setPetals(0);
                ImageView flower = (ImageView) getActivity().findViewById(R.id.sunflower);
                flower.setImageResource(chooseFlower());
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView streak = (TextView)getActivity().findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));
        ImageView flower = (ImageView) getActivity().findViewById(R.id.sunflower);
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
            return R.mipmap.sunflowertest;
        }
    }

}
