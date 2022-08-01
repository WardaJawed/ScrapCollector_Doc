package com.example.myscrapcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class user_login extends AppCompatActivity {
TextView link;
    EditText txt_ulnm,txt_ulpass;
    Button btn_ulog;
    UDBHelper udbHelper;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME ="mypref";
    private static final String KEY_NAME ="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        link=findViewById(R.id.user_Llink);
        txt_ulnm=findViewById(R.id.user_Lname);
        txt_ulpass=findViewById(R.id.user_Lpass);
        btn_ulog=findViewById(R.id.user_log);
        udbHelper=new UDBHelper(user_login.this);
        //======================================================================================SharedPreferences

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String NAME = sharedPreferences.getString(KEY_NAME,null);


        if(NAME !=null)
        {
            Intent intent = new Intent(user_login.this,MyAccountFragment.class);
            startActivity(intent);
        }
        //==============================
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(user_login.this,user_signup.class);
                startActivity(intent);
            }
        });



        btn_ulog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEnterData();

               if(udbHelper.getUser(txt_ulnm.getText().toString(),txt_ulpass.getText().toString()))
                {
                   Intent intent =new Intent(user_login.this,userhome.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(user_login.this, "Invalid Email & Password", Toast.LENGTH_SHORT).show();
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
        if (boxisEmpty(txt_ulnm) == false) {
            txt_ulnm.setError("Name is Required");

        }
        if (boxisEmpty(txt_ulpass) == false) {
            txt_ulpass.setError("Passsword is Required");

        }


    }
}