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
import com.example.myapplication.ui.CardFactory;


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
        recyclerView.setAdapter(new CardAdapter(new CardFactory().createCardList()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}