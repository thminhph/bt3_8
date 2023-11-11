package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt3_8.R;

public class Bai1 extends AppCompatActivity {
    Button btnChuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        setControl();
        setEvent();
    }
    private void setEvent() {
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bai1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnChuyen=findViewById(R.id.btnChuyen);
    }
}