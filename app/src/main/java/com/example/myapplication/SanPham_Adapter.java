package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bt3_8.R;

import java.util.List;

public class SanPham_Adapter extends ArrayAdapter {
    Context context;
    int resoure;
    List<SanPham> data;
    public SanPham_Adapter(@NonNull Context context, int resource, @NonNull List<SanPham>data) {
        super(context, resource, data);
        this.context = context;
        this.resoure = resource;
        this.data= data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resoure,null);
        TextView tvTenSP = convertView.findViewById(R.id.tvTenSP);
        TextView tvGiaSP = convertView.findViewById(R.id.tvGiaSP);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        SanPham sanPham = data.get(position);
        tvTenSP.setText(sanPham.getTenSP());
        tvGiaSP.setText(sanPham.getGiaSP());
        if (sanPham.getLoaiSP().equals("ip"))
            ivHinh.setImageResource(R.drawable.ip);
        if (sanPham.getLoaiSP().equals("samsung"))
            ivHinh.setImageResource(R.drawable.samsung);
        if (sanPham.getLoaiSP().equals("oppo"))
            ivHinh.setImageResource(R.drawable.oppo);
        return convertView;
    }
}
