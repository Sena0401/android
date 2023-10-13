package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class resultview extends AppCompatActivity {
    private ArrayList<String>  masv, d11,d12,d13,d21,d22,d23,d31,tbm,tbhp;
    ctec_database db;
    result_view_adapter adapter;
    RecyclerView recyclerView;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultview);

        db = new ctec_database(this);

        masv = new ArrayList<>();
        d11 = new ArrayList<>();
        d12 = new ArrayList<>();
        d13 = new ArrayList<>();
        d21 = new ArrayList<>();
        d22 = new ArrayList<>();
        d23 = new ArrayList<>();
        d31 = new ArrayList<>();
        tbm = new ArrayList<>();
        tbhp = new ArrayList<>();
        recyclerView = findViewById(R.id.result_recV);
        adapter= new result_view_adapter(this,masv,d11,d12,d13,d21,d22,d23,d31,tbm,tbhp);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent get = getIntent();
        String msv  = get.getStringExtra("MSSV_INPUT");
        String mmon = get.getStringExtra("MAMON_INPUT");
        displayResult(msv,mmon);


    }

    private void displayResult(String msv, String mmon) {
        Cursor cursor = db.getdataKQHTT_withID(msv,mmon);
        while (cursor.moveToNext()) {
            masv.add(cursor.getString(0));
            d11.add(cursor.getString(2));
            d12.add(cursor.getString(3));
            d13.add(cursor.getString(4));
            d21.add(cursor.getString(5));
            d22.add(cursor.getString(6));
            d23.add(cursor.getString(7));
            d31.add(cursor.getString(8));
            tbm.add(cursor.getString(9));
            tbhp.add(cursor.getString(10));



        }
    }
}