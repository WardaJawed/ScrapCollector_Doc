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
import android.widget.TextView;
import android.widget.Toast;

public class sc_signup extends AppCompatActivity {
    TextView signlink;
    EditText  txt_scname,txt_scpass,txt_scemail,txt_scno;
    Button btn_scsign;
    UDBHelper udbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_signup);
        signlink = findViewById(R.id.sc_Slink);
        signlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sc_signup.this, SC_login.class);
                startActivity(intent);
            }
        });

        txt_scname = findViewById(R.id.sc_Sname);
        txt_scpass = findViewById(R.id.sc_Spass);
        txt_scemail = findViewById(R.id.sc_Semail);
        txt_scno = findViewById(R.id.sc_Sno);
        btn_scsign = findViewById(R.id.sc_signup);
        udbHelper=new UDBHelper(sc_signup.this);
        btn_scsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEnterData();

                boolean checks=udbHelper.SCregister(txt_scname.getText().toString(),txt_scpass.getText().toString(),txt_scemail.getText().toString(),txt_scno.getText().toString());
                if (checks==true)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(sc_signup.this);
                    alert.setTitle("Alert");
                    alert.setMessage("Account Created ");
                    alert.setIcon(R.drawable.ic_baseline_add_alert_24);
                    alert.show();

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
            if(boxisEmpty(txt_scname) == false)
            {
                txt_scname.setError("Name is Required");

            }
            if(boxisEmpty(txt_scpass) == false)
            {
                txt_scpass.setError("Password is Required");

            }
            if(boxisEmpty(txt_scemail) == false)
            {

                txt_scemail.setError("Enter Email Address");
            }
            if(boxisEmpty(txt_scno) == false)
            {
                txt_scno.setError("Phone no is Required");

            }


        }



}