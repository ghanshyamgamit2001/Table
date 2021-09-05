package com.ghanshyam.table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView list_item;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        list_item = findViewById(R.id.list_item);
        seekBar =findViewById(R.id.seekBar);

        seekBar.setMax(20);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Toast.makeText(MainActivity.this, "This is table of " + progress, Toast.LENGTH_SHORT).show();
                populate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void populate(int table){
        ArrayList<String> multitable = new ArrayList<>();
        for (int i =1; i <=10; i++){
            multitable.add(table + " x " + i + " = " + table*i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,multitable);
        list_item .setAdapter(arrayAdapter);
    }
}