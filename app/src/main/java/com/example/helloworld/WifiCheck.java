package com.example.helloworld;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class WifiCheck extends Application {

    public static final String onWiFi = "WiFi Menyala";
    public static final String offWiFi = "Yah.. Wifinya Mati";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotification();
    }

    private void createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel on = new NotificationChannel(
                    onWiFi,
                    "WiFi Menyala",
                    NotificationManager.IMPORTANCE_HIGH);//importance high diprioritas tingkat tinggi
            on.setDescription("WiFi Menyala");

            NotificationChannel off = new NotificationChannel(
                    offWiFi,
                    "Yah.. Wifinya Mati",
                    NotificationManager.IMPORTANCE_LOW);
            off.setDescription("Yah.. Wifinya Mati");

            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.createNotificationChannel(on);
            manager.createNotificationChannel(off);
        }
    }

}
