/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import PreApp.Masuk;
import Main.Menu.MenuUtama;
import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Login;
import service.Service_Login;

/**
 *
 * @author aridw
 */
public class DAO_Masuk implements Service_Login {
    private Connection conn;
    
    public DAO_Masuk(){
        conn = Koneksi.getConnection();
    }

   
    @Override
    public void prosesLogin(Model_Login mdLogin) {
        PreparedStatement st = null;
        ResultSet rs;
        String Id, nama, jabatan, pathFoto, status;
        String sql = "SELECT * FROM pengguna WHERE(id_pengguna='"+mdLogin.getIdPengguna()+"' " +
                     "OR username='"+mdLogin.getUser()+"') " +
                     "AND password='"+mdLogin.getPw()+"'";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                Id = rs.getString("id_pengguna");
                nama = rs.getString("nama_pengguna");
                jabatan = rs.getString("jabatan");
                pathFoto = rs.getString("foto");
                status = rs.getString("Status");
                if(verifStatus(status)){
                    MenuUtama menu = new MenuUtama(Id, nama, jabatan, pathFoto);
                    menu.setVisible(true);
                    menu.revalidate();

                    Masuk masuk = new Masuk();
                    masuk.tutup = true;
                }else{
                    Masuk masuk = new Masuk();
                    masuk.tutup = false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                Masuk masuk = new Masuk();
                masuk.tutup = false;
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_Masuk.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Masuk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    private boolean verifStatus(String status){
        if(status.equals("Menunggu")){
            JOptionPane.showMessageDialog(null, "Akun Anda Menunggu Persetujuan Super Admin");
            return false;
        }else if(status.equals("Tidak Aktif")){
            JOptionPane.showMessageDialog(null, "Akun Anda Di Non Aktifkan, Butuh Persetujuan Super Admin");
            return false;
        }else{
            return true;
        }
    }
}
