package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.helloword.recylerView.HistoryActivity;
import com.example.helloword.recylerView.places.PlaceActivity;

public class SplatActivity extends AppCompatActivity {

    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splat);
        router();
    }

    void router() {
        tvName = findViewById(R.id.tv_xin_chao);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               /* SharedPreferences sharedPreferences = getSharedPreferences("dekho", MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
                if (isLogin) {*/
                    Intent intent = new Intent(SplatActivity.this, PlaceActivity.class);
                   // tvName.setText(sharedPreferences.getString("xinchao",""));
                    startActivity(intent);

                    finish();
                /*} else{
                    Intent intent = new Intent(SplatActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
*/

            }
        }, 1000);
    }
}
