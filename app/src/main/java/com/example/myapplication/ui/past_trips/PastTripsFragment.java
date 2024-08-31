package com.example.myapplication.ui.past_trips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPastTripsBinding;
import com.example.myapplication.ui.CardAdapter;
import com.example.myapplication.ui.CardItem;

import java.util.ArrayList;
import java.util.List;

public class PastTripsFragment extends Fragment {

    private FragmentPastTripsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PastTripsViewModel pastTripsViewModel =
                new ViewModelProvider(this).get(PastTripsViewModel.class);

        binding = FragmentPastTripsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPastTrips;
        pastTripsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Get RecycleView and append cards containing user info
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CardAdapter(getCardItems()));

        return root;
    }

    private List<CardItem> getCardItems() {
        List<CardItem> items = new ArrayList<>();
        items.add(new CardItem("Trip #13", "You prevented 40.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #12", "You prevented 30.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #11", "You prevented 20.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #10", "You prevented 15.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #9", "You prevented 5.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #8", "You prevented 10.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #7", "You prevented 25.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #6", "You prevented 50.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #5", "You prevented 75.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #4", "You prevented 100.0 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #3", "You prevented 99.9 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #2", "You prevented 66.3 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        items.add(new CardItem("Trip #1", "You prevented 33.3 kt of carbon emissions by walking.", R.drawable.ic_dashboard_black_24dp));
        return items;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}