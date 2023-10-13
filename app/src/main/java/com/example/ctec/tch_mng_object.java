package com.example.ctec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class tch_mng_object extends AppCompatActivity {

    private ArrayList<String> mamon, tenmon,sotinchi, mahk;
    RecyclerView recyclerView;
    oj_mng_adapter adapter;
    Button add,edit,del,exit;
    ctec_database db = new ctec_database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tch_mng_object);

        mamon = new ArrayList<>();
        tenmon = new ArrayList<>();
        mahk = new ArrayList<>();
        sotinchi = new ArrayList<>();
        recyclerView = findViewById(R.id.oj_list);
        adapter = new oj_mng_adapter(this,mamon,tenmon,sotinchi,mahk);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayOJ();


        add = findViewById(R.id.oj_add);
        edit = findViewById(R.id.oj_update);
        del = findViewById(R.id.oj_del);
        exit = findViewById(R.id.oj_mng_exit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adding_form();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getID_ToUpdate();


            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOBJECT();
            }
        });
    }

    private void displayOJ() {
        Cursor cursor = db.getdataOBJECT();
        while (cursor.moveToNext()) {
            mamon.add(cursor.getString(0));
            tenmon.add(cursor.getString(1));
            sotinchi.add(cursor.getString(2));
            mahk.add(cursor.getString(3));

        }
    }

    private void adding_form() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tch_object_add_dialog);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);

        Button adding = dialog.findViewById(R.id.oj_add_add);
        Button canceling = dialog.findViewById(R.id.oj_add_cancel);

        EditText mahk = dialog.findViewById(R.id.oj_add_semester);
        EditText mamon = dialog.findViewById(R.id.oj_add_id);
        EditText tenmon = dialog.findViewById(R.id.oj_add_name);
        EditText sotinchi = dialog.findViewById(R.id.oj_add_credit);

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ses = mahk.getText().toString();
                String id = mamon.getText().toString();
                String name = tenmon.getText().toString();
                String cre = sotinchi.getText().toString();

                Boolean insertOBJ = db.insertOBJECT(id,name,cre,ses);
                if (insertOBJ == true ){
                    Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),tch_mng_object.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"Đã có lỗi xảy ra, Vui long thử lại",Toast.LENGTH_LONG).show();
                }
            }
        });

        canceling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dialog.show();
    }


    private void getID_ToUpdate(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tch_object_update_getid);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);

        Button ok = dialog.findViewById(R.id.oj_update_getid_ok);
        Button cancel = dialog.findViewById(R.id.oj_update_getid_cancel);

        EditText ojID = dialog.findViewById(R.id.mamon_input);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ojID.getText().toString();
                updateOBJ(id);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dialog.show();
    }





    private void updateOBJ(String mamon){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tch_object_update_dialog);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);

        Button adding = dialog.findViewById(R.id.oj_add_add);
        Button canceling = dialog.findViewById(R.id.oj_add_cancel);

        EditText mahk = dialog.findViewById(R.id.oj_add_semester);

        EditText tenmon = dialog.findViewById(R.id.oj_add_name);
        EditText sotinchi = dialog.findViewById(R.id.oj_add_credit);

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = tenmon.getText().toString();
                String sotc = sotinchi.getText().toString();
                String ses = mahk.getText().toString();
                Boolean kq = db.updateOBJECT(mamon,name,sotc,ses);
                if (kq == true) {
                    Toast.makeText(getApplicationContext(),"Chỉnh sửa môn học thành công",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),tch_mng_object.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Đã có lỗi xảy ra, Vui long thử lại",Toast.LENGTH_LONG).show();
                }
            }
        });

        canceling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dialog.show();
    }


    private void deleteOBJECT() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tch_object_delete_dialog);
        dialog.setCanceledOnTouchOutside(false);
        ctec_database db = new ctec_database(this);

        Button confirm = dialog.findViewById(R.id.confirm_btn_yes);
        Button cancel = dialog.findViewById(R.id.confirm_btn_no);

        EditText idToDEL = dialog.findViewById(R.id.ojId_inputToDel);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idToDEL.getText().toString();
                boolean kq = db.deleteOJECT(id);
                if (kq == true) {
                    Toast.makeText(getApplicationContext(),"Đã xóa môn học",Toast.LENGTH_LONG).show();
                }
            }
        });
        dialog.show();
    }

}