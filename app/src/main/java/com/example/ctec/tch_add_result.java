package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tch_add_result extends AppCompatActivity {
    EditText mssv,mamon,d1_1,d1_2,d1_3,d2_1,d2_2,d2_3,d3_1;
    Button cal,save,exit;
    TextView tbm,tbhp;
    ctec_database db = new ctec_database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_add_result);
        mssv = findViewById(R.id.result_add_mssv);
        mamon = findViewById(R.id.result_add_mamon);
        tbm = findViewById(R.id.result_TBM);
        tbhp = findViewById(R.id.result_TBHP);
        d1_1 = findViewById(R.id.result_add_D1_1);
        d1_2 = findViewById(R.id.result_add_D1_2);
        d1_3 = findViewById(R.id.result_add_D1_3);
        d2_1 = findViewById(R.id.result_add_D2_1);
        d2_2 = findViewById(R.id.result_add_D2_2);
        d2_3 = findViewById(R.id.result_add_D2_3);
        d3_1 = findViewById(R.id.result_add_D3_1);
        save = findViewById(R.id.result_add_save);
        exit = findViewById(R.id.result_add_cancel);
        cal = findViewById(R.id.result_caculaing);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msv = mssv.getText().toString();
                String mmon = mamon.getText().toString();
                String d11 = d1_1.getText().toString();
                String d12 = d1_2.getText().toString();
                String d13 = d1_3.getText().toString();
                String d21 = d2_1.getText().toString();
                String d22 = d2_1.getText().toString();
                String d23 = d2_3.getText().toString();
                String d31 = d3_1.getText().toString();
                Boolean kq  = db.insertKQHT(msv,mmon,d11,d12,d13,d21,d22,d23,d31);
                if (kq == true) {
                    Cursor cursor = db.getdataKQHTT_withID(msv,mmon);
                    while (cursor.moveToNext()){
                        tbm.setText(cursor.getString(9));
                        tbhp.setText(cursor.getString(10));
                    }
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Đã lưu điểm",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),tch_add_kqht.class);
                startActivity(i);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}