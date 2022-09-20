package com.dhnns.chapter07;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Self0701 extends AppCompatActivity {

    EditText edtAngle;
    ImageView imageView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0701_main);
        setTitle("제주도 풍경");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    private int getMenuIdByIndex(int index) {
        // index from 1
        switch (index) {
            case 1:
                return R.id.item1;
            case 2:
                return R.id.item2;
            case 3:
                return R.id.item3;
        }
        return 0;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        int savedIndex = PreferenceManager.getDefaultSharedPreferences(this).getInt("NAME", 1);
        for (int i = 1; i < 4; i++) {
            MenuItem item = menu.findItem(getMenuIdByIndex(i));
            if (item != null) {
                item.setChecked(i == savedIndex);
            }
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView1.setRotation(Float.parseFloat(edtAngle.getText()
                        .toString()));
                return true;
            case R.id.itemScale_2x:
                imageView1.setScaleX(2);
                imageView1.setScaleY(2);
                return true;
            case R.id.itemScale_x:
                imageView1.setScaleX(0.5F);
                imageView1.setScaleY(0.5F);
                return true;
            case R.id.itemScale_Size:
                imageView1.setScaleX(1);
                imageView1.setScaleY(1);
                return true;
            case R.id.item1:
                imageView1.setImageResource(R.drawable.jeju2);
                item.setChecked(!item.isChecked());
                return true;
            case R.id.item2:
                imageView1.setImageResource(R.drawable.jeju14);
                item.setChecked(!item.isChecked());
                return true;
            case R.id.item3:
                imageView1.setImageResource(R.drawable.jeju6);
                item.setChecked(!item.isChecked());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
