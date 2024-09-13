/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_Pengguna;

/**
 *
 * @author aridw
 */
public interface Service_Kontak {
    Model_Pengguna getById(String id);
    Model_Pengguna getDataByNamaPengguna(String namaPengguna);
    List<Model_Pengguna> getData();
    
}
