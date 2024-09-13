/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Model_Pengguna;

/**
 *
 * @author aridw
 */
public interface Service_Daftar {
    void addData(Model_Pengguna mdPengguna);
    
    String nomor(String jabatan);
    String JChooser();
}
