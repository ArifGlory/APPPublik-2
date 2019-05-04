package com.skripsi23.appubblik.Kelas;

/**
 * Created by Asus on 14/04/2019.
 */

public class Laporan {

    String nama;
    String nohp;
    String lokasi;
    String laporan;

    public Laporan(String nama, String nohp, String lokasi, String laporan) {
        this.nama = nama;
        this.nohp = nohp;
        this.lokasi = lokasi;
        this.laporan = laporan;
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
