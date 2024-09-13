/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_KeranjangMasuk;

/**
 *
 * @author aridw
 */
public interface Service_KeranjangMasuk {
    void addData(Model_KeranjangMasuk mdKM);
    void updateData(Model_KeranjangMasuk mdKM);
    void deleteData(String id);
    
    List<Model_KeranjangMasuk> getData();
   
}
