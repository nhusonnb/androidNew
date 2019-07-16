package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserInformation extends AppCompatActivity {
    TextView tvLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        init();
    }

    void init(){


        ImageView ivAnhDaiDien;
        ivAnhDaiDien = findViewById(R.id.iv_anh_dai_dien) ;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.anh_dai_dien) ;
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap) ;
        roundedBitmapDrawable.setCircular(true);
        ivAnhDaiDien.setImageDrawable(roundedBitmapDrawable);

        tvLogout = findViewById(R.id.tv_dang_xuat) ;
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("dekho" , MODE_PRIVATE) ;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLogin" , false);
                editor.apply();

                Intent intent1 = new Intent(UserInformation.this , SplatActivity.class) ;
                startActivity(intent1);
            }
        });

    }
    void getData(){
        TextView tvHoTen,tvSdt;
        tvHoTen = findViewById(R.id.tv_ho_ten) ;
        tvSdt = findViewById(R.id.tv_sdt) ;
        Intent intent = getIntent() ;
        User user = (User) intent.getSerializableExtra("user") ;
        tvHoTen.setText(user.getName());
        tvSdt.setText(user.getPhoneNumber());
    }

}
