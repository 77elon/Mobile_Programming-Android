package com.dhnns.chapter08_2;

import java.io.File;
import java.util.Locale;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dhnns.chapter08_2.R;

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
        tvNumber.setText(curNum + 1 + "/" + (imageFiles.length));

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum == 0) {
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
                if (curNum + 2 > imageFiles.length) {
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

        myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] tstMsg = {
                        "르누아르 1 ",
                        "2 레스토랑 푸르네즈에서의 점심 식사",
                        "3 이레느 강 단베르 양의 조상",
                        "르누아르 4",
                        "5 부지발의 무도회",
                        "르누아르 6",
                        "르누아르 7",
                        "르누아르 8",
                        "르누아르 9",
                        "르누아르 10",
                        "르누아르 11"
                };
                Toast MsgOutput = Toast.makeText(getApplicationContext(), tstMsg[curNum], Toast.LENGTH_SHORT);
                MsgOutput.show();
            }
        });
    }

}
