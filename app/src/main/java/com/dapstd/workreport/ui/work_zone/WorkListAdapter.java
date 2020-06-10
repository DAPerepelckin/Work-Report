package com.dapstd.workreport.ui.work_zone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dapstd.workreport.R;

import java.util.List;

public class WorkListAdapter extends RecyclerView.Adapter<WorkListAdapter.MyViewHolder> {

    private List<Work> workArrayList;

    WorkListAdapter(List<Work> workArrayList) {
        this.workArrayList = workArrayList;
    }

    @NonNull
    @Override
    public WorkListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View workView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new WorkListAdapter.MyViewHolder(workView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkListAdapter.MyViewHolder holder, int position) {
        Work work = workArrayList.get(position);
        holder.descriptionTextView.setText(work.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.workArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView descriptionTextView;
        TextView timeTextView;
        TextView btnMenuTextView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view_item);
            descriptionTextView = itemView.findViewById(R.id.description_view);
            timeTextView = itemView.findViewById(R.id.time_view);
            btnMenuTextView = itemView.findViewById(R.id.btn_menu);

        }


    }
}

