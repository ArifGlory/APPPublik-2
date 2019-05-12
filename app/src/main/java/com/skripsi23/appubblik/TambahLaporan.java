package com.skripsi23.appubblik;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.skripsi23.appubblik.Kelas.Laporan;
import com.skripsi23.appubblik.Kelas.SharedVariable;

import java.text.SimpleDateFormat;

import java.util.Date;

import static com.fasterxml.jackson.databind.util.ISO8601Utils.format;

public class TambahLaporan extends AppCompatActivity {

    Button btnlaporan;
    EditText etnamap,etnohp,etlokasi,etlaporan;
    String time;

    Firebase Kref;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_laporan);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(TambahLaporan.this);
        Kref = new Firebase("https://appubblik-9c8ec.firebaseio.com/").child("laporan");
        fAuth = FirebaseAuth.getInstance();

        btnlaporan = (Button) findViewById(R.id.btnlaporan);
        etnamap = (EditText) findViewById(R.id.etnamap);
        etnohp = (EditText) findViewById(R.id.etnohp);
        etlokasi = (EditText) findViewById(R.id.etlokasi);
        etlaporan = (EditText) findViewById(R.id.etlaporan);

        time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        btnlaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Laporan polisi =new Laporan(etnamap.getText().toString(),
                        etnohp.getText().toString(),
                        etlokasi.getText().toString(),
                        etlaporan.getText().toString(),
                        SharedVariable.userID);


                Kref.child(time).setValue(polisi);

                Toast.makeText(TambahLaporan.this,"Laporan Anda Telah Di Terima \n" +
                        " ",Toast.LENGTH_LONG).show();
                etnamap.setText("");
                etnohp.setText("");
                etlokasi.setText("");
                etlaporan.setText("");



            }
        });


    }
}
