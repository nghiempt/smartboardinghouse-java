package com.sbh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.api.RecyclerViewInterface;
import com.sbh.models.RoomHouse;

import java.util.List;

public class RoomHouseAdapter extends RecyclerView.Adapter<RoomHouseAdapter.RoomHouseViewHolder> {

    private Context mContext;
    private List<RoomHouse> mListRoomHouse;
    private RecyclerViewInterface iRecyclerViewInterface;

    public RoomHouseAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public RoomHouseAdapter (List<RoomHouse> mListRoomHouse, RecyclerViewInterface listener) {
        this.mListRoomHouse = mListRoomHouse;
        this.iRecyclerViewInterface = listener;
    }

    public void setmListRoomHouse(List<RoomHouse> list) {
        this.mListRoomHouse = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomHouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);

        return new RoomHouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHouseViewHolder holder, int position) {
        final RoomHouse mydata = mListRoomHouse.get(position);
        if (mydata == null) {
            return;
        }
        holder.txtViewNameMotel.setText(mydata.getName());
        holder.txtViewAddressMotel.setText(mydata.getAddress());
        holder.txtViewPriceMotel.setText(Double.toString(mydata.getPrice()));
        holder.txtViewRateMotel.setText(Double.toString(mydata.getRate()));
        holder.txtViewNFeadback.setText("(" + Integer.toString(mydata.getNfeedback()) + "đánh giá)");
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iRecyclerViewInterface.onItemClick(mydata);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListRoomHouse != null) {
            return mListRoomHouse.size();
        }
        return 0;
    }

    public class RoomHouseViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layoutItem;
        TextView txtViewNameMotel;
        TextView txtViewAddressMotel;
        TextView txtViewPriceMotel;
        TextView txtViewRateMotel;
        TextView txtViewNFeadback;

        public RoomHouseViewHolder(@NonNull View itemView) {
            super(itemView);

            txtViewNameMotel = itemView.findViewById(R.id.txtViewNameMotel);
            txtViewAddressMotel = itemView.findViewById(R.id.txtViewAddressMotel);
            txtViewPriceMotel = itemView.findViewById(R.id.txtViewPriceMotel);
            txtViewRateMotel = itemView.findViewById(R.id.txtViewRateMotel);
            txtViewNFeadback = itemView.findViewById(R.id.txtViewNFeadback);
            layoutItem = itemView.findViewById(R.id.layoutRCVItem);
        }
    }
}
