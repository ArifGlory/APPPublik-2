package com.skripsi23.appubblik;

import android.graphics.Color;
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
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.skripsi23.appubblik.Anak_Rsud.DaftarBooking;
import com.skripsi23.appubblik.Kelas.Laporan;
import com.skripsi23.appubblik.Kelas.SharedVariable;

import java.text.SimpleDateFormat;

import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.fasterxml.jackson.databind.util.ISO8601Utils.format;

public class TambahLaporan extends AppCompatActivity {

    Button btnlaporan;
    EditText etnamap,etnohp,etlokasi,etlaporan;
    String time;

    Firebase Kref;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    private SweetAlertDialog pDialogLoading;
    Laporan laporan;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_laporan);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(TambahLaporan.this);
        Kref = new Firebase("https://appubblik-9c8ec.firebaseio.com/").child("laporan");
        fAuth = FirebaseAuth.getInstance();

        pDialogLoading = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialogLoading.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogLoading.setTitleText("Loading..");
        pDialogLoading.setCancelable(false);

        btnlaporan = (Button) findViewById(R.id.btnlaporan);
        etnamap = (EditText) findViewById(R.id.etnamap);
        etnohp = (EditText) findViewById(R.id.etnohp);
        etlokasi = (EditText) findViewById(R.id.etlokasi);
        etlaporan = (EditText) findViewById(R.id.etlaporan);

        time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        btnlaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });

    }

    private void clearData(){
        etnamap.setText("");
        etnohp.setText("");
        etlokasi.setText("");
        etlaporan.setText("");

    }

    private void checkValidation() {
        String getNama      = etnamap.getText().toString();
        String getNope      = etnohp.getText().toString();
        String getLokasi    = etlokasi.getText().toString();
        String getLaporan   = etlaporan.getText().toString();

        if (getNama.equals("") || getNama.length() == 0 ||
            getNope.equals("") || getNope.length() == 0 ||
                getLokasi.equals("") || getLokasi.length() == 0 ||
                getLaporan.equals("") || getLaporan.length() == 0){
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Semua Field Harus diisi")
                    .show();
        }else{
            pDialogLoading.show();

            sendData(getNama,getNope,getLokasi,getLaporan);
        }
    }

    private void sendData(String nama,String nohape,String lokasi,String laporan){
        Laporan laporanNew = new Laporan(nama,
                nohape,
                lokasi,
                laporan,
                SharedVariable.userID);


        Kref.child(time).setValue(laporanNew);

        pDialogLoading.dismiss();
        new SweetAlertDialog(TambahLaporan.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Berhasil")
                .setContentText("Pendaftaran berhasil dikirim")
                .show();
        clearData();
    }
}
