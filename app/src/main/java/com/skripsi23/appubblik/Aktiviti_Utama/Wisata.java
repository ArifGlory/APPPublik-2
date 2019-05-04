package com.skripsi23.appubblik.Aktiviti_Utama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skripsi23.appubblik.R;
import com.skripsi23.appubblik.Anak_Wisata.airterjun;
import com.skripsi23.appubblik.Anak_Wisata.bdgsekampung;
import com.skripsi23.appubblik.Anak_Wisata.bukittursina;
import com.skripsi23.appubblik.Anak_Wisata.talangindah;
import com.skripsi23.appubblik.Anak_Wisata.talangresort;
import com.skripsi23.appubblik.Anak_Wisata.telagagupit;

public class Wisata extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        androidImageButton = (ImageButton) findViewById(R.id.indah);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), talangindah.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.gupit);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), telagagupit.class);

                startActivity(intent);

            }
        });


        androidImageButton = (ImageButton) findViewById(R.id.sekampung);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), bdgsekampung.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.terjun);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), airterjun.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.tlgresort);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), talangresort.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.bkttursina);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), bukittursina.class);

                startActivity(intent);

            }
        });






    }
}
