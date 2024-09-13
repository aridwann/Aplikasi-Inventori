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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Jenis;
import service.Service_JenisBarang;


/**
 *
 * @author aridw
 */
public class DAO_JenisBarang implements Service_JenisBarang{
    private Connection conn;
    
    public DAO_JenisBarang(){
        conn = Koneksi.getConnection();
    }

    @Override
    public void addData(Model_Jenis mdJenisBarang) {
        PreparedStatement st = null;
        String sql = "INSERT INTO jenis_barang(id_jenis, nama_jenis) VALUES(?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdJenisBarang.getId_jenis());
            st.setString(2, mdJenisBarang.getNama_jenis());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public void updateData(Model_Jenis mdJenisBarang){
        PreparedStatement st = null;
        String sql = "UPDATE jenis_barang SET nama_jenis=? WHERE kode_jenis=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdJenisBarang.getNama_jenis());
            st.setString(2, mdJenisBarang.getId_jenis());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public void deleteData(String id){
        PreparedStatement st = null;
        String sql = "DELETE FROM jenis_barang WHERE id_jenis=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public Model_Jenis getById(String id){
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Jenis mdJenisBarang = null;
        String sql = "SELECT * FROM jenis_barang WHERE id_jenis=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdJenisBarang = new Model_Jenis();
                mdJenisBarang.setId_jenis(rs.getString("id_jenis"));
                mdJenisBarang.setNama_jenis(rs.getString("nama_jenis"));
            }
            return mdJenisBarang;
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }   
    
    @Override
    public List<Model_Jenis> getData(){
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM jenis_barang";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Jenis mdJenisBarang = new Model_Jenis();
                mdJenisBarang.setId_jenis(rs.getString("id_jenis"));
                mdJenisBarang.setNama_jenis(rs.getString("nama_jenis"));
                
                list.add(mdJenisBarang);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
        String sql = "SELECT RIGHT(id_jenis, 5) AS id FROM jenis_barang ORDER BY id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("id"));
                noId++;
                id = String.format("JB%05d", noId);
            }else{
                id = "JB00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }

    @Override
    public boolean validasiNamaJenisBarang(Model_Jenis mdJenisBarang) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean isValid = false;
        String sql = "SELECT nama_jenis FROM jenis_barang WHERE id_jenis != '" + mdJenisBarang.getId_jenis() + "' AND nama_jenis LIKE BINARY '" + mdJenisBarang.getNama_jenis() + "';";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Nama Jenis Barang Sudah Ada", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }else{
                isValid = true;
            }
        }catch(SQLException e){
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
        }
        return isValid;
    }
}
