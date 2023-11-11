package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bt3_8.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChuyenTrang(View view){
        if (view.getId()==R.id.btnBai1){
            Intent intent=new Intent(MainActivity.this,Bai1.class);
            startActivity(intent);
        }

        if (view.getId()==R.id.btnBai2){
            Intent intent=new Intent(MainActivity.this,Bai2.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.btnBai3){
            Intent intent=new Intent(MainActivity.this,Bai3.class);
            startActivity(intent);
        }

        if (view.getId()==R.id.btnBai4){
            Intent intent=new Intent(MainActivity.this,Bai4.class);
            startActivity(intent);
        }

        if (view.getId()==R.id.btnBai5){
            Intent intent=new Intent(MainActivity.this,bai5.class);
            startActivity(intent);
        }

        if (view.getId()==R.id.btnBai6){
            Intent intent=new Intent(MainActivity.this,Bai6.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.btnBai7){
            Intent intent=new Intent(MainActivity.this,Bai7.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.btnBai8){
            Intent intent=new Intent(MainActivity.this,bai8.class);
            startActivity(intent);
        }
    }


}