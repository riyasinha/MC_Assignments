package com.example.mc.assignment2_mc.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

public class Service_A2_2016079 extends Service {
    private MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp = new MediaPlayer();
        try { mp.create(getApplicationContext(),Uri.EMPTY) ;} catch (Exception e) {e.printStackTrace();}
//        try { mp.prepare(); } catch (Exception e) {}
        mp.setVolume(100, 100);
        mp.setLooping(true);

        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer playerM){
                playerM.start();
            }
        });
        try{
            mp.prepareAsync();
        }catch (Exception e){
            e.printStackTrace();
        }

        mp.start();
        return  START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();

    }
}
