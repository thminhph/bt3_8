package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bt3_8.R;

public class Bai2 extends AppCompatActivity {
    EditText edtTieuDe, edtNoiDung;
    Button btnSend;
    Button btnChuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        setControl();
        setEvent();
    }
    private void setEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Bai2.this,edtTieuDe.getText().toString()+edtNoiDung.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bai2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        edtTieuDe=findViewById(R.id.edtTieuDe);
        edtNoiDung=findViewById(R.id.edtNoiDung);
        btnSend=findViewById(R.id.btnSend);
        btnChuyen=findViewById(R.id.btnChuyen);
    }
}