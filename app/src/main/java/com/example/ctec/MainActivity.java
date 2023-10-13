package com.example.ctec;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private RadioButton rd_btn_stu, rd_btn_tch;
    private Button signup_btn, login_btn;
    private RadioGroup radioGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ các phần tử từ layout activity_main
        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        rd_btn_stu = findViewById(R.id.rd_slc_sv);
        rd_btn_tch = findViewById(R.id.rd_slc_gv);
        radioGroup = findViewById(R.id.selec_G);
        signup_btn = findViewById(R.id.create_acc_tch);
        login_btn = findViewById(R.id.btn_login);


        ctec_database db = new ctec_database(this);
        signup_btn.setVisibility(View.INVISIBLE);
        //xử lý sự kiện lựa chọn đối tượng đăng nhập
        rd_btn_stu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Bạn là Sinh Viên", Toast.LENGTH_LONG).show();
                    signup_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        rd_btn_tch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Bạn là Giảng Viên", Toast.LENGTH_LONG).show();
                    signup_btn.setVisibility(View.VISIBLE);
                }
            }
        });


        //xử lý sự kiện đăng nhập
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urs = user.getText().toString();
                String pss = pass.getText().toString();
                if (rd_btn_stu.isChecked()) {
                    if (urs.equals("") || pss.equals("")) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập Tên đăng nhập và Mật khẩu", Toast.LENGTH_LONG).show();
                    } else {
                        Boolean LGcheck_stu = db.checkLG_STU(urs, pss);
                        if (LGcheck_stu == true) {
                            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, stu_home.class);
                            i.putExtra("MSSV_INPUT", urs);
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_LONG).show();
                        }
                    }
                } else if (rd_btn_tch.isChecked()) {
                    if (urs.equals("") || pss.equals("")) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập Tên đăng nhập và Mật khẩu", Toast.LENGTH_LONG).show();
                    } else {
                        Boolean LGcheck_tch = db.checkLG_TCH(urs, pss);
                        if (LGcheck_tch == true) {
                            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, tch_home.class);
                            i.putExtra("MSGV_INPUT", urs);
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

        //xử lý tạo tài khoản GIANGVIEN
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TCH_create_dialog();
            }
        });


    }

    private void TCH_create_dialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tch_create_dialog);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);

        Button add = dialog.findViewById(R.id.btn_tch_add);
        Button cancel = dialog.findViewById(R.id.btn_tch_cancel);

        EditText msgv;
        EditText mk;
        EditText hoten;
        EditText mlop;
        msgv = dialog.findViewById(R.id.tch_add_msgv);
        mk = dialog.findViewById(R.id.tch_add_mkdn);
        hoten = dialog.findViewById(R.id.tch_add_hoten);
        mlop = dialog.findViewById(R.id.tch_add_mlop);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mgv = msgv.getText().toString();
                String ps = mk.getText().toString();
                String ten = hoten.getText().toString();
                String lop = mlop.getText().toString();
                Boolean insertTCH = db.insertTCH(mgv, ps, ten, lop);
                if (insertTCH == true) {
                    Toast.makeText(MainActivity.this, "Tạo tài khoảng thành công", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Tạo tài khoảng không thành công", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        dialog.show();

    }
}