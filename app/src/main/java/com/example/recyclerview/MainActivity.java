package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_couleurs;

    String[] titres;
    String[] descriptions;
    int[] images = {R.drawable.bleu, R.drawable.rouge, R.drawable.vert, R.drawable.jaune, R.drawable.orange, R.drawable.violet, R.drawable.marron, R.drawable.gris, R.drawable.rose, R.drawable.cyan};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_couleurs = findViewById(R.id.rv_couleurs);

        titres = getResources().getStringArray(R.array.couleur);
        descriptions = getResources().getStringArray(R.array.description);

        CouleurAdapter couleurAdapter = new CouleurAdapter(this, titres, descriptions, images);
        rv_couleurs.setHasFixedSize(true);
        rv_couleurs.setAdapter(couleurAdapter);
        rv_couleurs.setLayoutManager(new LinearLayoutManager(this));

    }
}