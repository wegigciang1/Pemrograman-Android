package com.example.helloworld;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ProfileActivity extends AppCompatActivity {

    public SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        pref= getApplicationContext().getSharedPreferences("Mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();


        editor.putString("KEY1", "Test Shared References");
        editor.commit();

        Log.i("Shared Prefed Preferenced", pref.getString("KEY1", null)); //mirip system println
        editor.remove("KEY1");
        editor.commit();

        setContentView(R.layout.activity_profile);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);
    }
}
