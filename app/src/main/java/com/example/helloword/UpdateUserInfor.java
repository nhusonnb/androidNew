package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateUserInfor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_infor);
        init();

    }
    public void init(){

        MainActivity mainActivity;
        mainActivity = new MainActivity();
        String phoneNumber = mainActivity.phoneNumbers();
        EditText sdt;
        sdt = findViewById(R.id.edt_so_dien_thoai) ;
        sdt.setText(phoneNumber);

        final EditText ten,email,diaChi ;
        ten = findViewById(R.id.edt_ten);
        email = findViewById(R.id.edt_email);
        diaChi = findViewById(R.id.edt_dia_chi);

        RelativeLayout update;
        update = findViewById(R.id.rl_dong_y_button) ;
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ten.getText().equals("") && email.getText().equals("")&& diaChi.getText().equals("")){
                    Toast.makeText(UpdateUserInfor.this, "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent;
                    intent = new Intent(UpdateUserInfor.this,UpdateInformation.class);
                    startActivity(intent);
                }

            }
        });



    }
}
