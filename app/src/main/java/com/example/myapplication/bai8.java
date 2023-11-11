package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.bt3_8.R;

import java.util.ArrayList;
import java.util.List;

public class bai8 extends AppCompatActivity {
    ListView lvDanhSach;
    Button btnChuyen;

    static List<SanPham> data_sp = new ArrayList<>();
    static SanPham_Adapter adapter_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter_sp = new SanPham_Adapter(this,R.layout.sanpham_item_layout,data_sp);
        lvDanhSach.setAdapter(adapter_sp);
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(bai8.this,ChiTietSanPham.class);
                intent.putExtra("item",data_sp.get(position));
                startActivity(intent);
            }
        });
        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data_sp.remove(position);
                adapter_sp.notifyDataSetChanged();
                return false;
            }
        });
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(bai8.this, MainActivity.class);
                startActivity(it);
            }
        });
    }


    private void KhoiTao() {
        data_sp.add(new SanPham("sp1","Sản Phẩm 1","100","ip"));
        data_sp.add(new SanPham("sp2","Sản Phẩm 2","200","samsung"));
        data_sp.add(new SanPham("sp3","Sản Phẩm 3","300","oppo"));
    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        btnChuyen=findViewById(R.id.btnChuyen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sanpham,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnThoat){
            finish();
        }
        if (item.getItemId()==R.id.mnThem){
            Intent intent = new Intent(this,Themsanpham.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}