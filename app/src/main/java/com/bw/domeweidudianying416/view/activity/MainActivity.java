package com.bw.domeweidudianying416.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.domeweidudianying416.R;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
            }
        });
        handler = new Handler();
        handler.postDelayed(runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }
}
