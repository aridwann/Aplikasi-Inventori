/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Pengguna;

/**
 *
 * @author aridw
 */
public class DAO_MenuAkun implements service.Service_MenuAkun{
    Connection conn;
    
    public DAO_MenuAkun (){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public Model_Pengguna getById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Pengguna mdPengguna = null;
        String sql = "SELECT * FROM pengguna WHERE id_pengguna=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdPengguna = new Model_Pengguna();
                mdPengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mdPengguna.setJabatan(rs.getString("jabatan"));
                mdPengguna.setFoto(rs.getString("foto"));
            }
            return mdPengguna;
        }catch(SQLException e){
            Logger.getLogger(DAO_MenuAkun.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_MenuAkun.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
}
