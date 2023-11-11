package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.bt3_8.R;

public class Bai6 extends AppCompatActivity {
    Switch aSwitch;
    LinearLayout layoutLight;
    ImageView imgLight;
    ToggleButton toggleButton;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);
        setControl();
        setEvent();
    }

    private void setEvent() {
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aSwitch.isChecked()) {
                    imgLight.setImageResource(R.drawable.den_tat);
                    layoutLight.setVisibility(View.VISIBLE);
                } else {
                    layoutLight.setVisibility(View.GONE);
                    imgLight.setImageResource(R.drawable.den_bat);
                    toggleButton.setChecked(false);
                }
            }
        });
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    imgLight.setImageResource(R.drawable.den_bat);
                } else {
                    imgLight.setImageResource(R.drawable.den_tat);
                }
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bai6.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        aSwitch = findViewById(R.id.switchSetting);
        layoutLight = findViewById(R.id.layoutLight);
        imgLight = findViewById(R.id.imgLight);
        toggleButton = findViewById(R.id.toggle);
        btnHome=findViewById(R.id.btnChuyen);
    }
}