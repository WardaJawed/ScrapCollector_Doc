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

public class ViewAppoint extends AppCompatActivity {
    ListView listView;
    UDBHelper udbHelper;
   // ImageView btnimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appoint);
      //  btnimg=findViewById(R.id.apimg);
//        btnimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(ViewAppoint.this,admin_home.class);
//                startActivity(intent);
//            }
//        });
        listView = findViewById(R.id.ap_list);
        udbHelper = new UDBHelper(ViewAppoint.this);
        view_pickup();
    }
    public void  view_pickup()

    {
        ArrayList<HashMap<String,String>> list=  udbHelper.show_pickup();
        ListAdapter listAdapter = new SimpleAdapter(this,
                list,
                R.layout.ap_view,
                new String[]{"Id","Name","No","Location","Email","Date"},
                new int[] {R.id.pid,R.id.nm,R.id.phne,R.id.lo,R.id.em,R.id.date});

        listView.setAdapter(listAdapter);


    }
}