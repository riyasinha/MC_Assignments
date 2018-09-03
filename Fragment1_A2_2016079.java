package com.example.mc.assignment2_mc.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1_A2_2016079 extends Fragment {
    private Button start, pause;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment1_a2_2016079, container, false);

//        getActivity().setContentView(R.layout.fragment1_a2_2016079);

        start = view.findViewById(R.id.btnPlay);
        pause = view.findViewById(R.id.btnPause);

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(), Service_A2_2016079.class));
                System.out.println("wooo");

            }


        });
        pause.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(), Service_A2_2016079.class));

            }


        });

        return view;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//    public void onClick(View view)
//    {
//        if(view==start)
//        {
//            getActivity().startService(new Intent(getActivity(), Service_A2_2016079.class));
//        }
//        else if(view==pause)
//        {
//            getActivity().stopService(new Intent(getActivity(), Service_A2_2016079.class));
//
//        }
//    }
    }
}
