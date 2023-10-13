package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tch_home extends AppCompatActivity {
    Button add_stu, rs_mng, list_stu;
    TextView tch_home_name;

    ctec_database db = new ctec_database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_home);
        tch_home_name = findViewById(R.id.tch_home_name);
        add_stu = findViewById(R.id.btn_add_stu);
        rs_mng = findViewById(R.id.btn_add_markofsubject);
        list_stu = findViewById(R.id.btn_list_stu);









        //hiển thị tên giảng viên
        Intent i = this.getIntent();
        String id = i.getStringExtra("MSGV_INPUT");
        Cursor cursor = db.getdataTCH_withID(id);
        if (cursor.getCount()==0) {
            Toast.makeText(tch_home.this,"Không có dữ liệu hiển thị",Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                tch_home_name.setText(cursor.getString(3));
            }
        }

        // xử lý các nút nhấn chức năng
        //Chức năng thêm sinh viên
        add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tch_home.this, tch_add_stu.class);

                startActivity(i);
            }
        });

        //Chức năng xem danh sách sinh viên
        list_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tch_home.this,tch_stu_list.class);
                startActivity(i);
            }
        });

        rs_mng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), tch_add_kqht.class);
                startActivity(i);
            }
        });


    }
}