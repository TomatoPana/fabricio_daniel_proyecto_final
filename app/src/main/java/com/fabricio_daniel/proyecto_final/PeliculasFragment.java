package com.fabricio_daniel.proyecto_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PeliculasFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton FAB;

    public PeliculasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peliculas, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        FAB = view.findViewById(R.id.floating_action_button);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Peliculas> mDataset;

        PeliculasDB database = new PeliculasDB();

        mDataset = database.getPeliculas();

        recyclerView.setAdapter(new PeliculasCustomAdapter(mDataset, getActivity()));
        recyclerView.setLayoutManager(linearLayoutManager);

	    FAB.setOnClickListener(v -> {
            Intent newActivity = new Intent(getActivity(), CreateActivity.class);
            newActivity.putExtra("Origen", "Peliculas");
        startActivity(newActivity);
        });

        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Peliculas> mDataset;

        PeliculasDB database = new PeliculasDB();

        mDataset = database.getPeliculas();

        recyclerView.setAdapter(new PeliculasCustomAdapter(mDataset, getActivity()));
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}