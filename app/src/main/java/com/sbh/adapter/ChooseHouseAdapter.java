package com.sbh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;

import java.util.List;

public class ChooseHouseAdapter extends RecyclerView.Adapter<ChooseHouseAdapter.ViewHolder> {

    private final List<String> txtHouseName;

    public ChooseHouseAdapter(List<String> data) {
        this.txtHouseName = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_house, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = txtHouseName.get(position);
        holder.txtHouseName.setText(name);
    }

    @Override
    public int getItemCount() {
        return txtHouseName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtHouseName;

        ViewHolder(View itemView) {
            super(itemView);
            txtHouseName = itemView.findViewById(R.id.txtHouseName);
        }
    }
}
