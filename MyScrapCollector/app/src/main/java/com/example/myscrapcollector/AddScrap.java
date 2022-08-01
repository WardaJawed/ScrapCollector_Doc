package com.example.myscrapcollector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddScrap extends AppCompatActivity {
EditText text_n,text_p;
Button btnsub;
ImageView btnimg;
UDBHelper udbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scrap);
        text_n=findViewById(R.id.item_name);
        text_p=findViewById(R.id.item_price);
        btnsub=findViewById(R.id.btn_sub);
        btnimg=findViewById(R.id.img);
        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AddScrap.this,admin_home.class);
                startActivity(intent);
            }
        });
        udbHelper = new UDBHelper(AddScrap.this);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEnterData();
                boolean check = udbHelper.addscrap(text_n.getText().toString(),text_p.getText().toString());
                if(check == true)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddScrap.this);
                    alert.setTitle("Alert");
                    alert.setMessage("Record Inserted");
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
        if (boxisEmpty(text_n) == false) {
            text_n.setError("Item is Required");

        }
        if (boxisEmpty(text_p) == false) {
            text_p.setError("Price is Required");

        }


    }
}