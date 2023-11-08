package com.sbh.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.models.House;
import com.sbh.models.Room;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListRoomAdapter extends RecyclerView.Adapter<ListRoomAdapter.ViewHolder> {

    private final List<Room> listRoom;

    public ListRoomAdapter(List<Room> data) {
        this.listRoom = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Room room = listRoom.get(position);
        holder.txtRoomNumber.setText(room.getRoomNumber() + "");
    }

    @Override
    public int getItemCount() {
        return listRoom.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRoomNumber;

        ViewHolder(View itemView) {
            super(itemView);
            txtRoomNumber = itemView.findViewById(R.id.txtRoomNumber);
        }
    }
}
