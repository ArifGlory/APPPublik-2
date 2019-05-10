package com.skripsi23.appubblik.Anak_Rsud;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.skripsi23.appubblik.Kelas.BookingRSUD;
import com.skripsi23.appubblik.Kelas.SharedVariable;
import com.skripsi23.appubblik.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DaftarBooking extends AppCompatActivity {

    Toolbar toolbar;
    String title;
    Intent i;
    Button btnPesan;
    EditText etNama,etUmur,etAlamat;
    DatabaseReference ref;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    private SweetAlertDialog pDialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_booking);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(DaftarBooking.this);
        ref = FirebaseDatabase.getInstance().getReference();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        i = getIntent();
        title = i.getStringExtra("title");

        toolbar.setTitle("Daftar "+title);
        btnPesan = findViewById(R.id.btnPesan);
        etNama = findViewById(R.id.etNama);
        etUmur = findViewById(R.id.etUmur);
        etAlamat = findViewById(R.id.etAlamat);

        pDialogLoading = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialogLoading.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogLoading.setTitleText("Loading..");
        pDialogLoading.setCancelable(false);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });

    }

    private void checkValidation(){
        String getNama = etNama.getText().toString();
        String getUmur = etUmur.getText().toString();
        String getAlamat = etAlamat.getText().toString();

        if (getNama.equals("") || getNama.length() == 0
                || getUmur.equals("") || getUmur.length() == 0
                || getAlamat.equals("") || getAlamat.length() == 0
                ) {

            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Semua Field Harus diisi")
                    .show();
        }else{
            pDialogLoading.show();
            sendData(getNama,getUmur,getAlamat);
        }
    }

    private void sendData(String nama,String umur,String alamat){
        final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        BookingRSUD bookingRSUD = new BookingRSUD(nama,umur,alamat,SharedVariable.nope,title,SharedVariable.userID,timeStamp);

        String key = ref.child("booking_rsud").push().getKey();
        final Task inittask =  ref.child("booking_rsud").child(key).setValue(bookingRSUD);

        inittask.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (inittask.isSuccessful()){
                    pDialogLoading.dismiss();
                    new SweetAlertDialog(DaftarBooking.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Berhasil")
                            .setContentText("Pendaftaran berhasil dikirim")
                            .show();
                    clearEditText();
                }else {
                    pDialogLoading.dismiss();
                    new SweetAlertDialog(DaftarBooking.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops...")
                            .setContentText("Pendaftaran gagal,coba lagi natni")
                            .show();
                    Log.d("bookingRSUD:",""+inittask.getException());
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("bookingRSUD:",""+e.toString());
            }
        });

    }

    private void clearEditText(){
        etNama.setText("");
        etUmur.setText("");
        etAlamat.setText("");
    }


}
