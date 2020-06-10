package com.dapstd.workreport.ui.work_zone;

import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dapstd.workreport.R;

import java.util.ArrayList;
import java.util.List;

public class WorkZoneFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_work_zone, container, false);

        Button addBtn = root.findViewById(R.id.add_work_button);

        RecyclerView workListView = root.findViewById(R.id.work_list_recycler_view);
        workListView.setHasFixedSize(true);
        List<Work> works = new ArrayList<>();
        works.add(new Work("desctiprion"));
        WorkListAdapter adapter = new WorkListAdapter(works);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        workListView.setLayoutManager(linearLayoutManager);
        workListView.setAdapter(adapter);
        addBtn.setOnClickListener(v -> {
            works.add(new Work("desctiprion"));
            adapter.notifyDataSetChanged();
        });
        works.add(new Work("desctiprion"));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        workListView.setItemAnimator(itemAnimator);
        return root;
    }
}
