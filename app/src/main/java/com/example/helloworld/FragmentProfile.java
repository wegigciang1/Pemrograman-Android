package com.example.helloworld;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.helloworld.R;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {


    public FragmentProfile() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //kenalin button dari xml
        Button logOut = (Button) view.findViewById(R.id.logOutMain);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preference = getActivity().getSharedPreferences("masuk", Context.MODE_PRIVATE);
                //SharedPreferences preference = getSharedPreferences("masuk", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.putString("ingat", "false");
                editor.apply();
                Intent gotoprofile = new Intent(getActivity(), MainActivity.class);
                startActivity(gotoprofile);
            }
        });

    }



}