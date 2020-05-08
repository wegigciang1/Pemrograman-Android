package com.example.helloworld;


import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJobService extends Fragment {


    public FragmentJobService() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_job_service, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //kenalin button dari xml
        Button logOut = view.findViewById(R.id.logOutMain);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences preference = getActivity().getSharedPreferences("masuk", Context.MODE_PRIVATE);
                //SharedPreferences preference = getSharedPreferences("masuk", MODE_PRIVATE);
                // SharedPreferences.Editor editor = preference.edit();
                //editor.putString("ingat", "false");
                //editor.apply();
                FirebaseAuth.getInstance().signOut();
                Intent gotoprofile = new Intent(getActivity(), LoginActivity.class);
                //agar tidak bisa back dengan back button
                getActivity().finish();
                startActivity(gotoprofile);
            }
        });

        //button Start and Canceled Job
        Button btnStartJob = view.findViewById(R.id.StartJob);
        Button btnCancelJob = view.findViewById(R.id.CancelJob);
        Button btnLokasi = view.findViewById(R.id.LokasiSekarang);
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
                if (resultCode == JobScheduler.RESULT_SUCCESS) {
                    Log.i(TAG, "scheduleJob: Job Scheduled");
                } else {
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
                Log.i(TAG, "cancelJob");

            }
        });

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprofile = new Intent(getActivity(), LokasiActivity.class);
                startActivity(gotoprofile);
            }
        });


    }
}

