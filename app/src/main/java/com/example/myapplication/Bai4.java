package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bt3_8.R;

public class Bai4 extends AppCompatActivity {
    EditText edtTaiKhoan,edtMatKhau,edtSoDienThoai,edtEmail;
    Button btnDangKy,btnNhapLai,btnChuyen;
    TextView tvThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        setControl();
        setEvent();
    }
    private void setEvent() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTaiKhoan.getText().length() <= 0) {
                    edtTaiKhoan.setError("Vui lòng nhập tài khoản");
                    Toast.makeText(Bai4.this, "Chưa nhập tài khoảng", Toast.LENGTH_SHORT).show();
                    edtTaiKhoan.requestFocus();
                }
                else
                {
                    if(edtMatKhau.getText().length() <= 0)
                    {
                        edtMatKhau.setError("Vui lòng nhập mật khẩu");
                        Toast.makeText(Bai4.this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                        edtMatKhau.requestFocus();
                    }
                    else
                    {
                        if(edtSoDienThoai.getText().length() <= 0)
                        {
                            edtSoDienThoai.setError("Vui lòng nhập số điện thoại");
                            Toast.makeText(Bai4.this, "Chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                            edtSoDienThoai.requestFocus();
                        }
                        else
                        {
                            if(edtEmail.getText().length() <= 0)
                            {
                                edtEmail.setError("Vui lòng nhập số Email");
                                Toast.makeText(Bai4.this, "Chưa nhập Email", Toast.LENGTH_SHORT).show();
                                edtEmail.requestFocus();
                            }
                            else
                            {
                                // khi nhấn đăng ký thì sẽ hiện thông tin nguời dùng nhập vào
                                String msg = "";
                                msg += "Tài Khoảng : " + edtTaiKhoan.getText() + "\n";
                                msg += "Mật Khẩu : " + edtMatKhau.getText() + "\n";
                                msg += "Số Điện Thoại : " + edtSoDienThoai.getText() + "\n";
                                msg += "Email : " + edtEmail.getText() + "\n";
                                // truyền (msg) là thông tin cần hiện vào tvThongTin
                                tvThongTin.setText(msg);
                                tvThongTin.setBackgroundColor(Color.CYAN);
                                Toast.makeText(Bai4.this, "Chúc mừng bạn đăng ký thành công", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });

        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khi nhấn nút nhập lại thì sẽ xóa tất cả thông tin người dùng mới nhập và xóa phần hiện thông tin
                edtTaiKhoan.setText("");
                edtMatKhau.setText("");
                edtSoDienThoai.setText("");
                edtEmail.setText("");
                tvThongTin.setText("");
                edtTaiKhoan.requestFocus();
            }
        });

        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bai4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        edtTaiKhoan = findViewById(R.id.edtTK);
        edtMatKhau = findViewById(R.id.edtMK);
        edtSoDienThoai = findViewById(R.id.edtDT);
        edtEmail = findViewById(R.id.edtEmail);
        btnDangKy = findViewById(R.id.btnDK);
        btnNhapLai = findViewById(R.id.btnNL);
        tvThongTin = findViewById(R.id.tvThongTin);
        btnChuyen = findViewById(R.id.btnChuyen);

    }
}