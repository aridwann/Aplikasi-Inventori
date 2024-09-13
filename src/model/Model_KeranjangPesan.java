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
public class Model_KeranjangPesan {
    private Model_Pemesanan pemesanan;
    private Model_Barang barang;
    private Model_DetailP detail_pemesanan;

    public Model_Pemesanan getPemesanan() {
        return pemesanan;
    }

    public Model_Barang getBarang() {
        return barang;
    }

    public Model_DetailP getDetail_pemesanan() {
        return detail_pemesanan;
    }

    public void setPemesanan(Model_Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public void setBarang(Model_Barang barang) {
        this.barang = barang;
    }

    public void setDetail_pemesanan(Model_DetailP detail_pemesanan) {
        this.detail_pemesanan = detail_pemesanan;
    }

}
