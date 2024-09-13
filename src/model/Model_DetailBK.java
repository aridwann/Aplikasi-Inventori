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
public class Model_DetailBK {
    private Model_BarangKeluar barang_keluar;
    private Model_Barang barang;
    private int jumlah_keluar;
    private int subtotal_keluar;

    public Model_BarangKeluar getBarang_keluar() {
        return barang_keluar;
    }

    public void setBarang_keluar(Model_BarangKeluar barang_keluar) {
        this.barang_keluar = barang_keluar;
    }

    public Model_Barang getBarang() {
        return barang;
    }

    public void setBarang(Model_Barang barang) {
        this.barang = barang;
    }

    public int getJumlah_keluar() {
        return jumlah_keluar;
    }

    public void setJumlah_keluar(int jumlah_keluar) {
        this.jumlah_keluar = jumlah_keluar;
    }

    public int getSubtotal_keluar() {
        return subtotal_keluar;
    }

    public void setSubtotal_keluar(int subtotal_keluar) {
        this.subtotal_keluar = subtotal_keluar;
    }
    
}
