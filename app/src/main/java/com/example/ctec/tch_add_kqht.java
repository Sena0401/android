package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tch_add_kqht extends AppCompatActivity {

    Button oj_mng,rs_mng,rs_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_add_kqht);
        oj_mng = findViewById(R.id.tch_mng_oj);
        rs_mng = findViewById(R.id.tch_mng_result);
        rs_view = findViewById(R.id.tch_mng_result_view);

        oj_mng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),tch_mng_object.class);
                startActivity(i);
            }
        });

        rs_mng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),tch_add_result.class);
                startActivity(i);
            }
        });


        rs_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_view();
            }
        });
    }

    private void result_view() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tch_result_view_dialog);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);

        Button yes = dialog.findViewById(R.id.tch_result_view_ok);
        Button no = dialog.findViewById(R.id.tch_result_view_cacel);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText msv_input = dialog.findViewById(R.id.tch_result_view_mssv_input);
                EditText mamon_input = dialog.findViewById(R.id.tch_result_view_mamon_input);
                String msv = msv_input.getText().toString();
                String mamon = mamon_input.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),resultview.class);
                    intent.putExtra("MSSV_INPUT",msv);
                    intent.putExtra("MAMON_INPUT",mamon);
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