package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.bt3_8.R;

import java.util.ArrayList;
import java.util.List;

public class Themsanpham extends AppCompatActivity {
    EditText edtMaSP, edtTenSP, edtGiaSP;
    Spinner spLoaiSP;
    List<String> data_lsp = new ArrayList<>();
    ArrayAdapter adapter_lsp;
    ImageView ivHinh;
    Button btnThem,btnLamMoi,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsanpham);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lsp);
        spLoaiSP.setAdapter(adapter_lsp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSP(edtMaSP.getText().toString());
                sanPham.setTenSP(edtTenSP.getText().toString());
                sanPham.setGiaSP(edtGiaSP.getText().toString());
                sanPham.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                bai8.data_sp.add(sanPham);
                bai8.adapter_sp.notifyDataSetChanged();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaSP.setText("");
                edtTenSP.setText("");
                edtGiaSP.setText("");
                spLoaiSP.setSelection(0);
            }
        });
    }

    private void KhoiTao() {
        data_lsp.add("ip");
        data_lsp.add("samsung");
        data_lsp.add("oppo");
    }

    private void setControl() {
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        btnBack = findViewById(R.id.btnBack);
    }
}