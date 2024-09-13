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
public class Model_Pemesanan {
    private String id_pemesanan;
    private String tgl_pemesanan;
    private Model_Distributor distributor;
    private int total_pemesanan;
    private Model_Pengguna pengguna;
    private String status;

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(String tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public Model_Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Model_Distributor distributor) {
        this.distributor = distributor;
    }

    public int getTotal_pemesanan() {
        return total_pemesanan;
    }

    public void setTotal_pemesanan(int total_pemesanan) {
        this.total_pemesanan = total_pemesanan;
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
