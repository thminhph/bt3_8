package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bt3_8.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPham extends AppCompatActivity {
    EditText edtTenSP, edtGiaSP;
    Spinner spLoaiSP;
    List<String> data_lsp = new ArrayList<>();
    ArrayAdapter adapter_lsp;
    ImageView ivHinh;
    Button btnXoa,btnSua,btnBack;
    TextView tvMaSP;
    SanPham sanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        sanPham = (SanPham) getIntent().getSerializableExtra("item");
        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lsp);
        spLoaiSP.setAdapter(adapter_lsp);
        tvMaSP.setText(sanPham.getMaSP());
        edtTenSP.setText(sanPham.getTenSP());
        edtGiaSP.setText(sanPham.getGiaSP());
        if (sanPham.getLoaiSP().equals("ip"))
            spLoaiSP.setSelection(0);
        if (sanPham.getLoaiSP().equals("samsung"))
            spLoaiSP.setSelection(1);
        if (sanPham.getLoaiSP().equals("oppo"))
            spLoaiSP.setSelection(2);
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spLoaiSP.getSelectedItem().toString().equals("ip"))
                    ivHinh.setImageResource(R.drawable.ip);
                if (spLoaiSP.getSelectedItem().toString().equals("samsung"))
                    ivHinh.setImageResource(R.drawable.samsung);
                if (spLoaiSP.getSelectedItem().toString().equals("oppo"))
                    ivHinh.setImageResource(R.drawable.oppo);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (SanPham item: bai8.data_sp) {
                    if (item.getMaSP().equals(sanPham.getMaSP()))
                    {
                        item.setTenSP(edtTenSP.getText().toString());
                        item.setGiaSP(edtGiaSP.getText().toString());
                        item.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                        bai8.adapter_sp.notifyDataSetChanged();
                        Toast.makeText(ChiTietSanPham.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                onBackPressed();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (SanPham item: bai8.data_sp) {
                    if (item.getMaSP().equals(sanPham.getMaSP())){
                        bai8.data_sp.remove(item);
                        bai8.adapter_sp.notifyDataSetChanged();
                        Toast.makeText(ChiTietSanPham.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();

                        onBackPressed();
                    }

                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void KhoiTao() {
        data_lsp.add("ip");
        data_lsp.add("samsung");
        data_lsp.add("oppo");
    }

    private void setControl() {
        tvMaSP = findViewById(R.id.tvMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnBack = findViewById(R.id.btnBack);
    }
}