package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bt3_8.R;

public class Bai3 extends AppCompatActivity {

    EditText edtSo1,edtSo2,edtKq;
    TextView tvThongKe,tvThongKeCT;
    Button btnHome;
    double dung=0;
    double tong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Bai3.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        edtSo1=findViewById(R.id.edtSo1);
        edtSo2=findViewById(R.id.edtSo2);
        edtKq=findViewById(R.id.edtKQ);
        tvThongKe=findViewById(R.id.tvThongKe);
        tvThongKeCT=findViewById(R.id.tvThongKeCT);
        btnHome=findViewById(R.id.btnChuyen);

    }

    public void PhepTinh(View view){
        int so1=Integer.parseInt(edtSo1.getText().toString());
        int so2=Integer.parseInt(edtSo2.getText().toString());
        int ketQua=Integer.parseInt(edtKq.getText().toString());
        String msg=tvThongKe.getText().toString();
        if (view.getId()==R.id.btnCong){
            tong++;
            msg+=so1+"+"+so2+"="+ketQua;
            if (ketQua==(so1+so2)){
                msg+=" Đúng\n";
                dung++;
            }
            else msg+=" Sai\n";
        }
        if (view.getId()==R.id.btnTru){
            tong++;
            msg+=so1+"-"+so2+"="+ketQua;
            if (ketQua==(so1-so2)){
                msg+=" Đúng\n";
                dung++;
            }
            else msg+=" Sai\n";
        }
        if (view.getId()==R.id.btnNhan){
            tong++;
            msg+=so1+"*"+so2+"="+ketQua;
            if (ketQua==(so1*so2)){
                msg+=" Đúng\n";
                dung++;
            }
            else msg+=" Sai\n";
        }
        if (view.getId()==R.id.btnChia){
            tong++;
            msg+=so1+"/"+so2+"="+ketQua;
            if (ketQua==(so1/so2)){
                msg+=" Đúng\n";
                dung++;
            }
            else msg+=" Sai\n";
        }
        tvThongKe.setText(msg);
        tvThongKe.setBackgroundColor(Color.GREEN);
        double tkd=(dung/tong)*100;
        tvThongKeCT.setText("Thống kê:"+"Dung: "+tkd+"% / Sai: "+(100-tkd)+"%");
    }
}