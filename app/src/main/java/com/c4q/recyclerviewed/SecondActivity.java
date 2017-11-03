package com.c4q.recyclerviewed;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Create a reference to the views in the activity's layout so we can set the data we get from the intent
        TextView textView = findViewById(R.id.second_activity_text_view);
        RelativeLayout rootLayout = findViewById(R.id.second_activity_root_layout);

        //make sure the intent is not null
        if (getIntent() != null) {

            //get the extras from the intent and set the relevant data
            String text = getIntent().getStringExtra("text");
            String color = getIntent().getStringExtra("color");

            textView.setText(text);
            rootLayout.setBackgroundColor(Color.parseColor(color));
        }
    }
}
