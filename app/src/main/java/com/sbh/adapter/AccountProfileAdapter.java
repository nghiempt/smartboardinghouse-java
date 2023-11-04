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
import com.sbh.models.AccountProfile;
import com.sbh.models.Room;

import java.util.List;

public class AccountProfileAdapter extends RecyclerView.Adapter<AccountProfileAdapter.AccountProfileHolder> {

    private Context mContext;
    private List<AccountProfile> mListProfile;
    private RecyclerViewInterface iRecyclerViewInterface;

    public AccountProfileAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public AccountProfileAdapter(List<AccountProfile> mListProfile, RecyclerViewInterface listener) {
        this.mListProfile = mListProfile;
        this.iRecyclerViewInterface = listener;
    }

    public void setmListProfile(List<AccountProfile> list) {
        this.mListProfile = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AccountProfileAdapter.AccountProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new AccountProfileAdapter.AccountProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountProfileAdapter.AccountProfileHolder holder, int position) {
        final AccountProfile mydata = mListProfile.get(position);
        if (mydata == null) {
            return;
        }
        holder.txtViewNameMember.setText(mydata.getFullName());
        holder.txtViewBirthday.setText(mydata.getBirthday().toString());
        holder.txtViewPhoneNumber.setText(mydata.getPhoneNumber());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iRecyclerViewInterface.onRoomDetailClickManage(mydata);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListProfile != null) {
            return mListProfile.size();
        }
        return 0;
    }

    public class AccountProfileHolder extends RecyclerView.ViewHolder {
        LinearLayout layoutItem;
        TextView txtViewNameMember;
        TextView txtViewBirthday;
        TextView txtViewPhoneNumber;

        public AccountProfileHolder(@NonNull View itemView) {
            super(itemView);

            txtViewNameMember = itemView.findViewById(R.id.txtViewNameMember);
            txtViewBirthday = itemView.findViewById(R.id.txtViewBirthday);
            txtViewPhoneNumber = itemView.findViewById(R.id.txtViewPhoneNumber);
            layoutItem = itemView.findViewById(R.id.layoutRCVItemMember);
        }
    }
}
