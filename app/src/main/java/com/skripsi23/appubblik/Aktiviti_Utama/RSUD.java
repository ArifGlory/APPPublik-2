package com.skripsi23.appubblik.Aktiviti_Utama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.skripsi23.appubblik.Anak_Rsud.BPJS;
import com.skripsi23.appubblik.ChatKeCS;
import com.skripsi23.appubblik.R;
import com.skripsi23.appubblik.Anak_Rsud.RSUDMAP;
import com.skripsi23.appubblik.Anak_Rsud.Rawatinap;
import com.skripsi23.appubblik.Anak_Rsud.ambulans;
import com.skripsi23.appubblik.Anak_Rsud.booking;
import com.skripsi23.appubblik.Anak_Rsud.dokterrs;
import com.skripsi23.appubblik.Anak_Rsud.jambesuk;
import com.skripsi23.appubblik.Anak_Rsud.kamarrs;
import com.skripsi23.appubblik.Anak_Rsud.ttpasien;

public class RSUD extends AppCompatActivity {

    Button btnBPJS,btnDokterPraktik,btnCS,btnRawatJalan,btnAmbulans,btnJamBesuk,
            btnLokasi,btnKamar,btnTataTertib,btnBooking;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsud);

        btnBPJS = findViewById(R.id.btnBPJS);
        btnDokterPraktik = findViewById(R.id.btnDokterPraktik);
        btnCS = findViewById(R.id.btnCS);
        btnRawatJalan = findViewById(R.id.btnRawatJalan);
        btnAmbulans = findViewById(R.id.btnAmbulans);
        btnJamBesuk = findViewById(R.id.btnJamBesuk);
        btnLokasi = findViewById(R.id.btnLokasi);
        btnKamar = findViewById(R.id.btnKamar);
        btnTataTertib = findViewById(R.id.btnTataTertib);
        btnBooking = findViewById(R.id.btnBooking);

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),booking.class);
                startActivity(intent);
            }
        });
        btnBPJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),BPJS.class);
                startActivity(intent);
            }
        });
        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),RSUDMAP.class);
                startActivity(intent);
            }
        });
        btnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),ChatKeCS.class);
                String namaLayanan = "RSUD";
                String to_id = "rsud";
                intent.putExtra("namaLayanan",namaLayanan);
                intent.putExtra("to_id",to_id);
                startActivity(intent);
            }
        });
        btnRawatJalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),Rawatinap.class);
                startActivity(intent);
            }
        });
        btnDokterPraktik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), dokterrs.class);
                startActivity(intent);
            }
        });
        btnJamBesuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), jambesuk.class);
                startActivity(intent);
            }
        });
        btnKamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), kamarrs.class);
                startActivity(intent);
            }
        });
        btnTataTertib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), ttpasien.class);
                startActivity(intent);
            }
        });

    }


}
