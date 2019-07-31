package com.example.firstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> listTanggal = new ArrayList<>();
    private ArrayList<String> totals = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> listTanggal, ArrayList<String> totals, Context context) {
        this.listTanggal = listTanggal;
        this.totals = totals;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tanggal.setText(listTanggal.get(position));
    }

    @Override
    public int getItemCount() {
        return listTanggal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tanggal;
        TextView totalPembayaran;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivGambar);
            tanggal = itemView.findViewById(R.id.tvTanggal);
            totalPembayaran = itemView.findViewById(R.id.ivTotalPembayaran);
            cardView = itemView.findViewById(R.id.cvCardView);

        }
    }
}
