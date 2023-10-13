package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class tch_add_stu extends AppCompatActivity {
    EditText msv,matkhau,hoten,gioitinh, ngaysinh, noisinh,diachi, sohoso, cccd,sdt,email,mlop ,mgv;
    ImageButton add,cancel;
    ctec_database db = new ctec_database(this);

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_add_stu);
        msv = findViewById(R.id.edt_addSTU_mssv);
        matkhau = findViewById(R.id.edt_addSTU_matkhau);
        hoten = findViewById(R.id.edt_addSTU_hoten);
        gioitinh = findViewById(R.id.edt_addSTU_gioitinh);
        ngaysinh = findViewById(R.id.edt_addSTU_noisinh);
        noisinh = findViewById(R.id.edt_addSTU_noisinh);
        diachi = findViewById(R.id.edt_addSTU_diachi);
        sohoso = findViewById(R.id.edt_addSTU_SHSNH);
        cccd = findViewById(R.id.edt_addSTU_cccd);
        sdt = findViewById(R.id.edt_addSTU_sdt);
        email = findViewById(R.id.edt_addSTU_email);
        mlop = findViewById(R.id.edt_addSTU_mlop);
        mgv = findViewById(R.id.edt_addSTU_msgv);

        add = findViewById(R.id.imgbtn_stuin4pg_save);
        cancel = findViewById(R.id.imgbtn_stuin4pg_back);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = msv.getText().toString();
                String mk = matkhau.getText().toString();
                String ten = hoten.getText().toString();
                String gt = gioitinh.getText().toString();
                String dob = ngaysinh.getText().toString();
                String nsinh = noisinh.getText().toString();
                String dc = diachi.getText().toString();
                String shs = sohoso.getText().toString();
                String cmt = cccd.getText().toString();
                String phone = sdt.getText().toString();
                String mail = email.getText().toString();
                String lop = mlop.getText().toString();
                String msgv = mgv.getText().toString();
                Boolean insertSTU = db.insertSTU(mssv, mk, ten, gt, dob, nsinh, dc, shs, cmt, phone, mail, lop, msgv);
                if (insertSTU == true) {
                    Toast.makeText(tch_add_stu.this, "Thêm Sinh Viên thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(tch_add_stu.this, "Xin vui lòng thử lại", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
}
}

