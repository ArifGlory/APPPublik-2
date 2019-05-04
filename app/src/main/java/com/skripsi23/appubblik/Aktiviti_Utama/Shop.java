package com.skripsi23.appubblik.Aktiviti_Utama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skripsi23.appubblik.R;
import com.skripsi23.appubblik.Anak_Belanja.centerbusana;
import com.skripsi23.appubblik.Anak_Belanja.chandra;
import com.skripsi23.appubblik.Anak_Belanja.difes;
import com.skripsi23.appubblik.Anak_Belanja.doortugoods;
import com.skripsi23.appubblik.Anak_Belanja.hobnob;
import com.skripsi23.appubblik.Anak_Belanja.mmseribu;

public class Shop extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        androidImageButton = (ImageButton) findViewById(R.id.chandra);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), chandra.class);

                startActivity(intent);

            }
        });


        androidImageButton = (ImageButton) findViewById(R.id.mmseribu);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), mmseribu.class);

                startActivity(intent);

            }
        });


        androidImageButton = (ImageButton) findViewById(R.id.centerbusana);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), centerbusana.class);

                startActivity(intent);

            }
        });


        androidImageButton = (ImageButton) findViewById(R.id.difes);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), difes.class);

                startActivity(intent);

            }
        });


        androidImageButton = (ImageButton) findViewById(R.id.hobnob);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), hobnob.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.doortugoods);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), doortugoods.class);

                startActivity(intent);

            }
        });


    }
}
