package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.bt3_8.R;

public class bai5 extends AppCompatActivity {

    EditText edtHoTen,edtCCCD,edtTTK;
    TextView tvThongTin;
    RadioButton radDH,radCD,radTC;
    CheckBox cbCG,cbDS,cbDB;

    Button btnDangKy,btnNhapLai;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKyThongTin();
            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhapLaiThongTin();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(bai5.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void NhapLaiThongTin() {
        edtHoTen.setText("");
        edtHoTen.setText("");
        edtTTK.setText("");
        radDH.setChecked(true);
        cbCG.setChecked(false);
        cbDS.setChecked(false);
        cbDB.setChecked(false);
        tvThongTin.setText("");
        tvThongTin.setBackgroundColor(Color.TRANSPARENT);
    }

    private void DangKyThongTin() {
        String msg="--------Thong tin-----------\n";
        msg+=edtHoTen.getText()+"\n";
        msg+=edtCCCD.getText()+"\n";
        if (radDH.isChecked()){
            msg+=radDH.getText()+"\n";
        }
        if (radCD.isChecked()){
            msg+=radCD.getText()+"\n";
        }
        if (radTC.isChecked()){
            msg+=radTC.getText()+"\n";
        }

        if (cbCG.isChecked()){
            msg+=cbCG.getText()+"\n";
        }
        if (cbDS.isChecked()){
            msg+=cbDS.getText()+"\n";
        }
        if (cbDB.isChecked()){
            msg+=cbDB.getText()+"\n";
        }

        msg+=edtTTK.getText()+"\n";
         tvThongTin.setText(msg);
        tvThongTin.setBackgroundColor(Color.GREEN);
    }

    private void setControl() {
        edtHoTen=findViewById(R.id.edtHoTen);
        edtCCCD=findViewById(R.id.edtCCCD);
        edtTTK=findViewById(R.id.edtTTK);
        tvThongTin=findViewById(R.id.tvThongTin);
        radDH=findViewById(R.id.radDaiHoc);
        radCD=findViewById(R.id.radCaoDang);
        radTC=findViewById(R.id.radTrungCap);
        cbCG=findViewById(R.id.cbChoiGame);
        cbDS=findViewById(R.id.cbDocSach);
        cbDB=findViewById(R.id.cbDocBao);
        btnDangKy=findViewById(R.id.btnDangKy);
        btnNhapLai=findViewById(R.id.btnNhapLai);
        btnHome=findViewById(R.id.btnChuyen);
    }
}