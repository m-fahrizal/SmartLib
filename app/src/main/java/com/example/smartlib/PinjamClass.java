package com.example.smartlib;

public class PinjamClass {
    private String namaBuku, penulis, tahun;
    private Integer idBuku;

    public PinjamClass(){}

    public PinjamClass(String namaBuku, String penulis, String tahun, Integer idBuku) {

        this.namaBuku = namaBuku;
        this.penulis = penulis;
        this.tahun = tahun;
        this.idBuku = idBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }
}
