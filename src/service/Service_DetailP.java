/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_DetailP;

/**
 *
 * @author aridw
 */
public interface Service_DetailP {
    
    void addData(Model_DetailP mdDetailP);
    int sumTotal();
    void temporaryDelete();
    
    List<Model_DetailP> getById(String id);
    List<Model_DetailP> getData();
}