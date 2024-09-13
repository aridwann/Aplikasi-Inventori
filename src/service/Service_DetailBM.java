/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_DetailBM;

/**
 *
 * @author aridw
 */
public interface Service_DetailBM {
    
    void addData(Model_DetailBM mdBM);
    int sumTotal();
    void temporaryDelete();
    
    List<Model_DetailBM> getById(String id);
    List<Model_DetailBM> getData();
}