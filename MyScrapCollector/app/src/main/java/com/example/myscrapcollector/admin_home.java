package com.example.myscrapcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class admin_home extends AppCompatActivity {
TextView  text_1,text_2,text_3,text_4,text_5;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        text_1=findViewById(R.id.adds);
        text_2=findViewById(R.id.views);
        text_3=findViewById(R.id.viewapp);
        text_4=findViewById(R.id.viewsc);
        text_5=findViewById(R.id.logout);

        text_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(admin_home.this,AddScrap.class);
                startActivity(intent);
            }
        });

        text_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(admin_home.this,ViewScrap.class);
                startActivity(intent);
            }
        });

        text_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(admin_home.this,ViewAppoint.class);
                startActivity(intent);
            }
        });

        text_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(admin_home.this,ViewScrapCollector.class);
                startActivity(intent);
            }
        });

        text_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.commit();
                editor.clear();
                Toast.makeText(admin_home.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}