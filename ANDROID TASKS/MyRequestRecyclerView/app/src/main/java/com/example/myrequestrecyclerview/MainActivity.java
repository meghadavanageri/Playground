package com.example.myrequestrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add("AWAITING APPROVAL");
        items.add("APPROVED");
        items.add("DRAFT");
        items.add("REJECTED");
        items.add("AWAITING APPROVAL");
        items.add("APPROVED");
        items.add("DRAFT");
        items.add("REJECTED");
        items.add("AWAITING APPROVAL");
        items.add("APPROVED");
        items.add("DRAFT");
        items.add("REJECTED");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,items);
        recyclerView.setAdapter(adapter);
    }
}
