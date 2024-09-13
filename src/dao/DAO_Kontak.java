/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Pengguna;
import service.Service_Kontak;

/**
 *
 * @author aridw
 */
public class DAO_Kontak implements Service_Kontak{
    Connection conn;
    
    public DAO_Kontak(){
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
                mdPengguna.setId_pengguna(rs.getString("id_pengguna"));
                mdPengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mdPengguna.setTelp_pengguna(rs.getString("telp_pengguna"));
                mdPengguna.setAlamat_pengguna(rs.getString("alamat_pengguna"));
                mdPengguna.setFoto(rs.getString("foto"));
            }
            return mdPengguna;
        }catch(SQLException e){
            Logger.getLogger(DAO_Kontak.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Kontak.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_Pengguna> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pengguna";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Pengguna mdp = new Model_Pengguna();
                
                mdp.setId_pengguna(rs.getString("id_pengguna"));
                mdp.setNama_pengguna(rs.getString("nama_pengguna"));
                
                list.add(mdp);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_Kontak.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Kontak.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Kontak.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public Model_Pengguna getDataByNamaPengguna(String namaPengguna) {
    PreparedStatement st = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM pengguna WHERE nama_pengguna = ?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, namaPengguna);
        rs = st.executeQuery();
        if (rs.next()) {
            Model_Pengguna mdp = new Model_Pengguna();
            mdp.setNama_pengguna(rs.getString("nama_pengguna"));
            mdp.setTelp_pengguna(rs.getString("telp_pengguna"));
            mdp.setAlamat_pengguna(rs.getString("alamat_pengguna"));
            mdp.setJabatan(rs.getString("jabatan"));
            mdp.setFoto(rs.getString("foto"));
            
            return mdp;
        }
    } catch (SQLException e) {
        Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    return null;
}

    
}
