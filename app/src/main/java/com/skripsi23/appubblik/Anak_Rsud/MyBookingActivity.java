package com.skripsi23.appubblik.Anak_Rsud;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.skripsi23.appubblik.Adapter.AdapterBookingRsud;
import com.skripsi23.appubblik.Kelas.BookingRSUD;
import com.skripsi23.appubblik.Kelas.SharedVariable;
import com.skripsi23.appubblik.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MyBookingActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    AdapterBookingRsud adapter;
    private List<BookingRSUD> bookingList;
    DatabaseReference ref,refUser;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    private SweetAlertDialog pDialogLoading,pDialodInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(getApplicationContext());
        ref = FirebaseDatabase.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();

        bookingList = new ArrayList<>();
        recycler_view = findViewById(R.id.recycler_view);
        adapter = new AdapterBookingRsud(MyBookingActivity.this,bookingList);

        recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler_view.setHasFixedSize(true);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(adapter);

        pDialogLoading = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialogLoading.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogLoading.setTitleText("Menampilkan data..");
        pDialogLoading.setCancelable(false);
        pDialogLoading.show();

        getBookingData();

    }

    private void getBookingData(){
        ref.child("booking_rsud").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bookingList.clear();
                adapter.notifyDataSetChanged();

                if (!dataSnapshot.exists()){
                    new SweetAlertDialog(MyBookingActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Data Kosong")
                            .setContentText("Tidak ada data booking untuk saat ini")
                            .show();
                    pDialogLoading.dismiss();
                }else {
                    for (DataSnapshot child : dataSnapshot.getChildren()){

                        String key                      = child.getKey();
                        String idUser                   = child.child("idUser").getValue().toString();

                        if (idUser.equals(SharedVariable.userID)){
                            final BookingRSUD bookingRSUD   = child.getValue(BookingRSUD.class);
                            bookingRSUD.setIdBooking(key);
                            bookingList.add(bookingRSUD);

                        }

                    }
                    Collections.reverse(bookingList);
                    adapter.notifyDataSetChanged();
                    pDialogLoading.dismiss();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
