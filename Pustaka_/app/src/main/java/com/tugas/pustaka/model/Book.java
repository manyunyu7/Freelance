package com.tugas.pustaka.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("penulis")
    @Expose
    private String penulis;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("path_sampul")
    @Expose
    private String pathSampul;
    @SerializedName("path_buku")
    @Expose
    private String pathBuku;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPathSampul() {
        return pathSampul;
    }

    public void setPathSampul(String pathSampul) {
        this.pathSampul = pathSampul;
    }

    public String getPathBuku() {
        return pathBuku;
    }

    public void setPathBuku(String pathBuku) {
        this.pathBuku = pathBuku;
    }

}