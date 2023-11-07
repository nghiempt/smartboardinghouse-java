package com.sbh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;

import java.util.List;

public class ListRoomAdapter extends RecyclerView.Adapter<ListRoomAdapter.ViewHolder> {

    private final List<String> txtRoomNumber;

    public ListRoomAdapter(List<String> data) {
        this.txtRoomNumber = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = txtRoomNumber.get(position);
        holder.txtRoomNumber.setText(name);
    }

    @Override
    public int getItemCount() {
        return txtRoomNumber.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRoomNumber;

        ViewHolder(View itemView) {
            super(itemView);
            txtRoomNumber = itemView.findViewById(R.id.txtRoomNumber);
        }
    }
}
