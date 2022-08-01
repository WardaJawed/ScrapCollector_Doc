package com.example.myscrapcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewScrapCollector extends AppCompatActivity {
    ListView listView;
    UDBHelper udbHelper;
    ImageView btnimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scrap_collector);
        btnimg=findViewById(R.id.scimg);
        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ViewScrapCollector.this,admin_home.class);
                startActivity(intent);
            }
        });
        listView = findViewById(R.id.list);
        udbHelper = new UDBHelper(ViewScrapCollector.this);
        view_Scollector();
    }
    public void  view_Scollector()

    {
        ArrayList<HashMap<String,String>> list=  udbHelper.show_Scollector();
        ListAdapter listAdapter = new SimpleAdapter(this,
                list,
                R.layout.appoint_layout,
                new String[]{"name","em","num"},
                new int[] {R.id.nm,R.id.em,R.id.phne});

        listView.setAdapter(listAdapter);


    }
}