package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UpdateInformation extends AppCompatActivity {
    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);
        init();
        getData();
    }
    void init(){
        tvName = findViewById(R.id.tv_xin_chao);
    }
    void getData(){
        Intent intent = getIntent();
       User user = (User) intent.getSerializableExtra("user");
       tvName.setText("Xin Chào , "+user.getName() +"("+ user.getPhoneNumber() + ")");
    }
}
