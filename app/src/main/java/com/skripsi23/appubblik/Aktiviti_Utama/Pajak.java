package com.skripsi23.appubblik.Aktiviti_Utama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skripsi23.appubblik.R;
import com.skripsi23.appubblik.Anak_Pajak.limatahun;
import com.skripsi23.appubblik.Anak_Pajak.satutahun;

public class Pajak extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pajak);

        androidImageButton = (ImageButton) findViewById(R.id.setahun);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), satutahun.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.limatahun);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), limatahun.class);

                startActivity(intent);

            }
        });


    }
}
