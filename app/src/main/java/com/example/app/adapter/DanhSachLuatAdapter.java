package com.example.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.DanhSachLuat;

import java.util.List;

public class DanhSachLuatAdapter extends RecyclerView.Adapter<DanhSachLuatAdapter.MyViewHodelDanhSachLuat> {
    Context context;
    List<DanhSachLuat> array;

    public DanhSachLuatAdapter(Context context, List<DanhSachLuat> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHodelDanhSachLuat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsachluat, parent, false);

        return new MyViewHodelDanhSachLuat(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodelDanhSachLuat holder, int position) {
        DanhSachLuat danhSachLuat = array.get(position);
        holder.chuong.setText(String.valueOf(danhSachLuat.getChuong()));
        holder.muc.setText(String.valueOf(danhSachLuat.getMuc()));
        holder.dieu.setText(String.valueOf(danhSachLuat.getDieu()));
        holder.khoan.setText(String.valueOf(danhSachLuat.getKhoan()));
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public class MyViewHodelDanhSachLuat extends RecyclerView.ViewHolder{
        TextView chuong, dieu, muc, khoan;

        public MyViewHodelDanhSachLuat(@NonNull View itemView) {
            super(itemView);

            chuong = itemView.findViewById(R.id.sochuong);
            dieu = itemView.findViewById(R.id.sodieu);
            muc = itemView.findViewById(R.id.somuc);
            khoan = itemView.findViewById(R.id.sokhoan);
        }
    }
}
