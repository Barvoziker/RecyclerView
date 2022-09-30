package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Details extends AppCompatActivity {

    ImageView c_image;
    TextView c_titre, c_description;
    String titre_couleur, description_couleur;
    int image_couleur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        c_image = findViewById(R.id.single_image_couleur);
        c_titre = findViewById(R.id.single_titre_couleur);
        c_description = findViewById(R.id.single_description_couleur);

        getData();
        setData();

    }

    /**
     * It gets the data from the intent and puts it in the variables
     */
    private void getData(){
        if(getIntent().hasExtra("image_couleur") && getIntent().hasExtra("titre_couleur") && getIntent().hasExtra("description_couleur")){
            titre_couleur = getIntent().getStringExtra("titre_couleur");
            description_couleur = getIntent().getStringExtra("description_couleur");
            image_couleur = getIntent().getIntExtra("image_couleur", 1);
        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * It sets the data of the card.
     */
    private void setData(){
        c_titre.setText(titre_couleur);
        c_description.setText(description_couleur);
        c_image.setImageResource(image_couleur);
    }

}