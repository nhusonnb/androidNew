package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splat);
        router() ;
    }
    void router(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("dekho",MODE_PRIVATE);
               boolean isLogin = sharedPreferences.getBoolean("isLogin" , false);
                if(isLogin){
                    Intent intent = new Intent(SplatActivity.this,UpdateInformation.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(SplatActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },1000);
    }
}
