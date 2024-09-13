/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_Barang;

/**
 *
 * @author aridw
 */
public interface Service_Barang {
    void addData(Model_Barang mdBarang);
    void updateData(Model_Barang mdBarang);
    void deleteData(String id);
    
    Model_Barang getById(String Id);
    
    List<Model_Barang> getData();
    
    String nomor();
}
