package com.skripsi23.appubblik.Anak_Perbankan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skripsi23.appubblik.R;

public class bankbri extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankbri);

        androidImageButton = (ImageButton) findViewById(R.id.atmbri);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), atmbri.class);

                startActivity(intent);

            }
        });
    }
}
