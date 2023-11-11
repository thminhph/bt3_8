package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bt3_8.R;

import java.util.ArrayList;
import java.util.List;

public class Bai7 extends AppCompatActivity {

    EditText edtMa,edtTenSp,edtGiasp;
    Spinner spLoaiSP;
    List<String> data_LSP = new ArrayList<>();
    ArrayAdapter adapter_LSP;
    ImageView ivHinh;
    List<SanPham> data_SP = new ArrayList<>();
    ArrayAdapter adapter_SP;
    Button btnThem,btnXoa ,btnSua,btnThoat;
    ListView lvSanPham;
    int index = -1;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter_LSP = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item ,data_LSP);
        spLoaiSP.setAdapter(adapter_LSP);
        adapter_SP = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data_SP );
        lvSanPham.setAdapter(adapter_SP);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sanpham = new SanPham();
                sanpham.setMaSP(edtMa.getText().toString());
                sanpham.setTenSP(edtTenSp.getText().toString());
                sanpham.setGiaSP(edtGiasp.getText().toString());
                sanpham.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                data_SP.add(sanpham);
                adapter_SP.notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sanpham = data_SP.get(index);
                sanpham.setMaSP(edtMa.getText().toString());
                sanpham.setTenSP(edtTenSp.getText().toString());
                sanpham.setGiaSP(edtGiasp.getText().toString());
                sanpham.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                adapter_SP.notifyDataSetChanged();

            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                SanPham sanpham = data_SP.get(i);
                edtMa.setText(sanpham.getMaSP());
                edtTenSp.setText(sanpham.getTenSP());
                edtGiasp.setText(sanpham.getGiaSP());
                if(sanpham.getLoaiSP().equals("san pham 1"))
                    spLoaiSP.setSelection(0);
                if(sanpham.getLoaiSP().equals("san pham 2"))
                    spLoaiSP.setSelection(1);
                if(sanpham.getLoaiSP().equals("san pham 3"))
                    spLoaiSP.setSelection(2);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index == -1)

                {
                    Toast.makeText(Bai7.this, "ban chua chon san phan nao", Toast.LENGTH_SHORT).show();
                }
                data_SP.remove(index);
                adapter_SP.notifyDataSetChanged();
                index = -1;
            }
        });
        lvSanPham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                data_SP.remove(i);
                adapter_SP.notifyDataSetChanged();
                return false;
            }
        });
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spLoaiSP.getSelectedItem().equals("san pham 1"))
                {
                    ivHinh.setImageResource(R.drawable.htc);
                }

                if(spLoaiSP.getSelectedItem().equals("san pham 2"))
                {
                    ivHinh.setImageResource(R.drawable.samsung);
                }

                if(spLoaiSP.getSelectedItem().equals("san pham 3"))
                {
                    ivHinh.setImageResource(R.drawable.oppo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bai7.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void  KhoiTao()
    {
        data_LSP.add("san pham 1");
        data_LSP.add("san pham 2");
        data_LSP.add("san pham 3");

    }
    private void setControl() {
        edtMa = findViewById(R.id.edtMa);
        edtTenSp = findViewById(R.id.edtTen);
        edtGiasp = findViewById(R.id.edtGiaSP);
        spLoaiSP = findViewById(R.id.spLoaiSP7);
        ivHinh = findViewById(R.id.ivLoaiHinh);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvSanPham = findViewById(R.id.lvSanPham);
        btnHome=findViewById(R.id.btnChuyen);
    }
}