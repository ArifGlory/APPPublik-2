package com.skripsi23.appubblik.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.skripsi23.appubblik.Kelas.BookingRSUD;
import com.skripsi23.appubblik.Kelas.Laporan;
import com.skripsi23.appubblik.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AdapterLaporanPolisi extends RecyclerView.Adapter<AdapterLaporanPolisi.MyViewHolder> {

    private Context mContext;
    private List<Laporan> laporanList;
    DatabaseReference ref,refUser;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    Date date;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNama,txtNope,txtLokasi,txtLaporan,txtTime;
        public LinearLayout lyt_parent;

        public MyViewHolder(View view) {
            super(view);
            txtNama = (TextView) view.findViewById(R.id.txtNama);
            txtNope = (TextView) view.findViewById(R.id.txtNope);
            txtLokasi = (TextView) view.findViewById(R.id.txtLokasi);
            txtLaporan = (TextView) view.findViewById(R.id.txtLaporan);
            txtTime = (TextView) view.findViewById(R.id.txtTime);
            lyt_parent = view.findViewById(R.id.lyt_parent);

        }
    }


    public AdapterLaporanPolisi(Context mContext, List<Laporan> laporanList) {
        this.mContext = mContext;
        this.laporanList = laporanList;

        Firebase.setAndroidContext(mContext);
        FirebaseApp.initializeApp(mContext);
        ref = FirebaseDatabase.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_laporan_polisi, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        if (laporanList.isEmpty()){
            Toast.makeText(mContext.getApplicationContext(),"Data Kosong !",Toast.LENGTH_LONG).show();
            Log.d("isiLaporanlist: ",""+laporanList.size());
        }else {
            final Laporan laporan = laporanList.get(position);

            holder.txtNama.setText(laporan.getNama());
            holder.txtNope.setText(laporan.getNohp());
            holder.txtLokasi.setText("Lokasi : "+laporan.getLokasi());
            holder.txtLaporan.setText(laporan.getLaporan());

            String timestamp                = laporan.getTime();
            timestamp                       = timestamp.substring(0,8);
            SimpleDateFormat dateFormatprev = new SimpleDateFormat("yyyyMMdd");
            try {
                date                      = dateFormatprev.parse(timestamp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            String changedDate = dateFormat.format(date);

            holder.txtTime.setText(changedDate);

            holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }


    }



    @Override
    public int getItemCount() {
       // return namaWisata.length;
        return  laporanList.size();
    }
}
