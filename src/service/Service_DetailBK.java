/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_DetailBK;

/**
 *
 * @author aridw
 */
public interface Service_DetailBK {
    void addData(Model_DetailBK mdDetailBK);
    int sumTotal();
    void temporaryDelete();
    
    List<Model_DetailBK> getById(String id);
    List<Model_DetailBK> getData();
    
    boolean stokValidation(String id, int jumlah);
}
