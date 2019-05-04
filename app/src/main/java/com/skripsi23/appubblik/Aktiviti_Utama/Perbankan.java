package com.skripsi23.appubblik.Aktiviti_Utama;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.skripsi23.appubblik.R;
import com.skripsi23.appubblik.Anak_Perbankan.bangbca;
import com.skripsi23.appubblik.Anak_Perbankan.bangmandiri;
import com.skripsi23.appubblik.Anak_Perbankan.bankbri;


public class Perbankan extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perbankan);

        androidImageButton = (ImageButton) findViewById(R.id.bri);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), bankbri.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.bca);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), bangbca.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.mandiri);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), bangmandiri.class);

                startActivity(intent);

            }
        });






    }
    
}
