package com.example.myscrapcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
Button button_admin,button_user,button_sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        button_admin=findViewById(R.id.btn_admin);
        button_user=findViewById(R.id.btn_user);
        button_sc=findViewById(R.id.btn_SC);

        //======================ADMIN
        button_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Dashboard.this,admin_login.class);
                startActivity(intent);
            }
        });

        //======================USER
        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Dashboard.this,user_login.class);
                startActivity(intent);
            }
        });

        //======================SCRAP COLLECTOR
        button_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Dashboard.this,SC_login.class);
                startActivity(intent);
            }
        });
    }
}