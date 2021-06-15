package com.fabricio_daniel.proyecto_final;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeliculasCustomAdapter extends RecyclerView.Adapter<PeliculasCustomAdapter.ViewHolder> {

    private ArrayList<Peliculas> dataSet;
    private Activity baseActivity;

    public PeliculasCustomAdapter(ArrayList<Peliculas> data, Activity baseActivity) {
        this.dataSet = data;
        this.baseActivity = baseActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_element, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasCustomAdapter.ViewHolder holder, int position) {

        Peliculas dato = dataSet.get(position);
        holder.mainTitle.setText("ID: "+ dato.getId() + " | " +dato.getNombre());
        holder.subTitle.setText("Fecha de publicacion: " + dato.getFecha_publicacion());
        holder.dato = dato;
        holder.baseActivity = this.baseActivity;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView mainTitle;
        TextView subTitle;
        Button showButton;
        Button editButton;
        Button deleteButton;
        Peliculas dato;
        Activity baseActivity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;

            mainTitle = rootView.findViewById(R.id.elementText);
            subTitle = rootView.findViewById(R.id.subelementText);

            deleteButton = rootView.findViewById(R.id.elementBtnEliminar);
            editButton = rootView.findViewById(R.id.elementBtnEditar);
            showButton = rootView.findViewById(R.id.elementBtnMostrar);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Click en delete en ID " + dato.getId(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(baseActivity, ActivityDelete.class);
                    intent.putExtra("Table", "Peliculas");
                    intent.putExtra("id", dato.getId());
                    baseActivity.startActivity(intent);
                }
            });

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Click en edit en ID " + dato.getId(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(baseActivity, ActivityEdit.class);
                    intent.putExtra("Origen", "Peliculas");
                    intent.putExtra("ID", dato.getId());
                    baseActivity.startActivity(intent);
                }
            });

            showButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Click en show en ID " + dato.getId(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(baseActivity, DisplayActivity.class);
                    intent.putExtra("Origen", "Peliculas");
                    intent.putExtra("ID", dato.getId());
                    baseActivity.startActivity(intent);
                }
            });

        }


    }

}