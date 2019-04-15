/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author my computer
 */
public class Asdos {
    String id;
    String nama;
    String jenisKelamin;
    String tanggalLahir;
    String noHp;
    String tupoksi;
    Dosen dosen = new Dosen();
    Blob fotoAsdos;  

    public Asdos(String id, String nama, String jenisKelamin, String tanggalLahir, String noHp, String tupoksi, Dosen dosen, Blob fotoAsdos) {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.noHp = noHp;
        this.tupoksi = tupoksi;
        this.dosen = dosen;
        this.fotoAsdos = fotoAsdos;
    }

    public Asdos(String id, String nama, String jenisKelamin, String tanggalLahir, String noHp, String tupoksi,int nipDosen,String namaDosen,Blob fotoAsdos) {
        dosen = new Dosen();
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.noHp = noHp;
        this.tupoksi = tupoksi;
        dosen.setNip(nipDosen);
        dosen.setNamadosen(namaDosen);
        this.dosen = dosen;
        this.fotoAsdos = fotoAsdos;
    } 

    public Asdos() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getTupoksi() {
        return tupoksi;
    }

    public void setTupoksi(String tupoksi) {
        this.tupoksi = tupoksi;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public Blob getFotoAsdos() {
        return fotoAsdos;
    }

    public void setFotoAsdos(Blob fotoAsdos) {
        this.fotoAsdos = fotoAsdos;
    }
    
}
