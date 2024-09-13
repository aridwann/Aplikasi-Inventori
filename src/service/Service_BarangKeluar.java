/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_BarangKeluar;

/**
 *
 * @author aridw
 */
public interface Service_BarangKeluar {
    void addData(Model_BarangKeluar mdBarangKeluar);
    void updateStok();
    
    Model_BarangKeluar getById(String id);
    
    List<Model_BarangKeluar> getData();
    
    String nomor();
}
