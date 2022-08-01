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

public class ViewScrap extends AppCompatActivity {
    ListView listView;
    UDBHelper udbHelper;
    //ImageView btnimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scrap);
//        btnimg=findViewById(R.id.Iimg);
//        btnimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(ViewScrap.this,admin_home.class);
//                startActivity(intent);
//            }
//        });
        listView = findViewById(R.id.lst);
        udbHelper = new UDBHelper(ViewScrap.this);
        ViewRecord();
    }

    public void  ViewRecord()

    {
        ArrayList<HashMap<String,String>> list=  udbHelper.show_record();
        ListAdapter listAdapter = new SimpleAdapter(this,
                list,
                R.layout.clv,
                new String[]{"Id","Name","Price"},
                new int[] {R.id.id,R.id.item,R.id.price});

        listView.setAdapter(listAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder alert  = new AlertDialog.Builder(ViewScrap.this);
                alert.setTitle("Delete/Update");
                alert.setMessage("Which Operation do you want to perform ?");
                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ViewScrap.this, "I am update", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final  int sid =Integer.parseInt (((TextView)view.findViewById(R.id.id)).getText().toString());
                        udbHelper.delete_record(sid);
                        ViewRecord();
                        Toast.makeText(ViewScrap.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
                return true;
            }
        });
    }

}