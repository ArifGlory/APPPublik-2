package com.skripsi23.appubblik.Kelas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookingRSUD implements Serializable {
    public String nama;
    public String umur;
    public String alamat;
    public String nope;
    public String jenisPoli;
    public String idBooking;
    public String idUser;
    public String time;

    public BookingRSUD(){

    }

    public BookingRSUD(String nama, String umur, String alamat, String nope,String jenisPoli,String idUser
                        ,String time) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.nope = nope;
        this.jenisPoli = jenisPoli;
        this.idUser = idUser;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJenisPoli() {
        return jenisPoli;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setJenisPoli(String jenisPoli) {
        this.jenisPoli = jenisPoli;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNope() {
        return nope;
    }

    public void setNope(String nope) {
        this.nope = nope;
    }
}
