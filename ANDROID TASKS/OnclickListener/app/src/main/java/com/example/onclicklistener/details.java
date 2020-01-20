package com.example.onclicklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class details extends AppCompatActivity {

    TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // set back button


        textTitle = findViewById(R.id.detailTitle);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        textTitle.setText(title);

    }
}
