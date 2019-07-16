package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UpdateInformation extends AppCompatActivity {
    TextView tvName, tvLogOut,tv_xin_chao;
    User user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);
        init();
      //  getData();
    }

    void init() {
        tvName = findViewById(R.id.tv_xin_chao);

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent ;
                intent = new Intent(UpdateInformation.this , UserInformation.class) ;
                intent.putExtra("user" , user) ;
                startActivity(intent);
            }
        });

    }

    void getData() {
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        tvName.setText("Xin Chào , " + user.getName() + "(" + user.getPhoneNumber() + ")");
    }
}
