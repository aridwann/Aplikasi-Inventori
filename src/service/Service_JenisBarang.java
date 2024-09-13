/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_Jenis;

/**
 *
 * @author aridw
 */
public interface Service_JenisBarang {
    void addData(Model_Jenis mdJenisBarang);
    void updateData(Model_Jenis mdJenisBarang);
    void deleteData(String id);
    
    Model_Jenis getById(String id);
    
    List<Model_Jenis> getData();
    
    String nomor();
    
    boolean validasiNamaJenisBarang(Model_Jenis mdJenisBarang);
}
