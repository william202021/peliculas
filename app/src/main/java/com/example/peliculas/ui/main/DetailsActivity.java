package com.example.peliculas.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.peliculas.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String titleTV = "";
        String releaseTV = "";
        String descriptionTV = "";
        String playTimeTV = "";

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            titleTV = extras.getString("titleTV");
            releaseTV = extras.getString("releaseTV");
            descriptionTV = extras.getString("descriptionTV");
            playTimeTV = extras.getString("playTimeTV");


        }
        TextView tvtitleTV = (TextView) findViewById(R.id.tvtitleTV);
        tvtitleTV.setText(titleTV);

        TextView tvreleaseTV = (TextView) findViewById(R.id.tvreleaseTV);
        tvreleaseTV.setText(releaseTV);

        TextView tvdescriptionTV = (TextView) findViewById(R.id.tvdescriptionTV);
        tvdescriptionTV.setText(descriptionTV);

        TextView tvplayTimeTV = (TextView) findViewById(R.id.tvplayTimeTV);
        tvplayTimeTV.setText(playTimeTV);


    }
}