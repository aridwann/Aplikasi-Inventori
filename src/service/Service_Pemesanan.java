/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_Pemesanan;

/**
 *
 * @author aridw
 */
public interface Service_Pemesanan {
    void addData(Model_Pemesanan mdPemesanan);
    Model_Pemesanan getById(String id);
    boolean checkStatus(String id);
    
    List<Model_Pemesanan> getData();
    
    String nomor();
}
