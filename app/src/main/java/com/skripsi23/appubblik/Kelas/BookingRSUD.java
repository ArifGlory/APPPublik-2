package com.skripsi23.appubblik.Kelas;

public class BookingRSUD {
    public String nama;
    public String umur;
    public String alamat;
    public String nope;
    public String jenisPoli;

    public BookingRSUD(){

    }

    public BookingRSUD(String nama, String umur, String alamat, String nope,String jenisPoli) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.nope = nope;
        this.jenisPoli = jenisPoli;
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
