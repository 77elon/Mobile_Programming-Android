package com.dhnns.chapter08_1;

import java.io.File;

import android.os.Environment;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dhnns.chapter08_1.R;
import com.dhnns.chapter08_1.myPictureView;

public class Self0802 extends AppCompatActivity {

    Button btnPrev, btnNext;
    myPictureView myPicture;
    TextView tvNumber;
    int curNum=0;
    File[] imageFiles;
    String imageFname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0802_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("간단 이미지 뷰어 (변경)");
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;
        tvNumber.setText(curNum + 1 + "/" + (imageFiles.length-1));

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum < 1) {
                    curNum = imageFiles.length - 1;
                } else {
                    curNum--;
                }
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + (imageFiles.length));

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum > imageFiles.length) {
                    curNum = 0;
                } else {
                    curNum++;
                }
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + (imageFiles.length));
            }
        });

    }

}
