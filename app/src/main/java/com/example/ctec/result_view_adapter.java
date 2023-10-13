package com.example.ctec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class result_view_adapter extends RecyclerView.Adapter<result_view_adapter.result_holder> {
    private Context context;
    private ArrayList   masv, d11,d12,d13,d21,d22,d23,d31,tbm,tbhp;

    @NonNull
    @Override
    public result_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tch_result_view,parent,false);
        return new result_holder(view);
    }

    public result_view_adapter(Context context, ArrayList masv, ArrayList d11, ArrayList d12, ArrayList d13, ArrayList d21, ArrayList d22, ArrayList d23, ArrayList d31, ArrayList tbm, ArrayList tbhp) {
        this.context = context;
        this.masv = masv;
        this.d11 = d11;
        this.d12 = d12;
        this.d13 = d13;
        this.d21 = d21;
        this.d22 = d22;
        this.d23 = d23;
        this.d31 = d31;
        this.tbm = tbm;
        this.tbhp = tbhp;
    }

    @Override
    public void onBindViewHolder(@NonNull result_holder holder, int position) {

        holder.masv.setText(String.valueOf(masv.get(position)));
        holder.d11.setText(String.valueOf(d11.get(position)));
        holder.d12.setText(String.valueOf(d12.get(position)));
        holder.d13.setText(String.valueOf(d13.get(position)));
        holder.d21.setText(String.valueOf(d21.get(position)));
        holder.d21.setText(String.valueOf(d21.get(position)));
        holder.d22.setText(String.valueOf(d22.get(position)));
        holder.d23.setText(String.valueOf(d23.get(position)));
        holder.d23.setText(String.valueOf(d23.get(position)));

    }

    @Override
    public int getItemCount() {
        return masv.size();
    }

    public class result_holder extends RecyclerView.ViewHolder{
        TextView tenmon, tensv, masv, d11,d12,d13,d21,d22,d23,d31,tbm,tbhp;


        public result_holder(@NonNull View itemView) {
            super(itemView);
           tenmon = itemView.findViewById(R.id.result_oj_name);
           masv = itemView.findViewById(R.id.result_stu_msv);
           tensv = itemView.findViewById(R.id.result_stu_ten);
           d11 = itemView.findViewById(R.id.resutl_view_d11);
           d12 = itemView.findViewById(R.id.resutl_view_d12);
           d13 = itemView.findViewById(R.id.resutl_view_d13);
           d21 = itemView.findViewById(R.id.resutl_view_d21);
           d22 = itemView.findViewById(R.id.resutl_view_d22);
           d23 = itemView.findViewById(R.id.resutl_view_d23);
           d31 =itemView.findViewById(R.id.resutl_view_d31);
           tbm =itemView.findViewById(R.id.resutl_view_tbm);
           tbhp = itemView.findViewById(R.id.resutl_view_tbhp);


        }


    }


}
