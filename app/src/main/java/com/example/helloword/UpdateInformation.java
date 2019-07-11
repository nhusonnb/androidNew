package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UpdateInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);
        init();
    }
    void init(){
        TextView xinChao;
        xinChao = findViewById(R.id.tv_xin_chao) ;
        UpdateUserInfor updateUserInfor ;
        updateUserInfor = new UpdateUserInfor();
        xinChao.setText("Xin Chào, " + updateUserInfor.tenSdt());
    }
}
