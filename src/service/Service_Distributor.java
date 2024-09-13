/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_Distributor;

/**
 *
 * @author aridw
 */
public interface Service_Distributor {
    void addData(Model_Distributor mdDistributor);
    void updateData(Model_Distributor mdDistributor);
    void deleteData(String id);
    
    Model_Distributor getById(String id);
    
    List<Model_Distributor> getData();
    
    String nomor();
}
