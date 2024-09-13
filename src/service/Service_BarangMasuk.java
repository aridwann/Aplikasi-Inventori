/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_BarangMasuk;

/**
 *
 * @author aridw
 */
public interface Service_BarangMasuk {
    void addData(Model_BarangMasuk mdBarangMasuk);
    void updateStok();
    void completeTheOrder(String id_pemesanan, String id_pengguna);
    void updateStokFromPemesanan(String id_pemesanan);
    
    Model_BarangMasuk getById(String id);
    
    List<Model_BarangMasuk> getData();
    
    String nomor();
}
