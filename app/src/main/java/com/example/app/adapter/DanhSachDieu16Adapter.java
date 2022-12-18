package com.example.app.adapter;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.DanhSachLuat;

import java.text.DecimalFormat;
import java.util.List;

public class DanhSachDieu16Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<DanhSachLuat> array;
    private static final int VIEW_TYPE_DATA = 0;
    private static final int VIEW_TYPE_LOADING = 1;

    public DanhSachDieu16Adapter(Context context, List<DanhSachLuat> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_DATA){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dieu_luat, parent, false);
            return new MyViewHolderDanhSachDieu16Adapter(view);
        }else {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolderDanhSachDieu16Adapter){
            MyViewHolderDanhSachDieu16Adapter myViewHolderDanhSachDieu16Adapter = (MyViewHolderDanhSachDieu16Adapter) holder;
            DanhSachLuat danhSachLuat = array.get(position);
            myViewHolderDanhSachDieu16Adapter.khoan.setText(String.valueOf(danhSachLuat.getKhoan()));
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            myViewHolderDanhSachDieu16Adapter.mucphatduoi.setText("" + decimalFormat.format(Double.parseDouble(danhSachLuat.getMucphatduoi())) + "Đ");
            myViewHolderDanhSachDieu16Adapter.mucphattren.setText("" + decimalFormat.format(Double.parseDouble(danhSachLuat.getMucphattren())) + "Đ");
        }else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return array.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_DATA;
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressbar);
        }
    }

    public class MyViewHolderDanhSachDieu16Adapter extends RecyclerView.ViewHolder {
        TextView khoan, mucphatduoi, mucphattren;

        public MyViewHolderDanhSachDieu16Adapter(@NonNull View itemView) {
            super(itemView);
            khoan = itemView.findViewById(R.id.sokhoan_item_dieu_luat);
            mucphatduoi = itemView.findViewById(R.id.mucphatduoi_item_dieu_luat);
            mucphattren = itemView.findViewById(R.id.mucphatren_item_dieu_luat);
        }
    }
}
