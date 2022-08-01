package com.example.myscrapcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(10000); //-- 5 sec
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();

                }
                finally {
                    Intent intent = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
}