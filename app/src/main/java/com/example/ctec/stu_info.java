package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class stu_info extends AppCompatActivity {

    ArrayList<String> mssv, hoten, gioitinh, ngaysinh, noisinh, diachi, shs, cccd, sdt, email,malop, msgv;
    RecyclerView recyclerView;
    stu_infopage_adapter adapter;
    ctec_database db;
    Button exit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_info);
        db= new ctec_database(this);
        mssv = new ArrayList<>();
        hoten = new ArrayList<>();
        gioitinh = new ArrayList<>();
        ngaysinh = new ArrayList<>();
        noisinh= new ArrayList<>();
        diachi = new ArrayList<>();
        shs = new ArrayList<>();
        cccd = new ArrayList<>();
        sdt = new ArrayList<>();
        email = new ArrayList<>();
        malop = new ArrayList<>();
        msgv = new ArrayList<>();


        recyclerView = findViewById(R.id.stu_infolist);
        adapter = new stu_infopage_adapter(this, mssv,gioitinh,hoten,ngaysinh,noisinh,diachi,shs,cccd,sdt,email,malop,msgv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent g_int = getIntent();
        String id = g_int.getStringExtra("MSSV_INPUT");
        displaySTU_in4(id);


        exit = findViewById(R.id.stu_in4_backto_home_btn);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void displaySTU_in4(String id) {
        Cursor cursor = db.getdataSTU_withID(id);
        if (cursor.getCount()==0) {
            Toast.makeText(stu_info.this,"Không có dữ liệu hiển thị",Toast.LENGTH_LONG).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                mssv.add(cursor.getString(0));
                hoten.add(cursor.getString(3));
                gioitinh.add(cursor.getString(4));
                ngaysinh.add(cursor.getString(5));
                noisinh.add(cursor.getString(6));
                diachi.add(cursor.getString(7));
                shs.add(cursor.getString(8));
                cccd.add(cursor.getString(9));
                sdt.add(cursor.getString(10));
                email.add(cursor.getString(11));
                malop.add(cursor.getString(12));
                msgv.add(cursor.getString(13));

            }
        }
    }
}