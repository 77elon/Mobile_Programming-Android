package com.dhnns.chapter04;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Self0402 extends AppCompatActivity {
    Button button1, button2;
    EditText editText1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0402_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        editText1 = (EditText) findViewById(R.id.edittext1) ;

        button1.setRotation(90);

        editText1.setEnabled(false);
    }
}
