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
public class Sunflower extends android.app.Fragment implements PropertyChangeListener{

    Globals streakCount = Globals.getInstance();
    int updatedStreak = 0;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunflower,
                container, false);
        //need to do some sort of switch case so i can put different flowers based on numbers

        //streak.setText(Integer.toString(streakCount.getStreak()));

        Button updateButton = (Button) view.findViewById(R.id.testButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView streak = (TextView)getActivity().findViewById(R.id.streak);
                streak.setText(Integer.toString(streakCount.getStreak()));
                updatedStreak = streakCount.getStreak() + 1;
                streakCount.setStreak(updatedStreak);
                ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
                flower.setImageResource(R.mipmap.sunflowerseedtest);
            }
        });//this block of code works and changes the text so to change the image its the same thing
        //just need a different kind of listener such as a propertylistener so we can update the imageview
        //but bug** when i leave the page and come back it just make it back to the default again
        //what if i want it to change permanenelty

//        if (GYSTHome.numOfPetals == 0){
//            ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
//            flower.setImageResource(R.mipmap.sunflowerseedtest);
//        }
//
//        if (streakCount.getStreak() == 1){
//            ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
//            flower.setImageResource(R.mipmap.sunflowerseedtest);
//        }
//        else if (streakCount.getStreak() == 2){
//            ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
//            flower.setImageResource(R.mipmap.sunflowertest);
//        }


        return view;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if (streakCount.getStreak() == 1){
            ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
            flower.setImageResource(R.mipmap.sunflowerseedtest);
        }
        else if (streakCount.getStreak() == 2){
            ImageView flower = (ImageView)getActivity().findViewById(R.id.sunflower);
            flower.setImageResource(R.mipmap.sunflowertest);
        }
    }

}
