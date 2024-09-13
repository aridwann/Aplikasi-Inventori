/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_KeranjangPesan;

/**
 *
 * @author aridw
 */
public interface Service_KeranjangPesan {
    void addData(Model_KeranjangPesan mdKP);
    void updateData(Model_KeranjangPesan mdKP);
    void deleteData(String id);
    
    List<Model_KeranjangPesan> getData();
   
}
