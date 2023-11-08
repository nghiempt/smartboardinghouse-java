package com.sbh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.models.House;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChooseHouseAdapter extends RecyclerView.Adapter<ChooseHouseAdapter.ViewHolder> {

    private final List<House> listHouse;

    public ChooseHouseAdapter(List<House> data) {
        this.listHouse = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_house, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final House house = listHouse.get(position);
        String imageUrl = "https://cdn-icons-png.flaticon.com/128/197/197374.png";
        Picasso.get()
                .load(imageUrl)
                .into(holder.houseImage);
        if (house == null) {
            return;
        }
        holder.txtHouseName.setText(house.getName());
    }

    @Override
    public int getItemCount() {
        return listHouse.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtHouseName;
        ImageView houseImage;

        ViewHolder(View itemView) {
            super(itemView);
            txtHouseName = itemView.findViewById(R.id.txtHouseName);
            houseImage = itemView.findViewById(R.id.houseImage);
        }
    }
}
