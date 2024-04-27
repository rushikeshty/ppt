package com.example.ppt;

import static com.example.ppt.TimeKt.getHourMinutePair;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.List;

import kotlin.Pair;

public class MainActivity3 extends AppCompatActivity {
    private int hours1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         TextView textView = findViewById(R.id.numbers);
        Pair<List<String>, List<String>> initialHourMinutePair = getHourMinutePair(900, 43200, 1, 0);
        List<String> initialHour = initialHourMinutePair.getFirst();
       hours1 = Integer.parseInt(initialHour.get(0));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            List<String> allMintues = TimeKt.getMinutes(hours1,
                    900,43200,1);
            textView.setText(allMintues.toString());

        }
    }
}