package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static androidx.constraintlayout.widget.Constraints.TAG;

//CLASS ini dibuat di pertemuan 6

public class MyBroadcastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("MY_ACTION")) {
            Log.i(TAG, "onReceive");
        }
    }

}
