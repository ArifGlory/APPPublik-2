package com.skripsi23.appubblik;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.skripsi23.appubblik.Adapter.AdapterLaporanPolisi;
import com.skripsi23.appubblik.Anak_Rsud.MyBookingActivity;
import com.skripsi23.appubblik.Kelas.Laporan;
import com.skripsi23.appubblik.Kelas.SharedVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ListPengaduan extends AppCompatActivity {

    public int txtNama;
    RecyclerView recycler_view;
    AdapterLaporanPolisi adapter;
    private List<Laporan> laporanList;
    DatabaseReference ref,refUser;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    private SweetAlertDialog pDialogLoading,pDialodInfo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pengaduan);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(getApplicationContext());
        ref = FirebaseDatabase.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();

        laporanList = new ArrayList<>();
        recycler_view = findViewById(R.id.recycler_view);
        adapter     = new AdapterLaporanPolisi(this,laporanList);

        recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler_view.setHasFixedSize(true);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(adapter);

        pDialogLoading = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialogLoading.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogLoading.setTitleText("Menampilkan data..");
        pDialogLoading.setCancelable(false);
        pDialogLoading.show();

        getLaporanData();

    }

    private void getLaporanData(){
        ref.child("laporan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                laporanList.clear();
                adapter.notifyDataSetChanged();

                if (!dataSnapshot.exists()){
                    new SweetAlertDialog(ListPengaduan.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Data Kosong")
                            .setContentText("Tidak ada data booking untuk saat ini")
                            .show();
                    pDialogLoading.dismiss();
                }else {
                    for (DataSnapshot child : dataSnapshot.getChildren()){

                        String time     = child.getKey();
                        String idUser   = child.child("userID").getValue().toString();

                        if (SharedVariable.email.equals("admin@mail.com")){
                            //take all laporan
                            final Laporan laporan = child.getValue(Laporan.class);
                            laporan.setTime(time);
                            laporanList.add(laporan);
                        }else {
                            //only take user's laporan
                            if (idUser.equals(SharedVariable.userID)){
                                final Laporan laporan = child.getValue(Laporan.class);
                                laporan.setTime(time);
                                laporanList.add(laporan);
                            }
                        }

                        Collections.reverse(laporanList);
                        adapter.notifyDataSetChanged();
                        pDialogLoading.dismiss();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}

