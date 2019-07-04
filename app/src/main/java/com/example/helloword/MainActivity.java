package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tao doi tuong tu khuon Student
        Student sv1; // b1 khai bao
        sv1 = new Student(); // b2 khoi tao
        sv1.name = "Tu" ;
        sv1.tuoi = 22 ;
        sv1.schoolName = "THPT";
        sv1.id = 123456789 ;

        Toast.makeText(this ,sv1.name ,Toast.LENGTH_LONG).show();
    }
}
