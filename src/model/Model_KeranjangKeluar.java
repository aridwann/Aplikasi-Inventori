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
public class Model_KeranjangKeluar {
    private Model_BarangKeluar barang_keluar;
    private Model_Barang barang;
    private Model_DetailBK detail_barang_keluar;

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

    public Model_DetailBK getDetail_barang_keluar() {
        return detail_barang_keluar;
    }

    public void setDetail_barang_keluar(Model_DetailBK detail_barang_keluar) {
        this.detail_barang_keluar = detail_barang_keluar;
    }

  
}
