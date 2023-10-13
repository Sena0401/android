package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.xml.transform.sax.TemplatesHandler;

public class tch_stu_list extends AppCompatActivity {
    ArrayList<String> mssv, hoten, gioitinh, ngaysinh, noisinh, diachi, shs, cccd, sdt, email,malop, msgv;
    ctec_database db;
    tch_list_stu_adapter adapter;

    RecyclerView recyclerView;

    Button exit,deletein4;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_stu_list);

        db =new ctec_database(this);
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
        recyclerView = findViewById(R.id.tch_list_stu);
        adapter = new tch_list_stu_adapter(this, mssv, hoten, gioitinh, ngaysinh, noisinh, diachi, shs, cccd, sdt, email,malop, msgv);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaySTU();

        deletein4 = findViewById(R.id.tch_list_stu_detele);
        Cursor cursor = db.getdataSTU();
        if(cursor.getCount()==0) {
            deletein4.setVisibility(View.INVISIBLE);
            Toast.makeText(tch_stu_list.this, "Không có dữ liệu hiển thị", Toast.LENGTH_LONG).show();
            return;
        }

       deletein4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               comfirm_det_stu_diaglog();
           }
       });




        exit = findViewById(R.id.back_to_tch_home1);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });




    }




    private void displaySTU() {

        Cursor cursor = db.getdataSTU();
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

    private void comfirm_det_stu_diaglog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_confrim_del_stu);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);



        Button yes = dialog.findViewById(R.id.confirm_btn_yes);
        Button no = dialog.findViewById(R.id.confirm_btn_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText msv_input = dialog.findViewById(R.id.mssv_inputToDel);
                String id = msv_input.getText().toString();
                boolean result = db.deleteSTU(id);
                if (result==true) {
                    Toast.makeText(tch_stu_list.this, "Đã xóa sinh viên", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),tch_stu_list.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(tch_stu_list.this, "Không thành công, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dialog.show();
    }

}