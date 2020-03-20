package com.example.helloworld;


import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloworld.R;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import static androidx.constraintlayout.widget.Constraints.TAG;


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

        //button Start and Canceled Job
        Button btnStartJob = (Button) view.findViewById(R.id.StartJob);
        Button btnCancelJob = (Button) view.findViewById(R.id.CancelJob);
        //button start jalankan perintah
        btnStartJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "On StartJOB", Toast.LENGTH_SHORT).show();
                    ComponentName componentName = new ComponentName(getActivity(), MyJobService.class);
                    JobInfo info = new JobInfo.Builder(123, componentName)
                            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                            .setPersisted(true)
                            .setPeriodic(15 * 60 * 1000) //dilakukan setiap 15 menit
                            .build();

                    JobScheduler scheduler = (JobScheduler) getActivity().getSystemService(JOB_SCHEDULER_SERVICE);
                    int resultCode = scheduler.schedule(info);
                    if(resultCode == JobScheduler.RESULT_SUCCESS){
                        Log.i(TAG, "scheduleJob: Job Scheduled");
                    }else {
                        Log.i(TAG, "scheduleJob: Job Scheduling failed");
                    }
            }
        });

    //button cancel jalankan perintah
    btnCancelJob.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                JobScheduler scheduler = (JobScheduler) getActivity().getSystemService(JOB_SCHEDULER_SERVICE);
                scheduler.cancel(123);
                Log.i(TAG,"cancelJob");

        }
    });
    }






}

