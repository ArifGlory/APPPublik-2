package com.skripsi23.appubblik.Kelas;

/**
 * Created by Asus on 14/04/2019.
 */

public class Laporan  {

    String nama;
    String nohp;
    String lokasi;
    String laporan;
    String userID;
    String time;

    public Laporan(){

    }

    public Laporan(String nama, String nohp, String lokasi, String laporan,String userID) {
        this.nama = nama;
        this.nohp = nohp;
        this.lokasi = lokasi;
        this.laporan = laporan;
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getLaporan() {
        return laporan;
    }

    public void setLaporan(String laporan) {
        this.laporan = laporan;
    }
}
