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
public interface Service_Pengguna {
    void updateData(Model_Pengguna mdPengguna);
    void deleteData(String id);
    
    Model_Pengguna getById(String id);
    
    List<Model_Pengguna> getData();
}
