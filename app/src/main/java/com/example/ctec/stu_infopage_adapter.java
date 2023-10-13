package com.example.ctec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class stu_infopage_adapter extends RecyclerView.Adapter<stu_infopage_adapter.stu_info_holder> {
    private Context context;
    private ArrayList mssv_id,hoten_id, gioitinh_id, noisinh_id, ngaysinh_id, diachi_id,sohs_id, cccd_id, sdt_id, email_id, mlop_id, msgv_id;

    @NonNull
    @Override
    public stu_info_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stu_infopage,parent,false);
        return new stu_info_holder(view);
    }

    public stu_infopage_adapter(Context context, ArrayList mssv_id, ArrayList hoten_id, ArrayList gioitinh_id, ArrayList noisinh_id, ArrayList ngaysinh_id, ArrayList diachi_id, ArrayList sohs_id, ArrayList cccd_id, ArrayList sdt_id, ArrayList email_id, ArrayList mlop_id, ArrayList msgv_id) {
        this.context = context;
        this.mssv_id = mssv_id;
        this.hoten_id = hoten_id;
        this.gioitinh_id = gioitinh_id;
        this.noisinh_id = noisinh_id;
        this.ngaysinh_id = ngaysinh_id;
        this.diachi_id = diachi_id;
        this.sohs_id = sohs_id;
        this.cccd_id = cccd_id;
        this.sdt_id = sdt_id;
        this.email_id = email_id;
        this.mlop_id = mlop_id;
        this.msgv_id = msgv_id;
    }

    @Override
    public void onBindViewHolder(@NonNull stu_info_holder holder, int position) {
        holder.mssv_id.setText(String.valueOf(mssv_id.get(position)));
        holder.hoten_id.setText(String.valueOf(hoten_id.get(position)));
        holder.gioitinh_id.setText(String.valueOf(gioitinh_id.get(position)));
        holder.noisinh_id.setText(String.valueOf(noisinh_id.get(position)));
        holder.ngaysinh_id.setText(String.valueOf(ngaysinh_id.get(position)));
        holder.diachi_id.setText(String.valueOf(diachi_id.get(position)));
        holder.sohs_id.setText(String.valueOf(sohs_id.get(position)));
        holder.cccd_id.setText(String.valueOf(cccd_id.get(position)));
        holder.sdt_id.setText(String.valueOf(sdt_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.mlop_id.setText(String.valueOf(mlop_id.get(position)));
        holder.msgv_id.setText(String.valueOf(msgv_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return mssv_id.size();
    }

    public class stu_info_holder extends RecyclerView.ViewHolder{
        TextView mssv_id,hoten_id, gioitinh_id, noisinh_id, ngaysinh_id, diachi_id,sohs_id, cccd_id, sdt_id, email_id, mlop_id, msgv_id;


        public stu_info_holder(@NonNull View itemView) {
            super(itemView);
            mssv_id = itemView.findViewById(R.id.cardview_list_stu_msv);
            hoten_id = itemView.findViewById(R.id.cardview_list_stu_ten);
            gioitinh_id = itemView.findViewById(R.id.cardview_list_stu_gioitinh);
            ngaysinh_id = itemView.findViewById(R.id.cardview_list_stu_namsinh);
            noisinh_id = itemView.findViewById(R.id.cardview_list_stu_noisinh);
            diachi_id = itemView.findViewById(R.id.cardview_list_stu_diachilienlac);
            sohs_id = itemView.findViewById(R.id.cardview_list_stu_SHSNH);
            cccd_id = itemView.findViewById(R.id.cardview_list_stu_cccd);
            sdt_id = itemView.findViewById(R.id.cardview_list_stu_sdt);
            email_id = itemView.findViewById(R.id.cardview_list_stu_email);
            mlop_id = itemView.findViewById(R.id.cardview_list_stu_mlop);
            msgv_id = itemView.findViewById(R.id.cardview_list_stu_mgv);


        }


    }


}
