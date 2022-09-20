package com.dhnns.template2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class exer0207 extends AppCompatActivity {
    Button button1, button2;
    RadioGroup radioGroup;
    RadioButton radioButton, radioButton2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exer0207_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        //first edittext box
        EditText editText = (EditText) findViewById(R.id.text1);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup3);

        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        imageView = (ImageView) findViewById(R.id.imageView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "링크를 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "링크를 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                    startActivity(mIntent);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.radioButton) //Android 10(Q)
                {
                    imageView.setImageResource(R.drawable.ic_logo10);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_logo11);
                }
            }
        });


    }
}