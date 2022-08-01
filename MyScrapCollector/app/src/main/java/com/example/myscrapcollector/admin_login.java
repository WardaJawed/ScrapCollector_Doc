package com.example.myscrapcollector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_login extends AppCompatActivity {
EditText txt_nm,txt_pass;
Button btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txt_nm=findViewById(R.id.ad_lname);
        txt_pass=findViewById(R.id.ad_lpass);
        btn_log=findViewById(R.id.btn_admin);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_nm.getText().toString().equals("admin") && txt_pass.getText().toString().equals("admin"))
                {
                    Toast.makeText(admin_login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(admin_login.this,admin_home.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(admin_login.this, "Wrong Name & Password", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


    }