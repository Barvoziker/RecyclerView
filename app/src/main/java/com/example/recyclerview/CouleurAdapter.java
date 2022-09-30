package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
        View mainLayout;

        public CouleursViewHolder(@NonNull View itemView) {
            super(itemView);
            titre_couleur = itemView.findViewById(R.id.titre_couleur);
            description_couleur = itemView.findViewById(R.id.description_couleur);
            image_couleur = itemView.findViewById(R.id.image_couleur);
            mainLayout = itemView.findViewById(R.id.main_layout);
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
    public void onBindViewHolder(@NonNull CouleurAdapter.CouleursViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("titre_couleur", titre_couleurs[position]);
                intent.putExtra("description_couleur", description_couleurs[position]);
                intent.putExtra("image_couleur", images[position]);
                context.startActivity(intent);
            }
        });
        holder.titre_couleur.setText(titre_couleurs[position]);
        holder.description_couleur.setText(description_couleurs[position]);
        holder.image_couleur.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


}
