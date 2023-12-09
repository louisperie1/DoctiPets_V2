package com.example.doctipets_v2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctipets_v2.R;

import java.util.ArrayList;
import java.util.List;

public class RechercheAdapter extends RecyclerView.Adapter<RechercheAdapter.ViewHolder> {

    // Boîte pour ranger tous les composants à contrôler
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Image de l'actualité
        public ImageView RechercheImage;

        public ViewHolder(View view) {
            super(view);
            RechercheImage = view.findViewById(R.id.image_item_recherche);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical_recherche, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 5; // renvoyer le nombre d'items dans la liste
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }
}
