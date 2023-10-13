package com.example.ctec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class oj_mng_adapter extends RecyclerView.Adapter<oj_mng_adapter.oj_list_holder> {
    private Context context;
    private ArrayList mamon_id, tenmon_id, sotinhchi_id, mahk_id;

    public oj_mng_adapter(Context context, ArrayList mamon_id, ArrayList tenmon_id,ArrayList sotinchi_id,ArrayList mahk_id) {
        this.context = context;
        this.mamon_id = mamon_id;
        this.tenmon_id = tenmon_id;
         this.mahk_id = mahk_id;
         this.sotinhchi_id = sotinchi_id;
    }

    @NonNull
    @Override
    public oj_list_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tch_object_view,parent,false);

        return new oj_list_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull oj_list_holder holder, int position) {
        holder.mamon_id.setText(String.valueOf(mamon_id.get(position)));
        holder.tenmon_id.setText(String.valueOf(tenmon_id.get(position)));
        holder.sotinchi_id.setText(String.valueOf(sotinhchi_id.get(position)));
        holder.mahk_id.setText(String.valueOf(mahk_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return mamon_id.size();
    }

    public class oj_list_holder extends RecyclerView.ViewHolder {
        TextView mamon_id, tenmon_id, sotinchi_id, mahk_id;
        public oj_list_holder(@NonNull View itemView) {
            super(itemView);
            mamon_id = itemView.findViewById(R.id.oj_id);
            tenmon_id = itemView.findViewById(R.id.oj_name);
            sotinchi_id = itemView.findViewById(R.id.oj_credit);
            mahk_id = itemView.findViewById(R.id.oj_sesID);

        }
    }
}
