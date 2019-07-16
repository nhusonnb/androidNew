package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    void init() {
        TextView tvHello, tvLogin, tvLoginWithNumber, tvDangNhap;
        TextView tvLoginSocial;
        // khởi tạo liên kết với xlm
        tvHello = findViewById(R.id.tv_hello);
        tvHello.setText("Hello");

        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setText("Login");

        tvLoginWithNumber = findViewById(R.id.tv_login_with_number);
        tvLoginWithNumber.setText("Login with Phone Number");

        tvDangNhap = findViewById(R.id.tv_dangnhap);
        tvDangNhap.setText("Login");

        tvLoginSocial = findViewById(R.id.tv_login_social);
        tvLoginSocial.setText("Social Login");

        final EditText edtPhoneNumber;
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setText("");

        RelativeLayout rlLoginButton;
        rlLoginButton = findViewById(R.id.rl_login_button);


        rlLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                int phoneNumberLength = phoneNumber.length();
                if (phoneNumberLength > 9) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent = new Intent(LoginActivity.this, UpdateUserInfor.class);
                    // them du lieu vao trong intent , nhét phoneNumber vao trong intent
                    intent.putExtra("phoneNumberPassword", phoneNumber);
                    //lưu trạng thái đăng nhập
                    setLogin();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Mời nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void setLogin(){
        // lưu trạng thái đăng nhập
      SharedPreferences sharedPreferences =  getSharedPreferences("dekho" , MODE_PRIVATE)  ;
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putBoolean("isLogin" , true) ;
      editor.apply();

    }
}
