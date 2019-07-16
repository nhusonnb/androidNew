package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class UpdateUserInfor extends AppCompatActivity {
    EditText edtPhoneNumber;
    EditText edtTen, edtEmail, edtDiaChi, edtNgaySinh, edtTinhThanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_infor);
        init();
        getData();
    }

    void init() {
        edtPhoneNumber = findViewById(R.id.edt_so_dien_thoai);
        thongTin();
    }

    void getData() {
        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("phoneNumberPassword");
        edtPhoneNumber.setText(phoneNumber);
    }

    void thongTin() {
        edtTen = findViewById(R.id.edt_ten);
        edtDiaChi = findViewById(R.id.edt_dia_chi);
        edtEmail = findViewById(R.id.edt_email);
        edtNgaySinh = findViewById(R.id.edt_ngay_sinh);
        edtTinhThanh = findViewById(R.id.edt_tinh_thanh);

        RelativeLayout relativeLayout;
        relativeLayout = findViewById(R.id.rl_dong_y_button);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareData();
            }
        });
    }

    void prepareData() {
        User user;

        String name = edtTen.getText().toString();
        String dateOfBirth = edtNgaySinh.getText().toString();
        String email = edtEmail.getText().toString();
        String tinhThanh = edtTinhThanh.getText().toString();
        String phoneNumber = edtPhoneNumber.getText().toString();
        user = new User(name,phoneNumber,dateOfBirth,email,tinhThanh);

        Intent intent ;
        intent = new Intent(UpdateUserInfor.this,UpdateInformation.class) ;
        intent.putExtra("user" , user) ;
        startActivity(intent);
        finish();
    }
}
