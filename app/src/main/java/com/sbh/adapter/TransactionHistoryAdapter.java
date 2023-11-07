
package com.sbh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;

import java.util.List;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {

    private final List<String> txHistory;

    public TransactionHistoryAdapter(List<String> data) {
        this.txHistory = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = txHistory.get(position);
        holder.txHistory.setText(name);
    }

    @Override
    public int getItemCount() {
        return txHistory.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txHistory;

        ViewHolder(View itemView) {
            super(itemView);
            txHistory = itemView.findViewById(R.id.txHistory);
        }
    }
}
