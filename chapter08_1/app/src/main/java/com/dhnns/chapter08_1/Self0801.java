package com.dhnns.chapter08_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.dhnns.chapter08_1.R;

public class Self0801 extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite, load, cel;
    String fileName;
    static int sYear;
    static int sMonth;
    static int sDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0801_main);
        setTitle("간단 일기장 (수정)");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        load = (Button) findViewById(R.id.btnLoad);
        cel = (Button) findViewById(R.id.btnCel);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        sYear = cYear;
        sMonth = cMonth;
        sDay = cDay;

        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth+1)
                + "_" + Integer.toString(cDay) + ".txt";
        String chk = readDiary(fileName);
        if(chk == null)
        {
            edtDiary.setHint("일기 없음");
        }
        else
        {
            edtDiary.setHint("일기 있습니다.");
        }

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 처음 실행시에 설정할 내용
                fileName = Integer.toString(sYear) + "_" + Integer.toString(sMonth +1)
                        + "_" + Integer.toString(sDay) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                if(str != null)
                {
                    btnWrite.setText("수정 하기");
                }
                else
                {
                    btnWrite.setText("새로 저장");
                }
            }
        });

        cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDiary.setText(null);
                btnWrite.setText("새로 저장");
            }
        });

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                sYear = year;
                sMonth =  monthOfYear;
                sDay = dayOfMonth;

                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(null);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            fileName + " 이  저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            edtDiary.setHint("일기 있습니다.");
        } catch (IOException e) {
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }

}
