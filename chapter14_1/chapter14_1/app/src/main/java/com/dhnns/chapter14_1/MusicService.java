package com.dhnns.chapter14_1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicService extends Service {

    MediaPlayer mp;
    int idx = 0;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        android.util.Log.i("서비스 테스트", "MusicService.onCreate()");
        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        android.util.Log.i("서비스 테스트", "MusicService.onDestroy()");
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_LONG).show();
        mp.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("서비스 테스트", "MusicService.onStartCommand()");
        Toast.makeText(getApplicationContext(), "onStartCommand()", Toast.LENGTH_LONG).show();

        ArrayList<String> mp3List = new ArrayList<String>(); // 가변적 문자열
        String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/" ;

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        assert listFiles != null;
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if (extName.equals((String) "mp3")) // 확장명이 mp3일 때만 추가함.
                mp3List.add(fileName);
        }

        mp = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/" + mp3List.get(idx)));
        mp.setLooping(false);
        mp.start();

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                mp.stop();
                mp.release();

                idx += 1;
                idx %= mp3List.size();
                try {
                    mp.setDataSource(mp3Path + mp3List.get(idx));
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();
            }
        });

        return super.onStartCommand(intent, flags, startId);

    }

}
