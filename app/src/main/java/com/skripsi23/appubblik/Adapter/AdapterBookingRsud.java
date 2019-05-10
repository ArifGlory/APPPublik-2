package com.skripsi23.appubblik.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.skripsi23.appubblik.Kelas.BookingRSUD;
import com.skripsi23.appubblik.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AdapterBookingRsud extends RecyclerView.Adapter<AdapterBookingRsud.MyViewHolder> {

    private Context mContext;
    private List<BookingRSUD> bookingList;
    DatabaseReference ref,refUser;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    Date date;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNama,txtNope,txtAlamat,txtJenisPoli,txtTime;
        public LinearLayout lyt_parent;

        public MyViewHolder(View view) {
            super(view);
            txtNama = (TextView) view.findViewById(R.id.txtNama);
            txtNope = (TextView) view.findViewById(R.id.txtNope);
            txtAlamat = (TextView) view.findViewById(R.id.txtAlamat);
            txtJenisPoli = (TextView) view.findViewById(R.id.txtJenisPoli);
            txtTime = (TextView) view.findViewById(R.id.txtTime);
            lyt_parent = view.findViewById(R.id.lyt_parent);

        }
    }


    public AdapterBookingRsud(Context mContext, List<BookingRSUD> bookingList) {
        this.mContext = mContext;
        this.bookingList = bookingList;

        Firebase.setAndroidContext(mContext);
        FirebaseApp.initializeApp(mContext);
        ref = FirebaseDatabase.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_booking_rsud, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        if (bookingList.isEmpty()){
            Toast.makeText(mContext.getApplicationContext(),"Data Kosong !",Toast.LENGTH_LONG).show();
            Log.d("isiBookingList: ",""+bookingList.size());
        }else {
            final BookingRSUD bookingRSUD = bookingList.get(position);

            holder.txtNama.setText(bookingRSUD.getNama());
            holder.txtNope.setText(bookingRSUD.getNope());
            holder.txtAlamat.setText(bookingRSUD.getAlamat());
            holder.txtJenisPoli.setText(bookingRSUD.getJenisPoli());

            String timestamp                = bookingRSUD.getTime();
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
        return  bookingList.size();
    }
}
