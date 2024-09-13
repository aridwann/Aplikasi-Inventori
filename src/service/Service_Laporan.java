/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JPanel;

/**
 *
 * @author aridw
 */
public interface Service_Laporan {
    void laporan(JPanel jp, String file);
    void laporan1(JPanel jp, String file, String p1);
    void laporan1PopUp(String file, String p1);
    void laporan2(JPanel jp, String file, String p1, String p2);
}
