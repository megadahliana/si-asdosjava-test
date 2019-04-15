/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author my computer
 */
public class Dosen {
    private int nip;
    private String namadosen;
    private String alamat;
    private String nohp;
    private String matakuliah;  

    public Dosen(int nip, String namadosen, String alamat, String nohp, String matakuliah) {
        this.nip = nip;
        this.namadosen = namadosen;
        this.alamat = alamat;
        this.nohp = nohp;
        this.matakuliah = matakuliah;
    }

    public Dosen(int nip, String namadosen) {
        this.nip = nip;
        this.namadosen = namadosen;
    }

    public Dosen() {
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNamadosen() {
        return namadosen;
    }

    public void setNamadosen(String namadosen) {
        this.namadosen = namadosen;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }  
}
