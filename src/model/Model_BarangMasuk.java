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
public class Model_BarangMasuk {
    private String id_barang_masuk;
    private String tgl_masuk;
    private Model_Distributor distributor;
    private int totalmasuk;
    private Model_Pengguna pengguna;
    private String status;

    public String getId_barang_masuk() {
        return id_barang_masuk;
    }

    public void setId_barang_masuk(String id_barang_masuk) {
        this.id_barang_masuk = id_barang_masuk;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Model_Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Model_Distributor distributor) {
        this.distributor = distributor;
    }

    public int getTotalmasuk() {
        return totalmasuk;
    }

    public void setTotalmasuk(int totalmasuk) {
        this.totalmasuk = totalmasuk;
    }

    public Model_Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Model_Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
