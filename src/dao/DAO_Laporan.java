/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Koneksi;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import service.Service_Laporan;

/**
 *
 * @author aridw
 */
public class DAO_Laporan implements Service_Laporan{
    private Connection conn;

    public DAO_Laporan(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void laporan(JPanel jp, String file) {
        try{
            String reportPath = "src/Report/"+file+".jasper";
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, null, conn);
            
            jp.removeAll();
            jp.setLayout(new BorderLayout());
            jp.repaint();
            jp.add(new JRViewer(print));
            jp.revalidate();
        } catch (JRException ex) {
            Logger.getLogger(DAO_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    @Override
    public void laporan1PopUp(String file, String p1) {
       try{
            String reportPath = "src/Report/"+file+".jasper";
            
            HashMap<String, Object> parameters = new HashMap();
            parameters.put("p1", p1);
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(DAO_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void laporan1(JPanel jp, String file, String p1) {
       try{
            String reportPath = "src/Report/"+file+".jasper";
            
            HashMap<String, Object> parameters = new HashMap();
            parameters.put("p1", p1);
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            
            jp.removeAll();
            jp.setLayout(new BorderLayout());
            jp.repaint();
            jp.add(new JRViewer(print));
            jp.revalidate();
        } catch (JRException ex) {
            Logger.getLogger(DAO_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void laporan2(JPanel jp, String file, String p1, String p2) {
        try{
            String reportPath = "src/Report/"+file+".jasper";
            
            HashMap<String, Object> parameters = new HashMap();
            parameters.put("p1", p1);
            parameters.put("p2", p2);
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            
            jp.removeAll();
            jp.setLayout(new BorderLayout());
            jp.repaint();
            jp.add(new JRViewer(print));
            jp.revalidate();
        } catch (JRException ex) {
            Logger.getLogger(DAO_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
