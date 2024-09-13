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
public class Model_DetailBM {
    private Model_BarangMasuk barang_masuk;
    private Model_Barang barang;
    private int jumlah_masuk;
    private int subtotal_masuk;
    private String status;

    public Model_BarangMasuk getBarang_masuk() {
        return barang_masuk;
    }

    public void setBarang_masuk(Model_BarangMasuk barang_masuk) {
        this.barang_masuk = barang_masuk;
    }

    public Model_Barang getBarang() {
        return barang;
    }

    public void setBarang(Model_Barang barang) {
        this.barang = barang;
    }

    public int getJumlah_masuk() {
        return jumlah_masuk;
    }

    public void setJumlah_masuk(int jumlah_masuk) {
        this.jumlah_masuk = jumlah_masuk;
    }

    public int getSubtotal_masuk() {
        return subtotal_masuk;
    }

    public void setSubtotal_masuk(int subtotal_masuk) {
        this.subtotal_masuk = subtotal_masuk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
