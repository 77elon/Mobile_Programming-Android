package com.dhnns.chapter14_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Self1401 extends AppCompatActivity {

    Intent intent;
    Button btnStart, btnStop;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self1401_main);
        setTitle("서비스 테스트 예제(개선)");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.music2);


        intent = new Intent(this, MusicService.class);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startService(intent);
                android.util.Log.i("서비스 테스트", "startService()");
                Toast.makeText(getApplicationContext(), "startService()", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopService(intent);
                android.util.Log.i("서비스 테스트", "stopService()");
                Toast.makeText(getApplicationContext(), "stopService()",  Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
