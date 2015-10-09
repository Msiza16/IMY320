package com.project.imy320.spaceboy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by NPMsiza on 10/9/2015.
 */
public class TimeTableEditor extends Fragment{

        String color;
        String Tname;
        View rootView;
        public TimeTableEditor() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
             rootView= inflater.inflate(R.layout.calendar_view_fragment, container, false);
            color="";
            Tname="";
            return rootView;
        }
        public void Color(View v)
        {
            Button btn= (Button)v;
            Drawable d=btn.getBackground();
            Toast.makeText(rootView.getContext(),d.toString(),Toast.LENGTH_LONG).show();

        }
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
        }

        @Override
        public void onDetach() {
            super.onDetach();
        }

        @Override
        public void onResume() {
            super.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
        }
    }
