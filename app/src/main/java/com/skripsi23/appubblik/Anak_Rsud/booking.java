package com.skripsi23.appubblik.Anak_Rsud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.skripsi23.appubblik.R;

public class booking extends AppCompatActivity {

    Button btn_GIGI,btn_ANAK,btn_THT,btn_MATA,btn_dalam,btn_KULIT
            ,btn_SYARAF,btn_AKUPUNTUR,btn_BIDAN;
    Intent intent;
    LinearLayout linePesananSaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        btn_GIGI = findViewById(R.id.btn_GIGI);
        btn_ANAK = findViewById(R.id.btn_ANAK);
        btn_THT = findViewById(R.id.btn_THT);
        btn_MATA = findViewById(R.id.btn_MATA);
        btn_dalam = findViewById(R.id.btn_dalam);
        btn_KULIT = findViewById(R.id.btn_KULIT);
        btn_SYARAF = findViewById(R.id.btn_SYARAF);
        btn_AKUPUNTUR = findViewById(R.id.btn_AKUPUNTUR);
        btn_BIDAN = findViewById(R.id.btn_BIDAN);
        linePesananSaya = findViewById(R.id.linePesananSaya);

        btn_GIGI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Gigi");
                startActivity(intent);
            }
        });
        btn_ANAK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Anak");
                startActivity(intent);
            }
        });
        btn_THT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli THT");
                startActivity(intent);
            }
        });
        btn_MATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Mata");
                startActivity(intent);
            }
        });
        btn_dalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Penyakit Dalam");
                startActivity(intent);
            }
        });
        btn_KULIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Kulit");
                startActivity(intent);
            }
        });
        btn_SYARAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Syaraf");
                startActivity(intent);
            }
        });
        btn_AKUPUNTUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Akupuntur");
                startActivity(intent);
            }
        });
        btn_BIDAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),DaftarBooking.class);
                intent.putExtra("title","Poli Bidan");
                startActivity(intent);
            }
        });
        linePesananSaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MyBookingActivity.class);
                startActivity(intent);
            }
        });




    }
}
