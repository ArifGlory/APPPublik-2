package com.skripsi23.appubblik.Anak_Polisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skripsi23.appubblik.ListChatActivity;
import com.skripsi23.appubblik.ListPengaduan;
import com.skripsi23.appubblik.R;

public class SubMenuPolisiAdmin extends AppCompatActivity {

    Button btnKeLaporan,btnKeChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_polisi_admin);

        btnKeChat = findViewById(R.id.btnKeChat);
        btnKeLaporan = findViewById(R.id.btnKeLaporan);

        btnKeChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListChatActivity.class);
                String namaLayanan = "Polisi";
                String from_id = "polisi";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("from_id",from_id);
                startActivity(i);
            }
        });
        btnKeLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListPengaduan.class);
                startActivity(intent);
            }
        });
    }
}
