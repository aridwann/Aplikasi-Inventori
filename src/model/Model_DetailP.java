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
public class Model_DetailP {
    private Model_Pemesanan pemesanan;
    private Model_Barang barang;
    private int jumlah_pemesanan;
    private int subtotal_pemesanan;
    private String status;

    public Model_Pemesanan getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Model_Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public Model_Barang getBarang() {
        return barang;
    }

    public void setBarang(Model_Barang barang) {
        this.barang = barang;
    }

    public int getJumlah_pemesanan() {
        return jumlah_pemesanan;
    }

    public void setJumlah_pemesanan(int jumlah_pemesanan) {
        this.jumlah_pemesanan = jumlah_pemesanan;
    }

    public int getSubtotal_pemesanan() {
        return subtotal_pemesanan;
    }

    public void setSubtotal_pemesanan(int subtotal_pemesanan) {
        this.subtotal_pemesanan = subtotal_pemesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
