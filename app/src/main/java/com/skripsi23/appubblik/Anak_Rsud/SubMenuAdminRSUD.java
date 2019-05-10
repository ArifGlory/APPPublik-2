package com.skripsi23.appubblik.Anak_Rsud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skripsi23.appubblik.ListChatActivity;
import com.skripsi23.appubblik.R;

public class SubMenuAdminRSUD extends AppCompatActivity {

    Button btnKeChat,btnKeBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_admin_rsud);

        btnKeBooking = findViewById(R.id.btnKeBooking);
        btnKeChat = findViewById(R.id.btnKeChat);

        btnKeBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListBookingAdminRSUD.class);
                startActivity(i);
            }
        });
        btnKeChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListChatActivity.class);
                String namaLayanan = "RSUD";
                String from_id = "rsud";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("from_id",from_id);
                startActivity(i);
            }
        });
    }
}
