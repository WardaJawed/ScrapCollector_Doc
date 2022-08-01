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

public class user_signup extends AppCompatActivity {
    TextView Slink;
    EditText txt_uname,txt_upass,txt_uemail,txt_uno;
    Button btn_usign;
    UDBHelper udbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        Slink=findViewById(R.id.user_Slink);
        Slink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(user_signup.this,user_login.class);
                startActivity(intent);
            }
        });

        txt_uname = findViewById(R.id.user_Sname);
        txt_upass = findViewById(R.id.user_Spass);
        txt_uemail = findViewById(R.id.user_Semail);
        txt_uno = findViewById(R.id.user_Sno);
        btn_usign = findViewById(R.id.user_signup);

        udbHelper=new UDBHelper(user_signup.this);
        btn_usign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckEnterData();
                boolean check=udbHelper.registerrecord(txt_uname.getText().toString(),txt_upass.getText().toString(),txt_uemail.getText().toString(),txt_uno.getText().toString());
                if (check==true)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(user_signup.this);
                    alert.setTitle("Alert");
                    alert.setMessage("Account Created ");
                    alert.setIcon(R.drawable.ic_baseline_add_alert_24);
                    alert.show();

                }

            }
        });
    }

    public  boolean boxisEmail(EditText txt)
    {
        CharSequence txt_str =txt.getText().toString();
        return  (!TextUtils.isEmpty(txt_str) && Patterns.EMAIL_ADDRESS.matcher(txt_str).matches());

    }
    public  boolean boxisEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return (!TextUtils.isEmpty(str));

    }
    public  void  CheckEnterData() //define
    {
        if(boxisEmpty(txt_uname) == false)
        {
            txt_uname.setError("Name is Required");

        }
        if(boxisEmpty(txt_upass) == false)
        {
            txt_upass.setError("Password is Required");

        }
        if(boxisEmail(txt_uemail) == false)
        {

            txt_uemail.setError("Enter Valid Email Address");
        }
        if(boxisEmpty(txt_uno) == false)
        {
            txt_uno.setError("Phone no is Required");

        }


    }

}