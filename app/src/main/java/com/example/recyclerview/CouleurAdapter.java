package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CouleurAdapter extends RecyclerView.Adapter<CouleurAdapter.CouleursViewHolder> {

    String[] titre_couleurs;
    String[] description_couleurs;
    int[] images;
    Context context;

    public CouleurAdapter(Context ct, String[] titre_couleurs, String[] description_couleurs, int[] images) {
        context = ct;
        this.titre_couleurs = titre_couleurs;
        this.description_couleurs = description_couleurs;
        this.images = images;
    }

    public static class CouleursViewHolder extends RecyclerView.ViewHolder {
        TextView titre_couleur, description_couleur;
        ImageView image_couleur;

        public CouleursViewHolder(@NonNull View itemView) {
            super(itemView);
            titre_couleur = itemView.findViewById(R.id.titre_couleur);
            description_couleur = itemView.findViewById(R.id.description_couleur);
            image_couleur = itemView.findViewById(R.id.image_couleur);
        }
    }

    @NonNull
    @Override
    public CouleursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        return new CouleursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouleurAdapter.CouleursViewHolder holder, int position) {
        holder.titre_couleur.setText(titre_couleurs[position]);
        holder.description_couleur.setText(description_couleurs[position]);
        holder.image_couleur.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


}
