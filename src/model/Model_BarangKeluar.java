/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aridw
 */
public class Model_BarangKeluar {
    private String id_barang_keluar;
    private String tgl_keluar;
    private int totalKeluar;
    private Model_Pengguna pengguna;

    public String getId_barang_keluar() {
        return id_barang_keluar;
    }

    public void setId_barang_keluar(String id_barang_keluar) {
        this.id_barang_keluar = id_barang_keluar;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public Model_Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Model_Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public int getTotalKeluar() {
        return totalKeluar;
    }

    public void setTotalKeluar(int totalKeluar) {
        this.totalKeluar = totalKeluar;
    }
    
}
