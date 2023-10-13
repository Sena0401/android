package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class stu_home extends AppCompatActivity {
    Button info_btn,result_btn;
    TextView stu_home_name;
    ctec_database db;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_home);
        info_btn = findViewById(R.id.btn_info);
        result_btn =findViewById(R.id.btn_kqht);
        stu_home_name = findViewById(R.id.stu_name);
        db = new ctec_database(this);
        Intent g_int = getIntent();
        String id = g_int.getStringExtra("MSSV_INPUT");
        Cursor cursor  = db.getdataSTU_withID(id);
        while (cursor.moveToNext()) {
            stu_home_name.setText(cursor.getString(3));
        }

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(stu_home.this,stu_info.class);
                i.putExtra("MSSV_INPUT",id);
                startActivity(i);
            }
        });

        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultSTU_view(id);
            }
        });

    }

    private void resultSTU_view(String id) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.stu_result_view);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);
        Button yes = dialog.findViewById(R.id.confirm_btn_yes);
        Button no = dialog.findViewById(R.id.confirm_btn_no);
        EditText mamon = dialog.findViewById(R.id.mamon_inputToview);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mmon = mamon.getText().toString();
                Intent intent = new Intent(getApplicationContext(), resultview.class);
                intent.putExtra("MSSV_INPUT",id);
                intent.putExtra("MAMON_INPUT", mmon);
                startActivity(intent);
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