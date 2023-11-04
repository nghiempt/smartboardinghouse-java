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
import com.sbh.models.Room;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private Context mContext;
    private List<Room> mListRoom;
    private RecyclerViewInterface iRecyclerViewInterface;

    public RoomAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public RoomAdapter (List<Room> mListRoom, RecyclerViewInterface listener) {
        this.mListRoom = mListRoom;
        this.iRecyclerViewInterface = listener;
    }

    public void setmListRoom(List<Room> list) {
        this.mListRoom = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomAdapter.RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);

        return new RoomAdapter.RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.RoomViewHolder holder, int position) {
        final Room mydata = mListRoom.get(position);
        if (mydata == null) {
            return;
        }
        holder.txtRoomNumber.setText(Integer.toString(mydata.getNumberRoom()));
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iRecyclerViewInterface.onRoomClickManage(mydata);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListRoom != null) {
            return mListRoom.size();
        }
        return 0;
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layoutItem;
        TextView txtRoomNumber;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);

            txtRoomNumber = itemView.findViewById(R.id.txtRoomNumber);
            layoutItem = itemView.findViewById(R.id.layoutRCVItemRoom);
        }
    }
}
