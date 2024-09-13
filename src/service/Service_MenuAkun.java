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
public interface Service_MenuAkun {
    Model_Pengguna getById(String id);
}
