/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_KeranjangKeluar;

/**
 *
 * @author aridw
 */
public interface Service_KeranjangKeluar {
    void addData(Model_KeranjangKeluar mdKK);
    void updateData(Model_KeranjangKeluar mdKK);
    void deleteData(String id);
    
    List<Model_KeranjangKeluar> getData();
   
}
