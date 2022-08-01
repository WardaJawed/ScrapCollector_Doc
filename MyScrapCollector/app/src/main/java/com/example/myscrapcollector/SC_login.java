package com.example.myscrapcollector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SC_login extends AppCompatActivity {
    TextView loglink;
        EditText txt_lname,txt_lpass;
        Button btn_sclog;
        UDBHelper udbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_login);
        loglink=findViewById(R.id.sc_Llink);
        loglink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SC_login.this,sc_signup.class);
                startActivity(intent);
            }
        });
        txt_lname=findViewById(R.id.sc_Lname);
        txt_lpass=findViewById(R.id.sc_Lpass);
        btn_sclog=findViewById(R.id.sc_login);
        udbHelper=new UDBHelper(SC_login.this);
        btn_sclog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEnterData();
                if(udbHelper.getSC(txt_lname.getText().toString(),txt_lpass.getText().toString()))
                {
                    Intent intent =new Intent(SC_login.this,schome.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(SC_login.this, "Invalid Email & Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public  boolean boxisEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return (!TextUtils.isEmpty(str));

    }
    public  void  CheckEnterData() //define
    {
        if (boxisEmpty(txt_lname) == false) {
            txt_lname.setError("Name is Required");

        }
        if (boxisEmpty(txt_lpass) == false) {
            txt_lpass.setError("Passsword is Required");

        }


    }
}