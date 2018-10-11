package com.example.mc.assignment3_mc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuestionDisplayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;

    TextView tvques;
    RadioGroup rg;
    RadioButton rbtrue;
    RadioButton rbfalse;
    Button btnsave;
    ResponseDatabase rdb;
    public QuestionDisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionDisplayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionDisplayFragment newInstance(String param1, String param2) {
        QuestionDisplayFragment fragment = new QuestionDisplayFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_question_display, container, false);
        tvques = (TextView)view.findViewById(R.id.textView);
        rg = (RadioGroup) view.findViewById(R.id.radiogrp);
        rbfalse = (RadioButton)view.findViewById(R.id.radiobtn_false);
        //rbtrue = (RadioButton)view.findViewById(R.id.radiobtn_true);
        Bundle bundle = getArguments();
        String ans = bundle.getString("Question");
        String ans2 = bundle.getString("Ques");
        rdb = (ResponseDatabase)bundle.getSerializable("Database");
        tvques.setText(ans+": "+ans2);
        final String ques = ans2;
        final int quesno = Integer.parseInt(ans);
        final int selected = rg.getCheckedRadioButtonId();
        rbtrue = (RadioButton)view.findViewById(selected);
        btnsave = (Button)view.findViewById(R.id.btn_save);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected!=-1)
                {
                    rdb.editresponse( ques, String.valueOf(rbtrue.getText()),quesno);

                }
                getFragmentManager().popBackStackImmediate();

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
