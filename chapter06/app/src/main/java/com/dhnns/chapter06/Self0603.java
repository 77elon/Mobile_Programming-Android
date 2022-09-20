package com.dhnns.chapter06;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Self0603 extends TabActivity {

    Button btn1, btn2;
    EditText text1;
    static double result1;
    TextView t_result;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0603_main);

        btn1 = (Button) findViewById(R.id.convert1);
        btn2 = (Button) findViewById(R.id.convert2);

        text1 = (EditText) findViewById(R.id.input1);
        t_result = (TextView) findViewById(R.id.result);

        TabHost tabHost = getTabHost();

        TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("강아지");
        tabSpec1.setContent(R.id.imageView1);
        tabHost.addTab(tabSpec1);

        TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("고양이");
        tabSpec2.setContent(R.id.imageView2);
        tabHost.addTab(tabSpec2);

        TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("토끼");
        tabSpec3.setContent(R.id.imageView3);
        tabHost.addTab(tabSpec3);

        TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("말");
        tabSpec4.setContent(R.id.imageView4);
        tabHost.addTab(tabSpec4);

        TabSpec tabSpec5 = tabHost.newTabSpec("TAG5").setIndicator("면적 계산");
        tabSpec5.setContent(R.id.linearLayout2);
        tabHost.addTab(tabSpec5);

        tabHost.setCurrentTab(0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 = Double.parseDouble(text1.getText().toString());
                result1 *= 3.305785;
                t_result.setText(Double.toString(result1) + "제곱미터");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 = Double.parseDouble(text1.getText().toString());
                result1 /= 3.305785;
                t_result.setText(Double.toString(result1) + "평");
            }
        });
    }


}
