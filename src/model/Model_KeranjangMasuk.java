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
public class Model_KeranjangMasuk {
    private Model_BarangMasuk barang_masuk;
    private Model_Barang barang;
    private Model_DetailBM detail_barang_masuk;

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

    public Model_DetailBM getDetail_barang_masuk() {
        return detail_barang_masuk;
    }

    public void setDetail_barang_masuk(Model_DetailBM detail_barang_masuk) {
        this.detail_barang_masuk = detail_barang_masuk;
    }

    
}
